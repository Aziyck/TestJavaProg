package dao.Implements;

import dao.DaoExeption;
import dao.RuteDAO;
import entity.Rute;
import util.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuteDAOimpl implements RuteDAO {
    private static final String SQL_SELECT_BY_LOC_INITI_AND_DEST = "SELECT * FROM public.\"Rute\" WHERE \"Destinatie\" = ? and \"LocatieInitiala\" = ? ORDER BY \"Durata\" ASC;";
    private static final String SQL_SELECT_BY_NR_SAPTAM = "SELECT * FROM public.\"Rute\" WHERE \"NrSaptamanii\" = ? ";
    private static final String SQL_SELECT_BY_DEST ="SELECT * FROM public.\"Rute\" WHERE \"Destinatie\" = ? ORDER BY \"IDZiua\" ASC;";
    private static final String SQL_INSERT = "INSERT INTO public.\"Rute\"(\"DataPlecarii\", \"OraPlecarii\", \"LocatieInitiala\", \"DataSosirii\", \"OraSosirii\", \"Destinatie\", \"Durata\", \"NrSaptamanii\", \"LocuriDisponibileConfort\", \"LocuriConfort\", \"PretConfort\", \"LocuriDisponibileEco\", \"LocuriEco\", \"PretEco\", \"IDZiua\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_ALL = "SELECT \"CodCursa\", \"DataPlecarii\", \"OraPlecarii\", \"LocatieInitiala\", \"DataSosirii\", \"OraSosirii\", \"Destinatie\", \"Durata\", \"NrSaptamanii\", \"LocuriDisponibileConfort\", \"LocuriConfort\", \"PretConfort\", \"LocuriDisponibileEco\", \"LocuriEco\", \"PretEco\", \"IDZiua\" FROM public.\"Rute\";";
    private static final String SQL_SELECT_BY_ID = "SELECT \"CodCursa\", \"DataPlecarii\", \"OraPlecarii\", \"LocatieInitiala\", \"DataSosirii\", \"OraSosirii\", \"Destinatie\", \"Durata\", \"NrSaptamanii\", \"LocuriDisponibileConfort\", \"LocuriConfort\", \"PretConfort\", \"LocuriDisponibileEco\", \"LocuriEco\", \"PretEco\", \"IDZiua\" FROM public.\"Rute\" WHERE \"CodCursa\" = ?;";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"Rute\" WHERE \"CodCursa\"=?;";
    private static final String SQL_DELETE_BY_OBJECT = "DELETE FROM public.\"Rute\" WHERE \"DataPlecarii\" = ? and \"OraPlecarii\" = ? and \"LocatieInitiala\" = ? and \"DataSosirii\" = ? and \"OraSosirii\" = ? and \"Destinatie\" = ? and \"Durata\" = ? and \"NrSaptamanii\" = ? and \"LocuriDisponibileConfort\" = ? and \"LocuriConfort\" = ? and \"PretConfort\" = ? and \"LocuriDisponibileEco\" = ? and \"LocuriEco\" = ? and \"PretEco\" = ? and \"IDZiua\" = ? ;";
    private static final String SQL_UPDATE = "UPDATE public.\"Rute\" SET \"DataPlecarii\"=?, \"OraPlecarii\"=?, \"LocatieInitiala\"=?, \"DataSosirii\"=?, \"OraSosirii\"=?, \"Destinatie\"=?, \"Durata\"=?, \"NrSaptamanii\"=?, \"LocuriDisponibileConfort\"=?, \"LocuriConfort\"=?, \"PretConfort\"=?, \"LocuriDisponibileEco\"=?, \"LocuriEco\"=?, \"PretEco\"=?, \"IDZiua\"=? WHERE \"CodCursa = ?\";";

    @Override
    public List<Rute> findAll() throws DaoExeption {
        List<Rute> rutes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Rute ruta = new Rute();

                ruta.setCodCursa(resultSet.getInt("CodCursa"));
                ruta.setDataPlecarii(resultSet.getString("DataPlecarii"));
                ruta.setOraPlecarii(resultSet.getString("OraPlecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("LocatieInitiala"));
                ruta.setDataSosirii(resultSet.getString("DataSosirii"));
                ruta.setOraSosirii(resultSet.getString("OraSosirii"));
                ruta.setDestinatie(resultSet.getInt("Destinatie"));
                ruta.setDurata(resultSet.getLong("Durata"));
                ruta.setNrSaptamanii(resultSet.getInt("NrSaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("LocuriDisponibileConfort"));
                ruta.setLocConfort(resultSet.getInt("LocuriConfort"));
                ruta.setPretConfort(resultSet.getFloat("PretConfort"));
                ruta.setLocDisponEco(resultSet.getInt("LocuriDisponibileEco"));
                ruta.setLocEco(resultSet.getInt("LocuriEco"));
                ruta.setPretEco(resultSet.getFloat("PretEco"));
                ruta.setIdZiua(resultSet.getInt("IDZiua"));

                rutes.add(ruta);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rutes;
    }

    @Override
    public Rute findEntityById(Integer id) throws DaoExeption {
        Rute ruta = new Rute();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                ruta.setCodCursa(resultSet.getInt("CodCursa"));
                ruta.setDataPlecarii(resultSet.getString("DataPlecarii"));
                ruta.setOraPlecarii(resultSet.getString("OraPlecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("LocatieInitiala"));
                ruta.setDataSosirii(resultSet.getString("DataSosirii"));
                ruta.setOraSosirii(resultSet.getString("OraSosirii"));
                ruta.setDestinatie(resultSet.getInt("Destinatie"));
                ruta.setDurata(resultSet.getLong("Durata"));
                ruta.setNrSaptamanii(resultSet.getInt("NrSaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("LocuriDisponibileConfort"));
                ruta.setLocConfort(resultSet.getInt("LocuriConfort"));
                ruta.setPretConfort(resultSet.getFloat("PretConfort"));
                ruta.setLocDisponEco(resultSet.getInt("LocuriDisponibileEco"));
                ruta.setLocEco(resultSet.getInt("LocuriEco"));
                ruta.setPretEco(resultSet.getFloat("PretEco"));
                ruta.setIdZiua(resultSet.getInt("IDZiua"));

            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return ruta;
    }

    public List<Rute> findEntityByDest(int destinatie) throws DaoExeption {
        List<Rute> rutes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_DEST);
            statement.setInt(1, destinatie);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Rute ruta = new Rute();

                ruta.setCodCursa(resultSet.getInt("CodCursa"));
                ruta.setDataPlecarii(resultSet.getString("DataPlecarii"));
                ruta.setOraPlecarii(resultSet.getString("OraPlecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("LocatieInitiala"));
                ruta.setDataSosirii(resultSet.getString("DataSosirii"));
                ruta.setOraSosirii(resultSet.getString("OraSosirii"));
                ruta.setDestinatie(resultSet.getInt("Destinatie"));
                ruta.setDurata(resultSet.getLong("Durata"));
                ruta.setNrSaptamanii(resultSet.getInt("NrSaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("LocuriDisponibileConfort"));
                ruta.setLocConfort(resultSet.getInt("LocuriConfort"));
                ruta.setPretConfort(resultSet.getFloat("PretConfort"));
                ruta.setLocDisponEco(resultSet.getInt("LocuriDisponibileEco"));
                ruta.setLocEco(resultSet.getInt("LocuriEco"));
                ruta.setPretEco(resultSet.getFloat("PretEco"));
                ruta.setIdZiua(resultSet.getInt("IDZiua"));

                rutes.add(ruta);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rutes;
    }

    public List<Rute> findEntityByNrSapt(int nrSapt) throws DaoExeption {
        List<Rute> rutes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_NR_SAPTAM);
            statement.setInt(1, nrSapt);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Rute ruta = new Rute();

                ruta.setCodCursa(resultSet.getInt("CodCursa"));
                ruta.setDataPlecarii(resultSet.getString("DataPlecarii"));
                ruta.setOraPlecarii(resultSet.getString("OraPlecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("LocatieInitiala"));
                ruta.setDataSosirii(resultSet.getString("DataSosirii"));
                ruta.setOraSosirii(resultSet.getString("OraSosirii"));
                ruta.setDestinatie(resultSet.getInt("Destinatie"));
                ruta.setDurata(resultSet.getLong("Durata"));
                ruta.setNrSaptamanii(resultSet.getInt("NrSaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("LocuriDisponibileConfort"));
                ruta.setLocConfort(resultSet.getInt("LocuriConfort"));
                ruta.setPretConfort(resultSet.getFloat("PretConfort"));
                ruta.setLocDisponEco(resultSet.getInt("LocuriDisponibileEco"));
                ruta.setLocEco(resultSet.getInt("LocuriEco"));
                ruta.setPretEco(resultSet.getFloat("PretEco"));
                ruta.setIdZiua(resultSet.getInt("IDZiua"));

                rutes.add(ruta);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rutes;
    }

    public List<Rute> findEntityByLocInitAndDest(int locInitiala, int destinatie) throws DaoExeption {
        List<Rute> rutes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_LOC_INITI_AND_DEST);
            statement.setInt(1, destinatie);
            statement.setInt(2, locInitiala);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Rute ruta = new Rute();

                ruta.setCodCursa(resultSet.getInt("CodCursa"));
                ruta.setDataPlecarii(resultSet.getString("DataPlecarii"));
                ruta.setOraPlecarii(resultSet.getString("OraPlecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("LocatieInitiala"));
                ruta.setDataSosirii(resultSet.getString("DataSosirii"));
                ruta.setOraSosirii(resultSet.getString("OraSosirii"));
                ruta.setDestinatie(resultSet.getInt("Destinatie"));
                ruta.setDurata(resultSet.getLong("Durata"));
                ruta.setNrSaptamanii(resultSet.getInt("NrSaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("LocuriDisponibileConfort"));
                ruta.setLocConfort(resultSet.getInt("LocuriConfort"));
                ruta.setPretConfort(resultSet.getFloat("PretConfort"));
                ruta.setLocDisponEco(resultSet.getInt("LocuriDisponibileEco"));
                ruta.setLocEco(resultSet.getInt("LocuriEco"));
                ruta.setPretEco(resultSet.getFloat("PretEco"));
                ruta.setIdZiua(resultSet.getInt("IDZiua"));

                rutes.add(ruta);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rutes;
    }

    @Override
    public boolean delete(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
            statement.setString(1, rute.getDataPlecarii());
            statement.setString(2, rute.getOraPlecarii());
            statement.setInt(3, rute.getLocatieInitiala());
            statement.setString(4, rute.getDataSosirii());
            statement.setString(5, rute.getOraSosirii());
            statement.setInt(6, rute.getDestinatie());
            statement.setLong(7, rute.getDurata());
            statement.setInt(8, rute.getNrSaptamanii());
            statement.setInt(9, rute.getLocDisponConfort());
            statement.setInt(10, rute.getLocConfort());
            statement.setFloat(11, rute.getPretConfort());
            statement.setInt(12, rute.getLocDisponEco());
            statement.setInt(13, rute.getLocEco());
            statement.setFloat(14, rute.getPretEco());
            statement.setInt(15, rute.getIdZiua());
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
    public boolean delete(Integer id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_ID);
            statement.setInt(1, id);
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
    public boolean create(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, rute.getDataPlecarii());
            statement.setString(2, rute.getOraPlecarii());
            statement.setInt(3, rute.getLocatieInitiala());
            statement.setString(4, rute.getDataSosirii());
            statement.setString(5, rute.getOraSosirii());
            statement.setInt(6, rute.getDestinatie());
            statement.setLong(7, rute.getDurata());
            statement.setInt(8, rute.getNrSaptamanii());
            statement.setInt(9, rute.getLocDisponConfort());
            statement.setInt(10, rute.getLocConfort());
            statement.setFloat(11, rute.getPretConfort());
            statement.setInt(12, rute.getLocDisponEco());
            statement.setInt(13, rute.getLocEco());
            statement.setFloat(14, rute.getPretEco());
            statement.setInt(15, rute.getIdZiua());
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
    public Rute update(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, rute.getDataPlecarii());
            statement.setString(2, rute.getOraPlecarii());
            statement.setInt(3, rute.getLocatieInitiala());
            statement.setString(4, rute.getDataSosirii());
            statement.setString(5, rute.getOraSosirii());
            statement.setInt(6, rute.getDestinatie());
            statement.setLong(7, rute.getDurata());
            statement.setInt(8, rute.getNrSaptamanii());
            statement.setInt(9, rute.getLocDisponConfort());
            statement.setInt(10, rute.getLocConfort());
            statement.setFloat(11, rute.getPretConfort());
            statement.setInt(12, rute.getLocDisponEco());
            statement.setInt(13, rute.getLocEco());
            statement.setFloat(14, rute.getPretEco());
            statement.setInt(15, rute.getIdZiua());
            statement.setInt(16, rute.getCodCursa());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rute;
    }

    @Override
    public List<Rute> findRutaByID(Integer id) throws DaoExeption {
        return new ArrayList<>(List.of(findEntityById(id)));
    }
}
