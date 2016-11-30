package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Forgot;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ForgotService {
    public void add(Forgot forgot);
    public void edit(Forgot forgot);
    public void delete(int id);
    public Forgot getForgot(int id);
    @Secured("ROLE_ADMIN")
    public List<Forgot> getAllForgot();
}
