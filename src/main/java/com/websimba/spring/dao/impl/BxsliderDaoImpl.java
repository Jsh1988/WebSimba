package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.BxsliderDao;
import com.websimba.spring.entity.Bxslider;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BxsliderDaoImpl implements BxsliderDao {

    private static final Logger logger = LoggerFactory.getLogger(BxsliderDaoImpl.class);

    @Autowired
    private SessionFactory session;


    @Override
    public void add(Bxslider bxslider) {
        try {
            session.getCurrentSession().save(bxslider);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add bxslider");
        }
    }

    @Override
    public void edit(Bxslider bxslider) {
        try {
            String hql = "update from Bxslider set id = :newid,title = :newtitle,images = :newimages, url = :newurl where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",bxslider.getId());
            query.setString("newtitle",bxslider.getTitle());
            query.setString("newimages",bxslider.getImages());
            query.setString("newurl",bxslider.getUrl());

            query.setInteger("id",bxslider.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE bxslider: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit bxslider");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Bxslider where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE bxslider: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete bxslider");
        }
    }

    @Override
    public Bxslider getBxslider(int id) {
        Bxslider bxslider = new Bxslider();
        try {
            bxslider = (Bxslider) session.getCurrentSession().get(Bxslider.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error bxslider");
        }
        return bxslider;
    }

    @Override
    public List<Bxslider> getAllBxslider() {
        List<Bxslider> bxslider = null;
        try {
            bxslider = session.getCurrentSession().createQuery("from Bxslider").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list bxslider");
        }
        return bxslider;
    }
}
