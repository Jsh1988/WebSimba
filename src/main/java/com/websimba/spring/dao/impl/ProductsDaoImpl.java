package com.websimba.spring.dao.impl;

import com.websimba.spring.dao.interfaces.ProductsDao;
import com.websimba.spring.entity.Products;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDaoImpl implements ProductsDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductsDaoImpl.class);

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Products products) {
        try {
            session.getCurrentSession().save(products);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error add products");
        }
    }

    @Override
    public void edit(Products products) {
        try {
            String hql = "update from Products set id = :newid, title = :newtitle, alias = :newalias, parent = :newparent, discription=:newdiscription, content=:newcontent, img=:newimg, price=:newprice, descriptions=:newdescriptions, keywords=:newkeywords, date=:newdate, hosts=:newhosts, views=:newviews where id = :id ";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("newid",products.getId());
            query.setString("newtitle",products.getTitle());
            query.setString("newalias",products.getAlias());
            query.setInteger("newparent",products.getParent());
            query.setText("newdiscription",products.getDiscription());
            query.setText("newcontent",products.getContent());
            query.setString("newimg",products.getImg());
            query.setInteger("newprice",products.getPrice());
            query.setString("newdescriptions",products.getDescriptions());
            query.setString("newkeywords",products.getKeywords());
            query.setDate("newdate",products.getDate());
            query.setInteger("newhosts",products.getHosts());
            query.setInteger("newviews",products.getViews());

            query.setInteger("id",products.getId());

            int rowCount = query.executeUpdate();
            System.out.println("UPDATE products: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error edit products");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String hql = "delete from Products where id = :id";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setInteger("id", id );
            int rowCount = query.executeUpdate();
            System.out.println("DELETE products: " + rowCount);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error delete products");
        }
    }

    @Override
    public Products getProducts(int id) {
        Products products = new Products();
        try {
            products = (Products) session.getCurrentSession().get(Products.class,id);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error products");
        }
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> products = null;
        try {
            products = session.getCurrentSession().createQuery("from Products ").list();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error list products");
        }
        return products;
    }
}
