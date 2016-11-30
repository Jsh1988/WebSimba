package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.PersistentLogins;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface PersistentLoginsService {
    public void delete(String username);
    @Secured("ROLE_ADMIN")
    public List<PersistentLogins> getAllPersistentLogins();
}
