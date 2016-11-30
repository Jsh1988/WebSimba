package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.CategoriesDao;
import com.websimba.spring.entity.Categories;
import com.websimba.spring.service.interfaces.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);

    @Autowired
    private CategoriesDao categoriesDao;

    @Override
    @Transactional
    public void add(Categories categories) {
        categoriesDao.add(categories);
    }

    @Override
    @Transactional
    public void edit(Categories categories) {
        categoriesDao.edit(categories);
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoriesDao.delete(id);
    }

    @Override
    @Transactional
    public Categories getCategories(int id) {
        return categoriesDao.getCategories(id);
    }

    @Override
    @Transactional
    public List<Categories> getAllCategories() {
        return categoriesDao.getAllCategories();
    }
}
