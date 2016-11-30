package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Role;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface RoleService {
    public void add(Role role);
    public void edit(Role role);
    public void delete(int id);
    public Role getRole(int id);
    @Secured("ROLE_ADMIN")
    public List<Role> getAllRole();
}
