package cn.cuit.HairdressAssociation.controller;

import cn.cuit.HairdressAssociation.model.*;
import cn.cuit.HairdressAssociation.mybatisutil.FileService;
import cn.cuit.HairdressAssociation.service.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    CommentService commentService;
    @Autowired
    TypeService typeService;
    @Autowired
    HairstylistService hairstylistService;
    @Autowired
    UserService userService;


    @RequestMapping("/shoplist")
    public String getShops(Model model) {

        List<Shop> shoplist = shopService.getShops();
        for(Shop shop:shoplist){
            System.out.println(shop.getImage());
        }
        if(shoplist!=null) {
            model.addAttribute("shoplist", shoplist);
        }
        return "shoplist";
    }


    @RequestMapping("/shopres")
    public String addshop(String shop_username, String shop_name, String password, HttpServletResponse response) throws IOException {

        if (shop_username == null) {
            return "shop_res";
        }
        shopService.postShop(shop_username, shop_name, password);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('注册成功，跳转到商家登录');</script>");
        return "shop_login";
    }

    @RequestMapping("/shoplogin")
    public String shoplogin(Model model, String shop_username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (shop_username == null) {
            return "shop_login";
        }
        Shop shop = shopService.shoplogin(shop_username, password);

        if (shop != null) {
            request.getSession().setAttribute("shop", shop);
            model.addAttribute("shop", shop);
            //添加cookie
            Cookie cookie = new Cookie("shop_id", shop.getId().toString());
            cookie.setPath(request.getContextPath() + "/");
            cookie.setMaxAge(30 * 60);

            response.addCookie(cookie);
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<script language='javascript'>alert('商家登录成功');</script>");
            return "shopindex";
        } else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<script language='javascript'>alert('账号或密码输入错误，请重新输入！');</script>");
            return "shop_login";
        }
    }

    //商家用户首页
    @RequestMapping("/shopindex")
    public String shopindex(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("shop_id".equals(c.getName())) {
                    if (c.getValue() != null && !c.getValue().equals("")) {
                        Shop shop = shopService.getShop(Integer.parseInt(c.getValue()));
                        model.addAttribute("shop", shop);
                        return "shopindex";
                    }
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "shop_login";

    }

    //商家处理预约订单
    @RequestMapping("/shop_appoint_edit")
    public String shop_appoint_edit(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("shop_id".equals(c.getName())) {
                    if (c.getValue() != null && !c.getValue().equals("")) {
                        List<Appointment> appointments = appointmentService.getAllAppoint(Integer.parseInt(c.getValue()));
                        //状态0的订单为未处理订单，1为待进行订单，2为已完成订单
                        List<Appointment> appointments0 = new ArrayList<>();
                        List<Appointment> appointments1 = new ArrayList<>();
                        List<Appointment> appointments2 = new ArrayList<>();

                        try {
                            for (Appointment appointment : appointments) {

                                appointment.setUser_id(userService.finduser(Integer.parseInt(appointment.getUser_id())).getName());
                                appointment.setHairstylist_id(hairstylistService.getHairstylist(Integer.parseInt(appointment.getHairstylist_id())).getName());
                                appointment.setType_id(typeService.getType(Integer.parseInt(appointment.getType_id())).getType_name());
                                System.out.println(appointment.getUser_id());
                            }
                        } catch (Exception E) {
                        }
                        for (Appointment appointment : appointments) {
                            if (appointment.getStatus() == 0) {
                                appointments0.add(appointment);
                            }
                            if (appointment.getStatus() == 1) {
                                appointments1.add(appointment);
                            }
                            if (appointment.getStatus() == 2) {
                                appointments2.add(appointment);
                            }
                        }
                        model.addAttribute("appointments0", appointments0);
                        model.addAttribute("appointments1", appointments1);
                        model.addAttribute("appointments2", appointments2);
                        return "shop_appoint_edit";
                    }
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "shop_login";

    }

    //商家查看评论
    @RequestMapping("/shop_eval")
    public String shop_eval(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + c.getValue());
            if ("shop_id".equals(c.getName())) {
                if (c.getValue() != null && !c.getValue().equals("")) {
                    List<Comment> comment = commentService.getComment(Integer.parseInt(c.getValue()));
                    if (comment != null) {
                        model.addAttribute("comment", comment);
                    }
                    return "shop_eval";
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "user_login";

    }

    //商家管理店铺
    @RequestMapping("/shop_edit")
    public String shop_edit(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + c.getValue());
            if ("shop_id".equals(c.getName())) {
                if (c.getValue() != null && !c.getValue().equals("")) {
                    List<Type> type = typeService.getAllType(Integer.parseInt(c.getValue()));
                    List<Hairstylist> hairstylists = hairstylistService.getAllHairstylist(Integer.parseInt(c.getValue()));
                    if (type != null) {
                        model.addAttribute("type", type);
                    }
                    if (hairstylists != null) {
                        model.addAttribute("hairstylists", hairstylists);
                    }
                    return "shop_edit";
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "user_login";

    }

    //商家修改店铺信息
    @RequestMapping("/putshop")
    public String putshop(Model model, @RequestParam(value = "image") MultipartFile image,String shop_name,String address,String tel,String details, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + c.getValue());
            if ("shop_id".equals(c.getName())) {
                if (c.getValue() != null && !c.getValue().equals("")) {
                    Shop shop1 = new Shop();
                    shop1.setId(Integer.parseInt(c.getValue()));
                    shop1.setAddress(address);
                    shop1.setDetails(details);
                    shop1.setImage(image.getOriginalFilename());
                    shop1.setShop_name(shop_name);
                    shop1.setTel(tel);
                    shopService.putShop(shop1);
                    FileService fileService = new FileService();
                    fileService.upLoadFile(image,image.getOriginalFilename());
                    response.setContentType("text/html; charset=utf-8");
                    response.getWriter().write("<script language='javascript'>alert('修改成功！');</script>");
                    Shop shop = shopService.getShop(Integer.parseInt(c.getValue()));
                    model.addAttribute("shop", shop);
                    return "shopindex";
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('商家未登录！');</script>");
        return "shop_login";

    }

    //用户查看商家信息
    @RequestMapping("/shop_info")
    public String checkshop(Model model,int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Shop shop = shopService.getShop(id);
        model.addAttribute("shop", shop);
        return "shop_info";

    }

    @RequestMapping("/map")
    public String map(){

        return "map";

    }


}


