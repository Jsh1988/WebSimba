package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Pages;

import java.util.List;

public interface PagesDao {
    public void add(Pages pages);
    public void edit(Pages pages);
    public void delete(int id);
    public Pages getPages(int id);
    public List<Pages> getAllPages();
}
