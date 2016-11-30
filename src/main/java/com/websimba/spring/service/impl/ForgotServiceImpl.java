package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.ForgotDao;
import com.websimba.spring.entity.Forgot;
import com.websimba.spring.service.interfaces.ForgotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ForgotServiceImpl implements ForgotService {

    private static final Logger logger = LoggerFactory.getLogger(ForgotServiceImpl.class);

    @Autowired
    private ForgotDao forgotDao;

    @Transactional
    public void add(Forgot forgot) {
        forgotDao.add(forgot);
    }

    @Transactional
    public void edit(Forgot forgot) {
        forgotDao.edit(forgot);
    }

    @Transactional
    public void delete(int id) {
        forgotDao.delete(id);
    }

    @Transactional
    public Forgot getForgot(int id) {
        return forgotDao.getForgot(id);
    }

    @Transactional
    public List<Forgot> getAllForgot() {
        return forgotDao.getAllForgot();
    }
}
