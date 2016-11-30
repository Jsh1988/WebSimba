package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.BxsliderDao;
import com.websimba.spring.entity.Bxslider;
import com.websimba.spring.service.interfaces.BxsliderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BxsliderServiceImpl implements BxsliderService {

    private static final Logger logger = LoggerFactory.getLogger(BxsliderServiceImpl.class);

    @Autowired
    private BxsliderDao bxsliderDao;

    @Transactional
    public void add(Bxslider bxslider) {
        bxsliderDao.add(bxslider);
    }

    @Transactional
    public void edit(Bxslider bxslider) {
        bxsliderDao.edit(bxslider);
    }

    @Transactional
    public void delete(int id) {
        bxsliderDao.delete(id);
    }

    @Transactional
    public Bxslider getBxslider(int id) {
        return bxsliderDao.getBxslider(id);
    }

    @Transactional
    public List<Bxslider> getAllBxslider() {
        return bxsliderDao.getAllBxslider();
    }
}
