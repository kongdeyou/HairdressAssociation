package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Type;

import java.util.List;

public interface TypeService {
    void addType(Type type);

    Type getType(int id);

    List<Type> getAllType(int id);

    void deleteType(int id);
}

