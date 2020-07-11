package cn.cuit.HairdressAssociation.controller;

import cn.cuit.HairdressAssociation.model.Appointment;
import cn.cuit.HairdressAssociation.service.AppointmentService;
import cn.cuit.HairdressAssociation.service.HairstylistService;
import cn.cuit.HairdressAssociation.service.ShopService;
import cn.cuit.HairdressAssociation.service.TypeService;
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
public class AppointmentController {
    @Autowired
    TypeService typeService;
    @Autowired
    HairstylistService hairstylistService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    ShopService shopService;

    @RequestMapping("appointment")
    public String myappointment(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies !=null) {
            for (Cookie c : cookies) {
                if ("id".equals(c.getName())) {
                    if (c.getValue() != null && !c.getValue().equals("")) {
                        List<Appointment> appoint = appointmentService.getAppointById(Integer.parseInt(c.getValue()));
                        try {
                            for(Appointment appointment:appoint){
                                appointment.setShop_id(shopService.getShop(Integer.parseInt(appointment.getShop_id())).getShop_name());
                                appointment.setHairstylist_id(hairstylistService.getHairstylist(Integer.parseInt(appointment.getHairstylist_id())).getName());
                                appointment.setType_id(typeService.getType(Integer.parseInt(appointment.getType_id())).getType_name());
                            }
                        }catch (Exception E){
                        }

                        model.addAttribute("appoint", appoint);
                        return "appointment";
                    }
                }
            }
        }
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('请先登录！');</script>");
        return "user_login";
    }

    @RequestMapping("shop_appoint")
    public String shopappoint(Model model, HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
        List Types = typeService.getAllType(id);
        List hairstylist = hairstylistService.getAllHairstylist(id);
        model.addAttribute("Types", Types);
        model.addAttribute("hairstylist", hairstylist);
        return "shop_appoint";


    }
    //通过预约
    @RequestMapping("passappoint")
    public String passappoint(Model model, HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
        appointmentService.passAppoint(id);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('此订单已通过预约！');</script>");
        return "shop_appoint_edit";


    }

    //完成订单
    @RequestMapping("endappoint")
    public String endappoint(Model model, HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
        appointmentService.endAppoint(id);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('此订单已完成！');</script>");
        return "shop_appoint_edit";


    }



    @RequestMapping("shop_postappoint")
    public String shop_postappoint(Model model, HttpServletRequest request, HttpServletResponse response, Appointment appointment) throws IOException {
        appointmentService.addAppoint(appointment);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('预约成功，请注意查看预约状态！');</script>");
        return "shop_appoint";


    }
    @RequestMapping("deleteappoint")
    public String deleteappoint(Model model, HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
        appointmentService.deleteAppoint(id);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write("<script language='javascript'>alert('取消预约成功');</script>");
        return "appointment";


    }


}

