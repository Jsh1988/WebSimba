package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Products;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ProductsService {
    public void add(Products products);
    public void edit(Products products);
    public void delete(int id);
    public Products getProducts(int id);
    @Secured("ROLE_ADMIN")
    public List<Products> getAllProducts();
}
