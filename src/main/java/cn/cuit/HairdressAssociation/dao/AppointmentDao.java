package cn.cuit.HairdressAssociation.dao;

import cn.cuit.HairdressAssociation.model.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AppointmentDao {
    void addAppoint(Appointment appointment);

    List<Appointment> getAppointById(int id);

    List<Appointment> getAllAppoint(int id);

    void passAppoint(int id);

    void endAppoint(int id);

    void deleteAppoint(int id);

}
