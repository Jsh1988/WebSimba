package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Bxslider;

import java.util.List;

public interface BxsliderDao {
    public void add(Bxslider bxslider);
    public void edit(Bxslider bxslider);
    public void delete(int id);
    public Bxslider getBxslider(int id);
    public List<Bxslider> getAllBxslider();
}
