package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Appointment;

import java.util.List;

public interface AppointmentService {
    void addAppoint(Appointment appointment);

    List<Appointment> getAppointById(int id);

    List<Appointment> getAllAppoint(int id);

    void passAppoint(int id);

    void endAppoint(int id);

    void deleteAppoint(int id);
}
