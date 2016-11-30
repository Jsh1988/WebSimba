package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Acategories;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface AcategoriesService {
    public void add(Acategories acategories);
    public void edit(Acategories acategories);
    public void delete(int id);
    public Acategories getAcategories(int id);
    @Secured("ROLE_ADMIN")
    public List<Acategories> getAllAcategories();
}
