package cn.cuit.HairdressAssociation.model;

public class Hairstylist {
    private Integer hairstylist_id;
    private int Shop_id;
    private String case_content;
    private String image;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHairstylist_id() {
        return hairstylist_id;
    }

    public void setHairstylist_id(Integer hairstylist_id) {
        this.hairstylist_id = hairstylist_id;
    }

    public int getShop_id() {
        return Shop_id;
    }

    public void setShop_id(int shop_id) {
        Shop_id = shop_id;
    }


    public String getCase_content() {
        return case_content;
    }

    public void setCase_content(String case_content) {
        this.case_content = case_content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
