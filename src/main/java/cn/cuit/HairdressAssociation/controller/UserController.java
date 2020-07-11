package cn.cuit.HairdressAssociation.controller;


import cn.cuit.HairdressAssociation.model.DataResponseVO;
import cn.cuit.HairdressAssociation.model.User;
import cn.cuit.HairdressAssociation.service.ArticleService;
import cn.cuit.HairdressAssociation.service.UserService;
import com.mysql.jdbc.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    //用户登录
    @RequestMapping("/userlogin")
    public String login(Model model, String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = userService.login(username, password);
        if (username == null) {
            return "user_login";
        }
        if (user != null) {
            request.getSession().setAttribute("user", user);
            model.addAttribute("user", user);
            //添加cookie
            Cookie cookie1 = new Cookie("username",user.getUsername());
            Cookie cookie2 = new Cookie("id",user.getId().toString());
            cookie1.setPath(request.getContextPath()+"/");
            cookie1.setMaxAge(30*60);
            cookie2.setPath(request.getContextPath()+"/");
            cookie2.setMaxAge(30*60);

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<script language='javascript'>alert('登录成功');</script>");
            List article = articleService.getArticles();
            model.addAttribute("article",article);
            return "index";
        } else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<script language='javascript'>alert('账号或密码输入错误，请重新输入！');</script>");
            return "user_login";
        }
    }

    //用户注册
    @RequestMapping("/userres")
    public String res(User user,HttpServletResponse response) throws IOException {
        if (user.getUsername() == null) {
            return "user_res";
        }
        userService.res(user);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('注册成功，跳转到登录');</script>");
        return "user_login";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }


    //用户退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("username",null);
        cookie.setMaxAge(0);//设置存活时间，“0”即马上消失
        cookie.setPath("/");
        response.addCookie(cookie);
        return "user_login";

    }
    @RequestMapping("/admin")
    public  String admin(){
        return "/admin";
    }

    @RequestMapping("/adminindex")
    public  String adminindex(Model model,String username,String password,HttpServletResponse response) throws IOException {

            List article = articleService.getArticles();
            model.addAttribute("article", article);
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<script language='javascript'>alert('登录成功');</script>");
            return "/adminindex";


    }





}



