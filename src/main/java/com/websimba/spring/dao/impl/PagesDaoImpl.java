package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.PagesDao;
import com.websimba.spring.entity.Pages;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagesDaoImpl implements PagesDao {

    private static final Logger logger = LoggerFactory.getLogger(PagesDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Pages pages) {
        try {
            session.getCurrentSession().save(pages);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add pages");
        }
    }

    @Override
    public void edit(Pages pages) {
        try {
            String hql = "update from Pages set pageId = :newid,title = :newtitle, alias = :newalias, description = :newdescription, keywords = :newkeywords, content = :newcontent, img = :newimg, position = :newposition where pageId = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",pages.getPageId());
            query.setString("newtitle",pages.getTitle());
            query.setString("newalias",pages.getAlias());
            query.setString("newdescription",pages.getDescription());
            query.setString("newkeywords",pages.getKeywords());
            query.setString("newcontent",pages.getContent());
            query.setString("newimg",pages.getImg());
            query.setInteger("newposition",pages.getPosition());

            query.setInteger("id",pages.getPageId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE pages: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit pages");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Pages where pageId = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE pages: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete pages");
        }
    }

    @Override
    public Pages getPages(int id) {
        Pages pages = new Pages();
        try {
            pages = (Pages) session.getCurrentSession().get(Pages.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error pages");
        }
        return pages;
    }

    @Override
    public List<Pages> getAllPages() {
        List<Pages> pages = null;
        try {
            pages = session.getCurrentSession().createQuery("from Pages ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list pages");
        }
        return pages;
    }
}
