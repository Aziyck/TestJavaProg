package dao.Implements;

import dao.DaoExeption;
import dao.ZileDAO;
import entity.Locatii;
import entity.Zile;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZileDAOimpl implements ZileDAO {
    private static final String SQL_SELECT_ALL = "SELECT \"IDZiua\", \"NumeZi\" FROM public.\"Zile\";";
    private static final String SQL_INSERT = "INSERT INTO public.\"Zile\"(\"NumeZi\") VALUES (?);";
    @Override
    public List<Zile> findAll() throws DaoExeption {
        List<Zile> ziles = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Zile zile = new Zile();

                zile.setIdZiua(resultSet.getInt("IDZiua"));
                zile.setNumeZi(resultSet.getString("NumeZi"));

                ziles.add(zile);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return ziles;
    }

    @Override
    public Zile findEntityById(Integer id) throws DaoExeption {
        return null;
    }

    @Override
    public boolean delete(Zile zile) throws DaoExeption {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws DaoExeption {
        return false;
    }

    @Override
    public boolean create(Zile zile) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, zile.getNumeZi());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return bool;
    }

    @Override
    public Zile update(Zile zile) throws DaoExeption {
        return null;
    }
}
