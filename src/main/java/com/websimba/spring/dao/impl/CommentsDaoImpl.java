package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.CommentsDao;
import com.websimba.spring.entity.Comments;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDaoImpl implements CommentsDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentsDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Comments comments) {
        try {
            session.getCurrentSession().save(comments);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add comments");
        }
    }

    @Override
    public void edit(Comments comments) {
        try {
            String hql = "update from Comments set id = :newid, firstname = :newfirstname, surname = :newsurname, content = :newcontent, parent=:newparent, idProduct=:newidProduct, date=:newdate, isAdmin=:newisAdmin where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",comments.getId());
            query.setString("newfirstname",comments.getFirstname());
            query.setString("newsurname",comments.getSurname());
            query.setString("newcontent",comments.getContent());
            query.setInteger("newparent",comments.getParent());
            query.setInteger("newidProduct",comments.getIdProduct());
            query.setDate("newdate",comments.getDate());
            query.setByte("newisAdmin",comments.getIsAdmin());


            query.setInteger("id",comments.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE comments: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit comments");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Comments where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE comments: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete comments");
        }
    }

    @Override
    public Comments getComments(int id) {
        Comments comments = new Comments();
        try {
            comments = (Comments) session.getCurrentSession().get(Comments.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error comments");
        }
        return comments;
    }

    @Override
    public List<Comments> getAllComments() {
        List<Comments> comments = null;
        try {
            comments = session.getCurrentSession().createQuery("from Comments ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list comments");
        }
        return comments;
    }
}
