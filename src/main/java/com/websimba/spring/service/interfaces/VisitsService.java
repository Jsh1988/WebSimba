package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Visits;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface VisitsService {
    public void add(Visits visits);
    public void edit(Visits visits);
    public void delete(int id);
    public Visits getVisits(int id);
    @Secured("ROLE_ADMIN")
    public List<Visits> getAllVisits();
}
