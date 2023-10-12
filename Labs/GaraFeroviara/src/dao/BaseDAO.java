package dao;

import entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDAO <K, T extends Entity> {
    List<T> findAll() throws DaoExeption;
    T findEntityById(K id) throws DaoExeption;
    boolean delete(T t) throws DaoExeption;
    boolean delete(K id) throws DaoExeption;
    boolean create(T t) throws DaoExeption;
    T update(T t) throws DaoExeption;

    default void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    default void close(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
