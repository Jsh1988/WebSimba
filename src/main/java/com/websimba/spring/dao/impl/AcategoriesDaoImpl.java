package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.AcategoriesDao;
import com.websimba.spring.entity.Acategories;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcategoriesDaoImpl implements AcategoriesDao {

    private static final Logger logger = LoggerFactory.getLogger(AcategoriesDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Acategories acategories) {
        try {
            session.getCurrentSession().save(acategories);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add acategories");
        }
    }

    @Override
    public void edit(Acategories acategories) {
        try {
            String hql = "update from Acategories set id = :newid,title = :newtitle,alias = :newalias, parent = :newparent where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",acategories.getId());
            query.setString("newtitle",acategories.getTitle());
            query.setString("newalias",acategories.getAlias());
            query.setInteger("newparent",acategories.getParent());

            query.setInteger("id",acategories.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE Acat: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit acategories");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Acategories where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE Acat: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete acategories");
        }
    }

    @Override
    public Acategories getAcategories(int id) {
        Acategories acategories = new Acategories();
        try {
            acategories = (Acategories) session.getCurrentSession().get(Acategories.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error acategories");
        }
        return acategories;
    }

    @Override
    public List<Acategories> getAllAcategories() {
        List<Acategories> acategories = null;
        try {
            acategories = session.getCurrentSession().createQuery("from Acategories").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list acategories");
        }
        return acategories;
    }

}
