import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String FILE_DEPOZIT = "E:\\JavaPrograms\\Labs\\Week3\\Lab2Ev\\LabTwo\\src\\depozitData.txt";
        String FILE_FURNOZORI = "E:\\JavaPrograms\\Labs\\Week3\\Lab2Ev\\LabTwo\\src\\furnizoriData.txt";
        String FILE_CUMPARATORI ="E:\\JavaPrograms\\Labs\\Week3\\Lab2Ev\\LabTwo\\src\\cumparatoriData.txt";


        Produs p1, p2, p3;
        ArrayList<Produs> listProd = new ArrayList<>();
        Furnizor furnizor;
        Cumparator cumparator;

        p1 = new Produs("Lapte", 10, 100);
        p2 = new Produs("Smantana", 25, 60);
        p3 = new Produs("Chifir", 12, 70);
        Collections.addAll(listProd, p1,p2,p3);
        furnizor = new Furnizor("JLC", listProd);
        listProd = new ArrayList<>();

        p1 = new Produs("Rosii", 30, 55);
        listProd.add(p1);
        cumparator = new Cumparator("Linela", listProd);
        listProd = new ArrayList<>();

        p1 = new Produs("Paine", 5, 200);

        Depozit.addListProduse(p1);
        Depozit.addListFurnizori(furnizor);
        Depozit.addListCumparatori(cumparator);

        File depozitData = new File(FILE_DEPOZIT);
        File furnizorData = new File(FILE_FURNOZORI);
        File cumparatoriData = new File(FILE_CUMPARATORI);

        Depozit.serealiseToFiles(depozitData, furnizorData, cumparatoriData);
        Depozit.clear();
        Depozit.getFromSerialisedFiles(depozitData, furnizorData, cumparatoriData);

        System.out.println(Depozit.toStaticString());

        Depozit.buyFromFurnizor(Depozit.getListFurnizori().get(0), 2);
        Depozit.sellToCumparator(Depozit.getListCumparatori().get(0),0);

        System.out.println(Depozit.toStaticString());

    }
}
