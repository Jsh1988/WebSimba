package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.CategoriesDao;
import com.websimba.spring.entity.Categories;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {

    private static final Logger logger = LoggerFactory.getLogger(CategoriesDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Categories categories) {
        try {
            session.getCurrentSession().save(categories);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add categories");
        }
    }


    @Override
    public void edit(Categories categories) {
        try {
            String hql = "update from Categories set id = :newid,title = :newtitle,alias = :newalias, parent = :newparent where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",categories.getId());
            query.setString("newtitle",categories.getTitle());
            query.setString("newalias",categories.getAlias());
            query.setInteger("newparent",categories.getParent());

            query.setInteger("id",categories.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE CAT: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error update categories");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Categories where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE CAT: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete categories");
        }
    }

    @Override
    public Categories getCategories(int id) {
        Categories categories = new Categories();
        try {
            categories = (Categories) session.getCurrentSession().get(Categories.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error categories");
        }
        return categories;
    }

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categories = null;
        try {
            categories = session.getCurrentSession().createQuery("from Categories").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list categories");
        }
        return categories;
    }
}
