package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopDao {
    Shop getShop(Integer id);

    List<Shop> getShops();

    void postShop(String shop_username, String shop_name, String password);

    Shop shoplogin(String shop_username,String password);

    void putShop(Shop Shop);

    Integer deleteShop(Integer id);
}
