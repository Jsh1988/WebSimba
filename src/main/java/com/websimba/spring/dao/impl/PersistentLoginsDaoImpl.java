package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.PersistentLoginsDao;
import com.websimba.spring.entity.PersistentLogins;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersistentLoginsDaoImpl implements PersistentLoginsDao {

    private static final Logger logger = LoggerFactory.getLogger(PersistentLoginsDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void delete(String username) {
        try {
            String hql = "delete from PersistentLogins where username = :username";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setString("username", username );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE PersistentLogins: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete PersistentLogins");
        }
    }

    @Override
    public List<PersistentLogins> getAllPersistentLogins() {
        List<PersistentLogins> persistentLoginses = null;
        try {
            persistentLoginses = session.getCurrentSession().createQuery("from PersistentLogins ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list PersistentLogins");
        }
        return persistentLoginses;
    }
}
