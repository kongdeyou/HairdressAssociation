package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComment(int id);

    void addComment(Comment comment);
}
