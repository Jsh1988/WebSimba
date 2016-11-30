package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.UserReg;
import com.websimba.spring.entity.Users;

import java.util.List;

public interface UsersDao {
    public void add(Users users);
    public void addReg(UserReg userReg);
    public void edit(Users users);
    public void delete(int id);
    public Users getUsers(int id);
    public List<Users> getAllUsers();
}
