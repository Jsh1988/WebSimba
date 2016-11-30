package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Photos;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface PhotosService {
    public void add(Photos photos);
    public void edit(Photos photos);
    public void delete(int id);
    public Photos getPhotos(int id);
    @Secured("ROLE_ADMIN")
    public List<Photos> getAllPhotos();
}
