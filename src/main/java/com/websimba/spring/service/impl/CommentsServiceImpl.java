package com.websimba.spring.service.impl;

import com.websimba.spring.dao.interfaces.CommentsDao;
import com.websimba.spring.entity.Comments;
import com.websimba.spring.service.interfaces.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    private static final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

    @Autowired
    private CommentsDao commentsDao;

    @Transactional
    public void add(Comments comments) {
        commentsDao.add(comments);
    }

    @Transactional
    public void edit(Comments comments) {
        commentsDao.edit(comments);
    }

    @Transactional
    public void delete(int id) {
        commentsDao.delete(id);
    }

    @Transactional
    public Comments getComments(int id) {
        return commentsDao.getComments(id);
    }

    @Transactional
    public List<Comments> getAllComments() {
        return commentsDao.getAllComments();
    }
}
