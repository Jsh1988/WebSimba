package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Photos;

import java.util.List;

public interface PhotosDao {
    public void add(Photos photos);
    public void edit(Photos photos);
    public void delete(int id);
    public Photos getPhotos(int id);
    public List<Photos> getAllPhotos();
}
