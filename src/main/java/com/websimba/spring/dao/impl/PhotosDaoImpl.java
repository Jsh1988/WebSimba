package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.PhotosDao;
import com.websimba.spring.entity.Photos;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotosDaoImpl implements PhotosDao {

    private static final Logger logger = LoggerFactory.getLogger(PhotosDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Photos photos) {
        try {
            session.getCurrentSession().save(photos);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add photos");
        }
    }

    @Override
    public void edit(Photos photos) {
        try {
            String hql = "update from Photos set idPhoto = :newid, title = :newtitle, photo = :newphoto, parent = :newparent, photoDescription = :newphotoDescription, link = :newlink, mark = :newmark where idPhoto = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",photos.getIdPhoto());
            query.setString("newtitle",photos.getTitle());
            query.setString("newphoto",photos.getPhoto());
            query.setInteger("newparent",photos.getParent());
            query.setString("newphotoDescription",photos.getPhotoDescription());
            query.setString("newlink",photos.getLink());
            query.setInteger("newmark",photos.getMark());

            query.setInteger("id",photos.getIdPhoto());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE photos: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit photos");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Photos where idPhoto = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE photos: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete photos");
        }
    }

    @Override
    public Photos getPhotos(int id) {
        Photos photos = new Photos();
        try {
            photos = (Photos) session.getCurrentSession().get(Photos.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error photos");
        }
        return photos;
    }

    @Override
    public List<Photos> getAllPhotos() {
        List<Photos> photos = null;
        try {
            photos = session.getCurrentSession().createQuery("from Photos ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list photos");
        }
        return photos;
    }
}
