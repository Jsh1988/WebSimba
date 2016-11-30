package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.IpsDao;
import com.websimba.spring.entity.Ips;
import com.websimba.spring.service.interfaces.IpsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IpsServiceImpl implements IpsService {

    private static final Logger logger = LoggerFactory.getLogger(IpsServiceImpl.class);

    @Autowired
    private IpsDao ipsDao;

    @Transactional
    public void add(Ips ips) {
        ipsDao.add(ips);
    }

    @Transactional
    public void edit(Ips ips) {
        ipsDao.edit(ips);
    }

    @Transactional
    public void delete(int id) {
        ipsDao.delete(id);
    }

    @Transactional
    public Ips getIps(int id) {
        return ipsDao.getIps(id);
    }

    @Transactional
    public List<Ips> getAllIps() {
        return ipsDao.getAllIps();
    }
}
