import dao.DatabaseManager;
import tbl.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {

    static Connection connection;

    static {
        try {
            connection = DatabaseManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        SqlHelper.connection = connection;
    }

    public static double average(int a, int b, int c){
        return (double) (a + b + c) /3;
    }

    static void printObiecte(){
        try{
            ArrayList<ArrayList<String>> outer = new ArrayList<>();

            String sqlQuarry = "Select * from public.obiecte";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuarry);
            while (resultSet.next()){
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultSet.getString("id"));
                inner.add(resultSet.getString("numeObiect"));
                outer.add(inner);
            }

            ArrayList<String> header = new ArrayList<>(List.of("ID", "Nume Obiect"));
            Table table = new Table(header, outer);
            table.calculateDinamicLenghOfCells(5); // <---
            System.out.println(table);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static void executeStatment(String sql){
        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static void updateStudents(String sql){
        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void insertObiecte(){
        try {
            String sql = "INSERT INTO public.obiecte(\"numeObiect\") VALUES('Limba Romana'), ('Matematica')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static void createObiecte(){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS public.obiecte\n" +
                    "(\n" +
                    "    \"Id\" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),\n" +
                    "    \"numeObiect\" character varying(32) COLLATE pg_catalog.\"default\",\n" +
                    "    CONSTRAINT \"obiecte_pkey\" PRIMARY KEY (\"Id\")\n" +
                    ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void dropObiecte(){
        try {
            String sql = "DROP TABLE IF EXISTS public.obiecte";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static void insertStudents(){
        try {
            int i=0;
            String sql = "INSERT INTO public.\"Students\"(stud_name, \"year\", \"group\", note1, note2, note3, average)" +
                    "VALUES ('Bors Alexandru', 4, 'P-2041', 10, 10, 10, "+ average(10,10,10) +")," +
                    "('Lungu Dumitru', 4, 'P-2041', 9, 7, 6, "+ average(9,7,6) +")," +
                    "('Onica Iulian', 3, 'P-2031', 6, 7, 6, "+ average(6,7,6) +")," +
                    "('Velencic Daria', 4, 'P-2041', 5, 10, 9, "+ average(5,10,9) +")," +
                    "('Carmansci Danila', 2, 'P-2021', 10, 10, 9, "+ average(10,10,9) +")," +
                    "('Guberschi Alexandra', 1, 'P-2011', 5, 9, 9, "+ average(5,9,9) +")," +
                    "('Moroi Cristian', 3, 'P-2031', 5, 5, 9, "+ average(5,5,9) +")," +
                    "('Frimu Cristina', 2, 'P-2021', 8, 10, 9, "+ average(8,10,9) +")," +
                    "('Bica Vlad', 4, 'P-2041', 7, 5, 8, "+ average(7,5,8) +")," +
                    "('Hancu Maria', 4, 'P-2041', 6, 8, 9, "+ average(6,8,9) +");";

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows > 0){
                System.out.println("inserted");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    static void printStudents(){
        try{
            ArrayList<ArrayList<String>> outer = new ArrayList<>();

            String sqlQuarry = "Select * from public.\"Students\"";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuarry);
            while (resultSet.next()){
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultSet.getString("stud_name"));
                inner.add(resultSet.getString("card_id"));
                inner.add(resultSet.getString("year"));
                inner.add(resultSet.getString("group"));
                inner.add(resultSet.getString("note1"));
                inner.add(resultSet.getString("note2"));
                inner.add(resultSet.getString("note3"));
                inner.add(String.format("%.3f", Double.parseDouble(resultSet.getString("average"))));
                outer.add(inner);
            }

            ArrayList<String> header = new ArrayList<>(List.of("Student Name", "ID", "An", "Grupa", "Nota1", "Nota2", "Nota3", "Average"));
            Table table = new Table(header, outer);
            table.calculateDinamicLenghOfCells(2);
            System.out.println(table);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static void printStudents(String whereCondition){
        try{
            ArrayList<ArrayList<String>> outer = new ArrayList<>();

            String sqlQuarry = "Select * from public.Students " + whereCondition ;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuarry);
            while (resultSet.next()){
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultSet.getString("stud_name"));
                inner.add(resultSet.getString("card_id"));
                inner.add(resultSet.getString("year"));
                inner.add(resultSet.getString("group"));
                inner.add(resultSet.getString("note1"));
                inner.add(resultSet.getString("note2"));
                inner.add(resultSet.getString("note3"));
                inner.add(String.format("%.3f", Double.parseDouble(resultSet.getString("average"))));
                outer.add(inner);
            }

            ArrayList<String> header = new ArrayList<>(List.of("Student Name", "ID", "An", "Grupa", "Nota1", "Nota2", "Nota3", "Average"));
            Table table = new Table(header, outer);
            table.calculateDinamicLenghOfCells(2);
            System.out.println(table);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
