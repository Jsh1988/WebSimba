package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Ips;

import java.util.List;

public interface IpsDao {
    public void add(Ips ips);
    public void edit(Ips ips);
    public void delete(int id);
    public Ips getIps(int id);
    public List<Ips> getAllIps();
}
