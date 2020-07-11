package cn.cuit.HairdressAssociation.controller;

import cn.cuit.HairdressAssociation.model.Type;
import cn.cuit.HairdressAssociation.mybatisutil.FileService;
import cn.cuit.HairdressAssociation.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;

    @RequestMapping("/shop_type")
    public String getTypes(Model model,int id) {
        List<Type> Types = typeService.getAllType(id);
        model.addAttribute("Types", Types);
        return "shop_type";
    }
    @RequestMapping("/deletetype")
    public String deletetype(Model model,int id,HttpServletResponse response) throws IOException {
        typeService.deleteType(id);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('删除成功！');</script>");
        return "shop_edit";
    }
    @RequestMapping("posttype")
    public String posttype(Model model, @RequestParam(value = "image") MultipartFile image, String type_name, String content,String price, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + c.getValue());
            if ("shop_id".equals(c.getName())) {
                if (c.getValue() != null && !c.getValue().equals("")) {
                    Type type = new Type();
                    type.setShop_id(Integer.parseInt(c.getValue()));
                    type.setContent(content);
                    type.setImage(image.getOriginalFilename());
                    type.setPrice(price);
                    type.setType_name(type_name);

                    typeService.addType(type);
                    FileService fileService = new FileService();
                    fileService.upLoadFile(image,image.getOriginalFilename());
                    response.setContentType("text/html; charset=utf-8");
                    response.getWriter().write("<script language='javascript'>alert('添加成功！');</script>");
                    return "shop_edit";
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "shop_login";
    }
}
