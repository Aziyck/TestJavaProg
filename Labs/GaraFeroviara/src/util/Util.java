package util;

import dao.DaoExeption;
import dao.Implements.RuteAnulateDAOimpl;
import dao.Implements.RuteDAOimpl;
import dao.Implements.RuteTempDAOimpl;
import dao.RuteDAO;
import entity.Rute;
import tbl.Table;
import tbl.TableHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Util {

    public static long makeDurata(Rute rute){
        String plecare = rute.getDataPlecarii() + "." + rute.getOraPlecarii().replace(":", ".");
        StringTokenizer st = new StringTokenizer(plecare, ".");

        int data = Integer.parseInt(st.nextToken());
        int luna = Integer.parseInt(st.nextToken())-1;
        int anul = Integer.parseInt(st.nextToken());
        int ora = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        Date datePornire = new Date(anul, luna, data, ora, min);

        String sosire = rute.getDataSosirii() + "." + rute.getOraSosirii().replace(":", ".");
        st = new StringTokenizer(sosire, ".");

        data = Integer.parseInt(st.nextToken());
        luna = Integer.parseInt(st.nextToken())-1;
        anul = Integer.parseInt(st.nextToken());
        ora = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());

        Date dateSosite = new Date(anul, luna, data, ora, min);

        return (long) dateSosite.getTime() - datePornire.getTime();
    }
    public static void printRute(List<Rute> ListOfRute){
        ArrayList<String> header = new ArrayList<>(List.of("Cod cursa", "Data Plecarii", "Ora Plecarii", "Loc Initiala", "Data Sosorii", "Ora Sosirii", "Destinatie", "Durata", "Nr Sapt", "Loc. Disponibile Conf", "Loc. Totale Confort", "Pret Confort", "Loc. Discponibile Eco", "Loc. Totale Eco", "Pret Econom", "ID Ziua"));
        ArrayList<ArrayList<String>> tableBody = TableHelper.ConvertObjListToStringList(ListOfRute);

        Table table = new Table(header, tableBody);
        try {
//            table.addCountToTableAndDinamicCellLLength(1);
            table.addCountToTable();
        }catch (Exception e){}

        System.out.println(table);
    }

    public static void printRute(Rute rute){
        ArrayList<Rute> ListOfRute = new ArrayList<>(List.of(rute));
        printRute(ListOfRute);
    }

    public static void anulateRuta(Rute rute) throws DaoExeption {
        RuteDAO ruteDAOimpl = new RuteDAOimpl();
        RuteDAO ruteAnulateDAOimpl = new RuteAnulateDAOimpl();

        if (ruteDAOimpl.delete(rute)) ruteAnulateDAOimpl.create(rute);
    }

    private static boolean betweenHours(String pornire, String sosire, Rute rute){
        StringTokenizer st = new StringTokenizer(pornire, ":");
        int ora = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        Date oraPornireActual = new Date(0,0,0, ora, min);

        st = new StringTokenizer(rute.getOraPlecarii(), ":");
        ora = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        Date oraPornire = new Date(0,0,0, ora, min);


        if(oraPornire.getTime() < oraPornireActual.getTime()) return false;

        st = new StringTokenizer(sosire, ":");
        ora = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        Date oraSosireActual = new Date(0,0,0, ora, min);

        st = new StringTokenizer(rute.getOraSosirii(), ":");
        ora = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        Date oraSosire = new Date(0,0,0, ora, min);

        if (oraSosire.getTime() > oraSosireActual.getTime()) return false;

        return true;
    }

    public static List<Rute> findByDestAndInterval(int dest, String pornire, String sosire) throws DaoExeption {
        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();

        ArrayList<Rute> selectedDestinatii = new ArrayList<>(ruteDAOimpl.findEntityByDest(dest));
        for (Rute rute : selectedDestinatii){
            if (!betweenHours(pornire,sosire,rute)) selectedDestinatii.remove(rute);
        }

        return selectedDestinatii;
    }

    public static double pretMediuABiletSperDest(int dest) throws DaoExeption {
        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();

        ArrayList<Rute> selectedLocatii = new ArrayList<>(ruteDAOimpl.findEntityByDest(dest));
        int nr = 0;
        float pretTotal = 0;
        for(Rute rute : selectedLocatii){
            pretTotal += rute.getPretConfort();
            pretTotal += rute.getPretEco();
            nr+=2;
        }
        return (double) pretTotal/nr;
    }

    public static void insertIntoNrRuteTempDupaNrSapt(int nrSapt) throws DaoExeption {
        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();
        RuteTempDAOimpl ruteTempDAOimpl  = new RuteTempDAOimpl();

        ArrayList<Rute> selectedDupaNrSapt = new ArrayList<>(ruteDAOimpl.findEntityByNrSapt(nrSapt));
        for(Rute rute : selectedDupaNrSapt){
            ruteTempDAOimpl.create(rute);
        }
    }

    public static ArrayList<ArrayList<String>> locLibereInFiecareTren() throws DaoExeption {
        RuteDAOimpl ruteDAOimpl = new RuteDAOimpl();

        ArrayList<ArrayList<String>> rez = new ArrayList<>();

        ArrayList<Rute> allRute = new ArrayList<>(ruteDAOimpl.findAll());
        for(Rute rute : allRute){
            ArrayList<String> col = new ArrayList<>(List.of(
                    Integer.toString(rute.getCodCursa()),
                    Integer.toString(rute.getLocDisponConfort()),
                    Integer.toString(rute.getLocDisponEco()),
                    Integer.toString((rute.getLocDisponConfort() + rute.getLocDisponEco()))
                    ));
            rez.add(col);
        }
        return rez;
    }

    public static ArrayList<ArrayList<String>> locLibereLaCursa(int codCursa) throws DaoExeption{
        ArrayList<ArrayList<String>> rez = new ArrayList<>();

        for(ArrayList<String> arr : locLibereInFiecareTren()){
            if(arr.get(0).equals(Integer.toString(codCursa))) rez.add(arr);
        }

        return rez;
    }
}
