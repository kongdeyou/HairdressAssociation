package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Article;

import java.util.List;

public interface ArticleService {
    Article getArticle(Integer id);

    List<Article> getArticles();

    Integer postArticle(Article newArticle);

    Integer putArticle(Article newArticle);

    Integer deleteArticle(Integer id);

}
