package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.RoleDao;
import com.websimba.spring.entity.Role;
import com.websimba.spring.service.interfaces.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public void add(Role role) {
        roleDao.add(role);
    }

    @Transactional
    public void edit(Role role) {
        roleDao.edit(role);
    }

    @Transactional
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Transactional
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Transactional
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}
