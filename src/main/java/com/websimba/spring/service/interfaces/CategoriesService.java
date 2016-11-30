package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Categories;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface CategoriesService {
    public void add(Categories categories);
    public void edit(Categories categories);
    public void delete(int id);
    public Categories getCategories(int id);
    @Secured("ROLE_ADMIN")
    public List<Categories> getAllCategories();
}
