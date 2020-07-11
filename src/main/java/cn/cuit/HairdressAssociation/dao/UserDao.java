package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

     User login(String username,String password);
     void res(User user);
     User finduser(int id);
}
