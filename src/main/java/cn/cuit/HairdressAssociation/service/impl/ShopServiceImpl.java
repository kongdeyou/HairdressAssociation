package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.ShopDao;
import cn.cuit.HairdressAssociation.model.Shop;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    ShopDao dao = Mybatisutil.getSqlSession().getMapper(ShopDao.class);
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Shop shoplogin(String shop_username, String password) {
        return dao.shoplogin(shop_username,password);
    }

    @Override
    public Shop getShop(Integer id) {
        return dao.getShop(id);
    }

    @Override
    public List<Shop> getShops() {
        return dao.getShops();
    }

    @Override
    public Integer deleteShop(Integer id) {
        return dao.deleteShop(id);
    }

    @Override
    public void putShop(Shop shop) {
         dao.putShop(shop);
    }

    @Override
    public void postShop(String shop_username, String shop_name, String password) {
        dao.postShop(shop_username, shop_name, password);
    }
}
