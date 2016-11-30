package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.IpsDao;
import com.websimba.spring.entity.Ips;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IpsDaoImpl implements IpsDao {

    private static final Logger logger = LoggerFactory.getLogger(IpsDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Ips ips) {
        try {
            session.getCurrentSession().save(ips);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add ips");
        }
    }

    @Override
    public void edit(Ips ips) {
        try {
            String hql = "update from Ips set id = :newid, ipAdress = :newipadress where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",ips.getId());
            query.setString("newipadress",ips.getIpAdress());

            query.setInteger("id",ips.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE ips: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit ips");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Ips where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE ips: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete ips");
        }
    }

    @Override
    public Ips getIps(int id) {
        Ips ips = new Ips();
        try {
            ips = (Ips) session.getCurrentSession().get(Ips.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error ips");
        }
        return ips;
    }

    @Override
    public List<Ips> getAllIps() {
        List<Ips> ips = null;
        try {
            ips = session.getCurrentSession().createQuery("from Ips ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list ips");
        }
        return ips;
    }
}
