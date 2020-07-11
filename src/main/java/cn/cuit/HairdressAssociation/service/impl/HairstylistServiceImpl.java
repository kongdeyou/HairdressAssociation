package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.ArticleDao;
import cn.cuit.HairdressAssociation.dao.HairstylistDao;
import cn.cuit.HairdressAssociation.model.Hairstylist;
import cn.cuit.HairdressAssociation.model.Type;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.HairstylistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HairstylistServiceImpl implements HairstylistService {
    HairstylistDao dao = Mybatisutil.getSqlSession().getMapper(HairstylistDao.class);

    @Override
    public void addHairstylist(Hairstylist hairstylist) {
        dao.addHairstylist(hairstylist);
    }

    @Override
    public Hairstylist getHairstylist(int id) {
        return dao.getHairstylist(id);
    }

    @Override
    public List<Hairstylist> getAllHairstylist(int id) {
        return dao.getAllHairstylist(id);
    }

    @Override
    public void deleteHairstylist(int id) {
        dao.deleteHairstylist(id);
    }
}
