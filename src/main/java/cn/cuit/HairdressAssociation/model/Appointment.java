package cn.cuit.HairdressAssociation.model;

import java.util.Date;

public class Appointment {
    private Integer appoint_id;
    private String user_id;
    private String shop_id;
    private String hairstylist_id;
    private String type_id;
    private int status;
    private Date appoint_time;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getAppoint_id() {
        return appoint_id;
    }

    public void setAppoint_id(Integer appoint_id) {
        this.appoint_id = appoint_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getHairstylist_id() {
        return hairstylist_id;
    }

    public void setHairstylist_id(String hairstylist_id) {
        this.hairstylist_id = hairstylist_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Date getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(Date appoint_time) {
        this.appoint_time = appoint_time;
    }

}
