package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Shop;

import java.util.List;

public interface ShopService {
    Shop getShop(Integer id);

    List<Shop> getShops();

    Shop shoplogin(String shop_username, String password);

    Integer deleteShop(Integer id);

    void putShop(Shop shop);

    void postShop(String shop_username, String shop_name, String password);
}
