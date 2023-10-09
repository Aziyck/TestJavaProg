package dao.Implements;

import dao.DaoExeption;
import dao.DatabaseManager;
import dao.StudentDAO;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudetDAOimpl implements StudentDAO {
    private static final String SQL_SELECT_ALL = "SELECT stud_name, card_id, \"year\", \"group\", note1, note2, note3, average FROM public.\"Students\" ORDER BY card_id ASC;";
    private static final String SQL_SELECT_BY_ID = "SELECT stud_name, card_id, \"year\", \"group\", note1, note2, note3, average FROM public.\"Students\" WHERE card_id = ?;";
    private static final String SQL_SELECT_ALL_BY_NAME = "SELECT stud_name, card_id, \"year\", \"group\", note1, note2, note3, average FROM public.\"Students\" WHERE stud_name = ?;";
    private static final String SQL_SELECT_ALL_BY_AN = "SELECT stud_name, card_id, \"year\", \"group\", note1, note2, note3, average FROM public.\"Students\" WHERE \"year\" = ?;";
    private static final String SQL_SELECT_ALL_BY_GROUP = "SELECT stud_name, card_id, \"year\", \"group\", note1, note2, note3, average FROM public.\"Students\" WHERE \"group\" = ?;";
    private static final String SQL_INSERT = "INSERT INTO public.\"Students\"(stud_name, \"year\", \"group\", note1, note2, note3, average) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"Students\" WHERE card_id = ?;";
    private static final String SQL_DELETE_BY_OBJECT = "DELETE FROM public.\"Students\" WHERE stud_name = ? and \"year\" = ? and \"group\" = ? and note1 = ? and note2 = ? and note3 = ? and average = ?;";
    private static final String SQL_UPDATE = "UPDATE public.\"Students\" SET stud_name=?, \"year\"=?, \"group\"=?, note1=?, note2=?, note3=?, average=? WHERE card_id = ?;";
    @Override
    public List<Student> findAll() throws DaoExeption {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();

                student.setStud_name(resultSet.getString("stud_name"));
                student.setCard_id(resultSet.getInt("card_id"));
                student.setYear(resultSet.getInt("year"));
                student.setGroup(resultSet.getString("group"));
                student.setNote1(resultSet.getInt("note1"));
                student.setNote2(resultSet.getInt("note2"));
                student.setNote3(resultSet.getInt("note3"));
                student.setAverage((resultSet.getDouble("average")));

                students.add(student);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    @Override
    public Student findEntityById(Integer id) throws DaoExeption {

        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                student = new Student();

                student.setStud_name(resultSet.getString("stud_name"));
                student.setCard_id(resultSet.getInt("card_id"));
                student.setYear(resultSet.getInt("year"));
                student.setGroup(resultSet.getString("group"));
                student.setNote1(resultSet.getInt("note1"));
                student.setNote2(resultSet.getInt("note2"));
                student.setNote3(resultSet.getInt("note3"));
                student.setAverage((resultSet.getDouble("average")));

            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return student;
    }

    public List<Student> findEntityByName(String Name) throws DaoExeption {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_BY_NAME);
            statement.setString(1, Name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();

                student.setStud_name(resultSet.getString("stud_name"));
                student.setCard_id(resultSet.getInt("card_id"));
                student.setYear(resultSet.getInt("year"));
                student.setGroup(resultSet.getString("group"));
                student.setNote1(resultSet.getInt("note1"));
                student.setNote2(resultSet.getInt("note2"));
                student.setNote3(resultSet.getInt("note3"));
                student.setAverage((resultSet.getDouble("average")));

                students.add(student);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    public List<Student> findEntityByAn(Integer An) throws DaoExeption {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_BY_AN);
            statement.setInt(1, An);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();

                student.setStud_name(resultSet.getString("stud_name"));
                student.setCard_id(resultSet.getInt("card_id"));
                student.setYear(resultSet.getInt("year"));
                student.setGroup(resultSet.getString("group"));
                student.setNote1(resultSet.getInt("note1"));
                student.setNote2(resultSet.getInt("note2"));
                student.setNote3(resultSet.getInt("note3"));
                student.setAverage((resultSet.getDouble("average")));

                students.add(student);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    public List<Student> findEntityByGroup(String Group) throws DaoExeption {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL_BY_GROUP);
            statement.setString(1, Group);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();

                student.setStud_name(resultSet.getString("stud_name"));
                student.setCard_id(resultSet.getInt("card_id"));
                student.setYear(resultSet.getInt("year"));
                student.setGroup(resultSet.getString("group"));
                student.setNote1(resultSet.getInt("note1"));
                student.setNote2(resultSet.getInt("note2"));
                student.setNote3(resultSet.getInt("note3"));
                student.setAverage((resultSet.getDouble("average")));

                students.add(student);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return students;
    }

    private static boolean studentEquals(Student student1, Student student2){

        if(!student1.getStud_name().equals(student2.getStud_name())) return false;
        if(student1.getYear() != student2.getYear()) return false;
        if(!student1.getGroup().equals(student2.getGroup())) return false;
        if(student1.getNote1() != student2.getNote1()) return false;
        if(student1.getNote2() != student2.getNote2()) return false;
        if(student1.getNote3() != student2.getNote3()) return false;
        if(student1.getAverage() != student2.getAverage()) return false;

        return true;
    }

    @Override
    public boolean delete(Student student) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
            statement.setString(1, student.getStud_name());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getGroup());
            statement.setInt(4, student.getNote1());
            statement.setInt(5, student.getNote2());
            statement.setInt(6, student.getNote3());
            statement.setFloat(7,(float) student.getAverage());
            System.out.println(statement);
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

    public boolean delete(List<Student> students) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();

            for(Student student : students){
                statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
                statement.setString(1, student.getStud_name());
                statement.setInt(2, student.getYear());
                statement.setString(3, student.getGroup());
                statement.setInt(4, student.getNote1());
                statement.setInt(5, student.getNote2());
                statement.setInt(6, student.getNote3());
                statement.setFloat(7,(float) student.getAverage());
                statement.executeUpdate();
                if (statement.getUpdateCount() != 0) bool = true;
            }

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
    public boolean create(Student student) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, student.getStud_name());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getGroup());
            statement.setInt(4, student.getNote1());
            statement.setInt(5, student.getNote2());
            statement.setInt(6, student.getNote3());
            statement.setDouble(7, student.getAverage());
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
    public Student update(Student student) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, student.getStud_name());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getGroup());
            statement.setInt(4, student.getNote1());
            statement.setInt(5, student.getNote2());
            statement.setInt(6, student.getNote3());
            statement.setDouble(7, student.getAverage());
            statement.setInt(8, student.getCard_id());
            statement.executeUpdate();

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return student;
    }

    @Override
    public List<Student> findStudentByName(String patternName) throws DaoExeption {
        return findEntityByName(patternName);
    }
}
