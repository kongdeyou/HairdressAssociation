package cn.cuit.HairdressAssociation.controller;

import cn.cuit.HairdressAssociation.model.Comment;
import cn.cuit.HairdressAssociation.service.CommentService;
import cn.cuit.HairdressAssociation.service.TypeService;
import cn.cuit.HairdressAssociation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/shop_comment")
    public String getComment(Model model, int id, HttpServletRequest request,HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                System.out.println(c.getName() + c.getValue());
                if ("username".equals(c.getName())) {
                    if (c.getValue() != null && !c.getValue().equals("")) {
                        List<Comment> comment = commentService.getComment(id);
                        if (comment != null) {
                            model.addAttribute("comment", comment);
                        }
                        return "shop_comment";
                    }
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('需要登录才能查看店铺评论！');</script>");
        return "user_login";

    }

    @RequestMapping("/shop_postcomment")
    public String addComment(Model model, Comment comment, HttpServletResponse response) throws IOException {
        commentService.addComment(comment);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('评价成功');</script>");
        return "shop_comment";
    }
}
