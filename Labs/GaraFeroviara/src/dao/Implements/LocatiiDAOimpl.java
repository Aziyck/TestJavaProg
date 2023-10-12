package dao.Implements;

import dao.DaoExeption;
import dao.LocatiiDAO;
import entity.Locatii;
import entity.Rute;
import jdk.jshell.spi.ExecutionControl;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocatiiDAOimpl implements LocatiiDAO {
    private static final String SQL_SELECT_ALL = "SELECT \"IDLocatie\", \"NumeLocatie\" FROM public.\"Locatii\";";
    private static final String SQL_INSERT = "INSERT INTO public.\"Locatii\"(\"NumeLocatie\") VALUES (?);";
    @Override
    public List<Locatii> findAll() throws DaoExeption {
        List<Locatii> locatiis = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Locatii locatii = new Locatii();

                locatii.setIdLocatie(resultSet.getInt("IDLocatie"));
                locatii.setNumeLocatie(resultSet.getString("NumeLocatie"));

                locatiis.add(locatii);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return locatiis;
    }

    @Override
    public Locatii findEntityById(Integer id) throws DaoExeption {
        return null;
    }

    @Override
    public boolean delete(Locatii locatii) throws DaoExeption {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws DaoExeption {
        return false;
    }

    @Override
    public boolean create(Locatii locatii) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, locatii.getNumeLocatie());
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
    public Locatii update(Locatii locatii) throws DaoExeption {
        return null;
    }
}
