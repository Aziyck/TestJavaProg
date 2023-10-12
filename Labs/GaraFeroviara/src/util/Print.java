package util;

import dao.DaoExeption;
import dao.Implements.LocatiiDAOimpl;
import dao.Implements.RuteDAOimpl;
import dao.Implements.ZileDAOimpl;
import dao.LocatiiDAO;
import dao.RuteDAO;
import dao.ZileDAO;
import entity.Locatii;
import entity.Rute;
import entity.Zile;
import tbl.Table;
import tbl.TableHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Print {
    public static void printLocatii(List<Locatii> listOfLocatii) throws DaoExeption{
        ArrayList<String> header = new ArrayList<>(List.of("Cod Loc", "Nume Loc"));
        ArrayList<ArrayList<String>> tableBody = TableHelper.ConvertObjListToStringList(listOfLocatii);
        Table table = new Table(header, tableBody);
        try{
            table.addCountToTableAndDinamicCellLLength(1);
//            table.addCountToTable();
        } catch (Exception e){}

        System.out.println(table);
    }
    public static void printLocatii(Locatii locatii) throws DaoExeption{
        ArrayList<Locatii> listOfLocatii = new ArrayList<>(List.of(locatii));
        printLocatii(listOfLocatii);
    }

    public static void printZile(List<Zile> listOfZile) throws DaoExeption{
        ArrayList<String> header = new ArrayList<>(List.of("Cod Zi", "Nume Zi"));
        ArrayList<ArrayList<String>> tableBody = TableHelper.ConvertObjListToStringList(listOfZile);
        Table table = new Table(header, tableBody);
        try{
            table.addCountToTableAndDinamicCellLLength(1);
//            table.addCountToTable();
        } catch (Exception e){}

        System.out.println(table);
    }
    public static void printZile(Zile zile) throws DaoExeption {
        ArrayList<Zile> listOfZile = new ArrayList<>(List.of(zile));
        printZile(listOfZile);
    }

    public static void printRute(List<Rute> listOfRute) throws DaoExeption {

        ZileDAO zileDAO = new ZileDAOimpl();
        ArrayList<Zile> zile = new ArrayList<>(zileDAO.findAll());
            Map<Integer, String> zileMap = new HashMap<>();
            for(Zile z : zile){
                zileMap.put(z.getIdZiua(), z.getNumeZi());
            }

        LocatiiDAO locatiiDAO = new LocatiiDAOimpl();
        ArrayList<Locatii> locatii = new ArrayList<>(locatiiDAO.findAll());
            Map<Integer, String> locatiiMap = new HashMap<>();
            for(Locatii l : locatii){
                locatiiMap.put(l.getIdLocatie(), l.getNumeLocatie());
            }

        ArrayList<String> header = new ArrayList<>(List.of("Cod cursa", "Data Plecarii", "Ora Plecarii", "Loc Initiala", "Data Sosorii", "Ora Sosirii", "Destinatie", "Durata", "Nr Sapt", "Loc. Disponibile Conf", "Loc. Totale Confort", "Pret Confort", "Loc. Discponibile Eco", "Loc. Totale Eco", "Pret Econom", "ID Ziua"));
        ArrayList<ArrayList<String>> tableBody = TableHelper.ConvertObjListToStringList(listOfRute);
        for(ArrayList<String> colms : tableBody){
            colms.set(3 , locatiiMap.get( Integer.parseInt(colms.get(3)) ));
            colms.set(6 , locatiiMap.get( Integer.parseInt(colms.get(6)) ));
            colms.set(15 , zileMap.get( Integer.parseInt(colms.get(15)) ));
        }


        Table table = new Table(header, tableBody);
        try {
            table.addCountToTableAndDinamicCellLLength(1);
//            table.addCountToTable();
        }catch (Exception e){}

        System.out.println(table);
    }
    public static void printRute(Rute rute) throws DaoExeption {
        ArrayList<Rute> listOfRute = new ArrayList<>(List.of(rute));
        printRute(listOfRute);
    }

    public static void printLocLibereInFiecareTren() throws DaoExeption {
        ArrayList<String> header = new ArrayList<>(List.of("Cod Cursa", "Loc Disp Confort", "Loc Disp Eco", "Loc Disp Total"));

        Table table = new Table(header, Util.locLibereInFiecareTren());

        try {
            table.addCountToTableAndDinamicCellLLength(1);
//            table.addCountToTable();
        }catch (Exception e){}

        System.out.println(table);
    }

    public static void printLocLibereInTren(int codCursa) throws DaoExeption {
        ArrayList<String> header = new ArrayList<>(List.of("Cod Cursa", "Loc Disp Confort", "Loc Disp Eco", "Loc Disp Total"));

        Table table = new Table(header, Util.locLibereLaCursa(codCursa));

        try {
            table.addCountToTableAndDinamicCellLLength(1);
//            table.addCountToTable();
        }catch (Exception e){}

        System.out.println(table);
    }
}
