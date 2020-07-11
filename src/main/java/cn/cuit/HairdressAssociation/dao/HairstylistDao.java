package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Appointment;
import cn.cuit.HairdressAssociation.model.Hairstylist;
import cn.cuit.HairdressAssociation.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HairstylistDao {

    void addHairstylist(Hairstylist hairstylist);

    Hairstylist getHairstylist(int id);

    List<Hairstylist> getAllHairstylist(int id);

    void deleteHairstylist(int id);
}
