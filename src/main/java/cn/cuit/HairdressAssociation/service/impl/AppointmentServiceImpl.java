package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.AppointmentDao;
import cn.cuit.HairdressAssociation.model.Appointment;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentDao dao = Mybatisutil.getSqlSession().getMapper(AppointmentDao.class);
    @Override
    public void addAppoint(Appointment appointment) {
        dao.addAppoint(appointment);
    }

    @Override
    public List<Appointment> getAppointById(int id) {
        return dao.getAppointById(id);
    }

    @Override
    public List<Appointment> getAllAppoint(int id) {
        return dao.getAllAppoint(id);
    }

    @Override
    public void passAppoint(int id) {
        dao.passAppoint(id);

    }

    @Override
    public void endAppoint(int id) {
        dao.endAppoint(id);
    }

    @Override
    public void deleteAppoint(int id) {
        dao.deleteAppoint(id);
    }
}
