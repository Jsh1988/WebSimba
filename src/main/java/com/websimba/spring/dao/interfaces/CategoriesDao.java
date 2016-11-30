package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Categories;

import java.util.List;

public interface CategoriesDao {
    public void add(Categories categories);
    public void edit(Categories categories);
    public void delete(int id);
    public Categories getCategories(int id);
    public List<Categories> getAllCategories();
}
