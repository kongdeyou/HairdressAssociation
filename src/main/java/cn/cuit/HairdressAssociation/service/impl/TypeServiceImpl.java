package cn.cuit.HairdressAssociation.service.impl;

import cn.cuit.HairdressAssociation.dao.ArticleDao;
import cn.cuit.HairdressAssociation.dao.TypeDao;
import cn.cuit.HairdressAssociation.model.Type;
import cn.cuit.HairdressAssociation.mybatisutil.Mybatisutil;
import cn.cuit.HairdressAssociation.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    TypeDao dao = Mybatisutil.getSqlSession().getMapper(TypeDao.class);

    @Override
    public void addType(Type type) {
        dao.addType(type);
    }

    @Override
    public Type getType(int id) {
        return dao.getType(id);
    }

    @Override
    public List<Type> getAllType(int id) {
        return dao.getAllType(id);
    }

    @Override
    public void deleteType(int id) {
        dao.deleteType(id);
    }
}
