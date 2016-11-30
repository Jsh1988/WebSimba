package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.ForgotDao;
import com.websimba.spring.entity.Forgot;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForgotDaoImpl implements ForgotDao {

    private static final Logger logger = LoggerFactory.getLogger(ForgotDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Forgot forgot) {
        try {
            session.getCurrentSession().save(forgot);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add forgot");
        }
    }

    @Override
    public void edit(Forgot forgot) {
        try {
            String hql = "update from Forgot set id = :newid, hash = :newhash, expire = :newexpire, email = :newemail where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",forgot.getId());
            query.setString("newhash",forgot.getHash());
            query.setInteger("newexpire",forgot.getExpire());
            query.setString("newemail",forgot.getEmail());

            query.setInteger("id",forgot.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE forgot: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit forgot");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Forgot where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE forgot: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete forgot");
        }
    }

    @Override
    public Forgot getForgot(int id) {
        Forgot forgot = new Forgot();
        try {
            forgot = (Forgot) session.getCurrentSession().get(Forgot.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error forgot");
        }
        return forgot;
    }

    @Override
    public List<Forgot> getAllForgot() {
        List<Forgot> forgot = null;
        try {
            forgot = session.getCurrentSession().createQuery("from Forgot").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list forgot");
        }
        return forgot;
    }
}
