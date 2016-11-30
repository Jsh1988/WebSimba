package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.UsersDao;
import com.websimba.spring.entity.UserReg;
import com.websimba.spring.entity.Users;
import com.websimba.spring.service.interfaces.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersDao usersDao;

    @Transactional
    public void add(Users users) {
        usersDao.add(users);
    }

    @Transactional
    public void addReg(UserReg userReg) {
        usersDao.addReg(userReg);
    }

    @Transactional
    public void edit(Users users) {
        usersDao.edit(users);
    }

    @Transactional
    public void delete(int id) {
        usersDao.delete(id);
    }

    @Transactional
    public Users getUsers(int id) {
        return usersDao.getUsers(id);
    }

    @Transactional
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

}
