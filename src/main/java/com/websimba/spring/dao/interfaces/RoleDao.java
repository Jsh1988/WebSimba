package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Role;

import java.util.List;

public interface RoleDao {
    public void add(Role role);
    public void edit(Role role);
    public void delete(int id);
    public Role getRole(int id);
    public List<Role> getAllRole();
}
