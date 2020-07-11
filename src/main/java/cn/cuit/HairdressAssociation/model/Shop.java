package cn.cuit.HairdressAssociation.model;

public class Shop {
    private Integer id;
    private String shop_name;
    private String password;
    private String address;
    private String tel;
    private String image;
    private String details;
    private String shop_username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getShop_username() {
        return shop_username;
    }

    public void setShop_username(String shop_username) {
        this.shop_username = shop_username;
    }
}
