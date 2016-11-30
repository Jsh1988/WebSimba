package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.RoleDao;
import com.websimba.spring.entity.Role;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Role role) {
        try {
            session.getCurrentSession().save(role);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add role");
        }
    }

    @Override
    public void edit(Role role) {
        try {
            String hql = "update from Role set id = :newid,name = :newname where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",role.getId());
            query.setString("newname",role.getName());

            query.setInteger("id",role.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE role: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit role");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Role where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE role: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete role");
        }
    }

    @Override
    public Role getRole(int id) {
        Role role = new Role();
        try {
            role = (Role) session.getCurrentSession().get(Role.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error role");
        }
        return role;
    }

    @Override
    public List<Role> getAllRole() {
        List<Role> role = null;
        try {
            role = session.getCurrentSession().createQuery("from Role ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list role");
        }
        return role;
    }
}
