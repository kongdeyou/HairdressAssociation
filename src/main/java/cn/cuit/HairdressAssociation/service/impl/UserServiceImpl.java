package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.ArticleDao;
import cn.cuit.HairdressAssociation.dao.UserDao;
import cn.cuit.HairdressAssociation.model.User;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserDao dao = Mybatisutil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String username,String password) {
        return dao.login(username,password);
    }
    public void res(User user) {
         dao.res(user);
    }

    @Override
    public User finduser(int id) {
        return dao.finduser(id);
    }
}
