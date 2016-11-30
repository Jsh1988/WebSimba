package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.UserReg;
import com.websimba.spring.entity.Users;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface UsersService {
    public void add(Users users);
    public void addReg(UserReg userReg);
    public void edit(Users users);
    public void delete(int id);
    public Users getUsers(int id);
    @Secured("ROLE_ADMIN")
    public List<Users> getAllUsers();
}
