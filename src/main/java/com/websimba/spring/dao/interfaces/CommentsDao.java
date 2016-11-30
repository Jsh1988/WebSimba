package com.websimba.spring.dao.interfaces;

import com.websimba.spring.entity.Comments;

import java.util.List;

public interface CommentsDao {
    public void add(Comments comments);
    public void edit(Comments comments);
    public void delete(int id);
    public Comments getComments(int id);
    public List<Comments> getAllComments();
}
