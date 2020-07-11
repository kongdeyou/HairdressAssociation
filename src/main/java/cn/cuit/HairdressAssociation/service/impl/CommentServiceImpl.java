package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.CommentDao;
import cn.cuit.HairdressAssociation.dao.ShopDao;
import cn.cuit.HairdressAssociation.model.Comment;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentDao dao = Mybatisutil.getSqlSession().getMapper(CommentDao.class);
    @Override
    public List<Comment> getComment(int id) {
        return dao.getComment(id);
    }

    @Override
    public void addComment(Comment comment) {
        dao.addComment(comment);
    }
}
