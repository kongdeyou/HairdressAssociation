package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {
    Article getArticle(Integer id);

    List<Article> getArticles();

    Integer postArticle(Article newArticle);

    Integer putArticle(Article newArticle);

    Integer deleteArticle(Integer id);
}
