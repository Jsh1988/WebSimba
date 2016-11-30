package com.websimba.spring.service.interfaces;

import com.websimba.spring.entity.Comments;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface CommentsService {
    public void add(Comments comments);
    public void edit(Comments comments);
    public void delete(int id);
    public Comments getComments(int id);
    @Secured("ROLE_ADMIN")
    public List<Comments> getAllComments();
}
