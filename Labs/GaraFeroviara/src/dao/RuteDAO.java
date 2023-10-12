package dao;

import entity.Rute;

import java.util.List;

public interface RuteDAO extends BaseDAO<Integer, Rute>{
    List<Rute> findRutaByID(Integer id) throws DaoExeption;
}
