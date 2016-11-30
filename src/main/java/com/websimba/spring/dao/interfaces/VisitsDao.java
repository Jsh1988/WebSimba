package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Visits;

import java.util.List;

public interface VisitsDao {
    public void add(Visits visits);
    public void edit(Visits visits);
    public void delete(int id);
    public Visits getVisits(int id);
    public List<Visits> getAllVisits();
}
