package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Bxslider;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface BxsliderService {
    public void add(Bxslider bxslider);
    public void edit(Bxslider bxslider);
    public void delete(int id);
    public Bxslider getBxslider(int id);
    @Secured("ROLE_ADMIN")
    public List<Bxslider> getAllBxslider();
}
