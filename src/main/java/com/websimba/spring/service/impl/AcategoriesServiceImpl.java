package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.AcategoriesDao;
import com.websimba.spring.entity.Acategories;
import com.websimba.spring.service.interfaces.AcategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcategoriesServiceImpl implements AcategoriesService {

    private static final Logger logger = LoggerFactory.getLogger(AcategoriesServiceImpl.class);

    @Autowired
    private AcategoriesDao acategoriesDao;

    @Transactional
    public void add(Acategories acategories) {
        acategoriesDao.add(acategories);
    }

    @Transactional
    public void edit(Acategories acategories) {
        acategoriesDao.edit(acategories);
    }

    @Transactional
    public void delete(int id) {
        acategoriesDao.delete(id);
    }

    @Transactional
    public Acategories getAcategories(int id) {
        return acategoriesDao.getAcategories(id);
    }

    @Transactional
    public List<Acategories> getAllAcategories() {
        return acategoriesDao.getAllAcategories();
    }
}
