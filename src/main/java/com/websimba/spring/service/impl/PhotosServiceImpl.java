package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.PhotosDao;
import com.websimba.spring.entity.Photos;
import com.websimba.spring.service.interfaces.PhotosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhotosServiceImpl implements PhotosService {

    private static final Logger logger = LoggerFactory.getLogger(PhotosServiceImpl.class);

    @Autowired
    private PhotosDao photosDao;

    @Transactional
    public void add(Photos photos) {
        photosDao.add(photos);
    }

    @Transactional
    public void edit(Photos photos) {
        photosDao.edit(photos);
    }

    @Transactional
    public void delete(int id) {
        photosDao.delete(id);
    }

    @Transactional
    public Photos getPhotos(int id) {
        return photosDao.getPhotos(id);
    }

    @Transactional
    public List<Photos> getAllPhotos() {
        return photosDao.getAllPhotos();
    }
}
