package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.PersistentLoginsDao;
import com.websimba.spring.entity.PersistentLogins;
import com.websimba.spring.service.interfaces.PersistentLoginsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersistentLoginsServiceImpl implements PersistentLoginsService {

    private static final Logger logger = LoggerFactory.getLogger(PersistentLoginsServiceImpl.class);

    @Autowired
    private PersistentLoginsDao persistentLoginsDao;

    @Transactional
    public void delete(String username) {
        persistentLoginsDao.delete(username);
    }

    @Transactional
    public List<PersistentLogins> getAllPersistentLogins() {
        return persistentLoginsDao.getAllPersistentLogins();
    }
}
