package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.VisitsDao;
import com.websimba.spring.entity.Visits;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitsDaoImpl implements VisitsDao {

    private static final Logger logger = LoggerFactory.getLogger(VisitsDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Visits visits) {
        try {
            session.getCurrentSession().save(visits);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add visits");
        }
    }

    @Override
    public void edit(Visits visits) {
        try {
            String hql = "update from Visits set id = :newid, date = :newdate, hosts = :newhosts, views = :newviews where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",visits.getId());
            query.setDate("newdate",visits.getDate());
            query.setInteger("newhosts",visits.getHosts());
            query.setInteger("newviews",visits.getViews());

            query.setInteger("id",visits.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE visits: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit visits");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Visits where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE visits: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete visits");
        }
    }

    @Override
    public Visits getVisits(int id) {
        Visits visits = new Visits();
        try {
            visits = (Visits) session.getCurrentSession().get(Visits.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error visits");
        }
        return visits;
    }

    @Override
    public List<Visits> getAllVisits() {
        List<Visits> visits = null;
        try {
            visits = session.getCurrentSession().createQuery("from Visits ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list visits");
        }
        return visits;
    }
}
