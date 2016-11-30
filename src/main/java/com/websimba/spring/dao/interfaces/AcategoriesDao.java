package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Acategories;

import java.util.List;

public interface AcategoriesDao {
    public void add(Acategories acategories);
    public void edit(Acategories acategories);
    public void delete(int id);
    public Acategories getAcategories(int id);
    public List<Acategories> getAllAcategories();
}
