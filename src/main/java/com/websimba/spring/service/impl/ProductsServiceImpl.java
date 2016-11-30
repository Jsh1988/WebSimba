package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.ProductsDao;
import com.websimba.spring.entity.Products;
import com.websimba.spring.service.interfaces.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

    @Autowired
    private ProductsDao productsDao;

    @Transactional
    public void add(Products products) {
        productsDao.add(products);
    }

    @Transactional
    public void edit(Products products) {
        productsDao.edit(products);
    }

    @Transactional
    public void delete(int id) {
        productsDao.delete(id);
    }

    @Transactional
    public Products getProducts(int id) {
        return productsDao.getProducts(id);
    }

    @Transactional
    public List<Products> getAllProducts() {
        return productsDao.getAllProducts();
    }
}
