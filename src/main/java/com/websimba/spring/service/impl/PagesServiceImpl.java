package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.PagesDao;
import com.websimba.spring.entity.Pages;
import com.websimba.spring.service.interfaces.PagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagesServiceImpl implements PagesService{

    private static final Logger logger = LoggerFactory.getLogger(PagesServiceImpl.class);

    @Autowired
    private PagesDao pagesDao;

    @Transactional
    public void add(Pages pages) {
        pagesDao.add(pages);
    }

    @Transactional
    public void edit(Pages pages) {
        pagesDao.edit(pages);
    }

    @Transactional
    public void delete(int id) {
        pagesDao.delete(id);
    }

    @Transactional
    public Pages getPages(int id) {
        return pagesDao.getPages(id);
    }

    @Transactional
    public List<Pages> getAllPages() {
        return pagesDao.getAllPages();
    }
}
