package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.VisitsDao;
import com.websimba.spring.entity.Visits;
import com.websimba.spring.service.interfaces.VisitsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitsServiceImpl implements VisitsService {

    private static final Logger logger = LoggerFactory.getLogger(VisitsServiceImpl.class);

    @Autowired
    private VisitsDao visitsDao;

    @Transactional
    public void add(Visits visits) {
        visitsDao.add(visits);
    }

    @Transactional
    public void edit(Visits visits) {
        visitsDao.edit(visits);
    }

    @Transactional
    public void delete(int id) {
        visitsDao.delete(id);
    }

    @Transactional
    public Visits getVisits(int id) {
        return visitsDao.getVisits(id);
    }

    @Transactional
    public List<Visits> getAllVisits() {
        return visitsDao.getAllVisits();
    }
}
