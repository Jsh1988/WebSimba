package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Ips;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IpsService {
    public void add(Ips ips);
    public void edit(Ips ips);
    public void delete(int id);
    public Ips getIps(int id);
    @Secured("ROLE_ADMIN")
    public List<Ips> getAllIps();
}
