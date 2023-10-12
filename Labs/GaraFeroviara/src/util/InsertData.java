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

import java.util.ArrayList;

public class InsertData {
    public static void InsertZileAndLocatii() throws DaoExeption{
        LocatiiDAO locatiiDAO = new LocatiiDAOimpl();
        ArrayList<Locatii> locatiiArrayList = new ArrayList<>();

        Locatii loc = new Locatii(1, "Chisinau");
        locatiiArrayList.add(loc);
        loc = new Locatii(2, "Balti");
        locatiiArrayList.add(loc);
        loc = new Locatii(3, "Tiraspol");
        locatiiArrayList.add(loc);
        for(Locatii l : locatiiArrayList){
            locatiiDAO.create(l);
        }


        ZileDAO zileDAO = new ZileDAOimpl();
        ArrayList<Zile> zileArrayList = new ArrayList<>();

        Zile ziua = new Zile(1, "Luni");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Marti");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Miercuri");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Joi");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Vineri");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Sambata");
        zileArrayList.add(ziua);
        ziua = new Zile(1, "Duminica");
        zileArrayList.add(ziua);
        for(Zile z : zileArrayList){
            zileDAO.create(z);
        }

    }
    public static void InsertRute() throws DaoExeption {
        RuteDAO ruteDAO = new RuteDAOimpl();
        ArrayList<Rute> rutes = new ArrayList<>();
        Rute rute = new Rute();

        rute.setCodCursa(1);
        rute.setDataPlecarii("09.10.2023");
        rute.setOraPlecarii("10:00");
        rute.setLocatieInitiala(1);
        rute.setDataSosirii("09.10.2023");
        rute.setOraSosirii("11:05");
        rute.setDestinatie(2);
        rute.setDurata(Util.makeDurata(rute));
        rute.setNrSaptamanii(1);
        rute.setLocDisponConfort(5);
        rute.setLocConfort(10);
        rute.setPretConfort(100);
        rute.setLocDisponEco(1);
        rute.setLocEco(20);
        rute.setPretEco(50);
        rute.setIdZiua(1);
        rutes.add(rute);

        rute = new Rute();
        rute.setCodCursa(1);
        rute.setDataPlecarii("10.10.2023");
        rute.setOraPlecarii("12:00");
        rute.setLocatieInitiala(1);
        rute.setDataSosirii("10.10.2023");
        rute.setOraSosirii("13:00");
        rute.setDestinatie(2);
        rute.setDurata(Util.makeDurata(rute));
        rute.setNrSaptamanii(1);
        rute.setLocDisponConfort(10);
        rute.setLocConfort(100);
        rute.setPretConfort(1000);
        rute.setLocDisponEco(10);
        rute.setLocEco(200);
        rute.setPretEco(505);
        rute.setIdZiua(2);
        rutes.add(rute);

        rute = new Rute();
        rute.setCodCursa(1);
        rute.setDataPlecarii("16.10.2023");
        rute.setOraPlecarii("00:00");
        rute.setLocatieInitiala(2);
        rute.setDataSosirii("16.10.2023");
        rute.setOraSosirii("01:00");
        rute.setDestinatie(3);
        rute.setDurata(Util.makeDurata(rute));
        rute.setNrSaptamanii(2);
        rute.setLocDisponConfort(90);
        rute.setLocConfort(10);
        rute.setPretConfort(1000);
        rute.setLocDisponEco(20);
        rute.setLocEco(100);
        rute.setPretEco(500);
        rute.setIdZiua(1);
        rutes.add(rute);

        rute = new Rute();
        rute.setCodCursa(1);
        rute.setDataPlecarii("17.10.2023");
        rute.setOraPlecarii("12:00");
        rute.setLocatieInitiala(3);
        rute.setDataSosirii("17.10.2023");
        rute.setOraSosirii("14:00");
        rute.setDestinatie(2);
        rute.setDurata(Util.makeDurata(rute));
        rute.setNrSaptamanii(2);
        rute.setLocDisponConfort(2);
        rute.setLocConfort(10);
        rute.setPretConfort(2000);
        rute.setLocDisponEco(5);
        rute.setLocEco(30);
        rute.setPretEco(50);
        rute.setIdZiua(2);
        rutes.add(rute);

        rute = new Rute();
        rute.setCodCursa(1);
        rute.setDataPlecarii("25.10.2023");
        rute.setOraPlecarii("12:00");
        rute.setLocatieInitiala(3);
        rute.setDataSosirii("26.10.2023");
        rute.setOraSosirii("14:00");
        rute.setDestinatie(1);
        rute.setDurata(Util.makeDurata(rute));
        rute.setNrSaptamanii(3);
        rute.setLocDisponConfort(5);
        rute.setLocConfort(5);
        rute.setPretConfort(1500);
        rute.setLocDisponEco(1);
        rute.setLocEco(30);
        rute.setPretEco(500);
        rute.setIdZiua(3);
        rutes.add(rute);

        for(Rute r : rutes){
            ruteDAO.create(r);
        }
    }
}
