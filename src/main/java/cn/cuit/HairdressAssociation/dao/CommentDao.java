package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    List<Comment> getComment(int id);

    void addComment(Comment comment);
}
