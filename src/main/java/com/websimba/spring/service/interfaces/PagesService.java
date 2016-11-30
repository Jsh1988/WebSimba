package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Pages;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface PagesService {
    public void add(Pages pages);
    public void edit(Pages pages);
    public void delete(int id);
    public Pages getPages(int id);
    @Secured("ROLE_ADMIN")
    public List<Pages> getAllPages();
}
