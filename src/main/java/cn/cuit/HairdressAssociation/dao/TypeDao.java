package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Hairstylist;
import cn.cuit.HairdressAssociation.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {
    void addType(Type type);

    Type getType(int id);

    List<Type> getAllType(int id);

    void deleteType(int id);
}
