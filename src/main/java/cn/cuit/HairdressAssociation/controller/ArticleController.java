package cn.cuit.HairdressAssociation.controller;

import cn.cuit.HairdressAssociation.model.Article;
import cn.cuit.HairdressAssociation.model.DataResponseVO;
import cn.cuit.HairdressAssociation.model.ErrorCode;
import cn.cuit.HairdressAssociation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Article> article = articleService.getArticles();
        model.addAttribute("article", article);
        return "index";

    }
    @RequestMapping("/deletearticle")
    public String deletearticle(Model model,int id) {
        articleService.deleteArticle(id);
        List<Article> article = articleService.getArticles();
        model.addAttribute("article", article);
        return "adminindex";

    }

    @RequestMapping("/postarticle")
    public String postarticle(Model model,Article article,HttpServletResponse response) throws IOException {
        articleService.postArticle(article);

        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('提交成功');</script>");
        List<Article> article1 = articleService.getArticles();
        model.addAttribute("article1", article1);
        return "adminindex";

    }


}

