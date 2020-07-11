package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.ArticleDao;
import cn.cuit.HairdressAssociation.model.Article;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    ArticleDao dao = Mybatisutil.getSqlSession().getMapper(ArticleDao.class);

    @Override
    public Article getArticle(Integer id) {
        return dao.getArticle(id);
    }

    @Override
    public List<Article> getArticles() {
        return dao.getArticles();
    }

    @Override
    public Integer postArticle(Article newArticle) {
        return dao.postArticle(newArticle);
    }

    @Override
    public Integer putArticle(Article newArticle) {
        return dao.putArticle(newArticle);
    }

    @Override
    public Integer deleteArticle(Integer id) {
        return dao.deleteArticle(id);
    }
}
