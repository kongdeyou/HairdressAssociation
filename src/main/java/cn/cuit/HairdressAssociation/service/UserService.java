package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.User;

public interface UserService {
    User login(String username,String password);
    void res(User user);
    User finduser(int id);
}
