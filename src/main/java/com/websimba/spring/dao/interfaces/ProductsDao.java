package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Products;

import java.util.List;

public interface ProductsDao {
    public void add(Products products);
    public void edit(Products products);
    public void delete(int id);
    public Products getProducts(int id);
    public List<Products> getAllProducts();
}
