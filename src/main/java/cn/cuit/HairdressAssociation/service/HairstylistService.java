package cn.cuit.HairdressAssociation.service;

import cn.cuit.HairdressAssociation.model.Hairstylist;
import cn.cuit.HairdressAssociation.model.Type;

import java.util.List;

public interface HairstylistService {
    void addHairstylist(Hairstylist hairstylist);

    Hairstylist getHairstylist(int id);

    List<Hairstylist> getAllHairstylist(int id);

    void deleteHairstylist(int id);
}
