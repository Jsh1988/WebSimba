package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.PersistentLogins;

import java.util.List;

public interface PersistentLoginsDao {
    public void delete(String username);
    public List<PersistentLogins> getAllPersistentLogins();
}
