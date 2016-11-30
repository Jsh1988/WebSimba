package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Forgot;

import java.util.List;

public interface ForgotDao {
    public void add(Forgot forgot);
    public void edit(Forgot forgot);
    public void delete(int id);
    public Forgot getForgot(int id);
    public List<Forgot> getAllForgot();
}
