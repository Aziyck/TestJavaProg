import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Depozit {
    private static ArrayList<Produs> listProduse = new ArrayList<>();
    private static ArrayList<Furnizor> listFurnizori = new ArrayList<>();
    private static ArrayList<Cumparator> listCumparatori = new ArrayList<>();

    public static ArrayList<Produs> getListProduse() {
        return listProduse;
    }

    public static void setListProduse(ArrayList<Produs> listProduse) {
        Depozit.listProduse = listProduse;
    }

    public static ArrayList<Furnizor> getListFurnizori() {
        return listFurnizori;
    }

    public static void setListFurnizori(ArrayList<Furnizor> listFurnizori) {
        Depozit.listFurnizori = listFurnizori;
    }

    public static ArrayList<Cumparator> getListCumparatori() {
        return listCumparatori;
    }

    public static void setListCumparatori(ArrayList<Cumparator> listCumparatori) {
        Depozit.listCumparatori = listCumparatori;
    }

    public static void addListProduse(ArrayList<Produs> pr){
        listProduse.addAll(pr);
    }
    public static void addListProduse(Produs pr){
        listProduse.add(pr);
    }
    public static void deleteListProduse(Produs pr){
        listProduse.remove(pr);
    }

    public static void addListFurnizori(ArrayList<Furnizor> pr){
        listFurnizori.addAll(pr);
    }
    public static void addListFurnizori(Furnizor pr){
        listFurnizori.add(pr);
    }
    public static void deleteListFurnizori(Furnizor pr){
        listFurnizori.remove(pr);
    }

    public static void addListCumparatori(ArrayList<Cumparator> pr){
        listCumparatori.addAll(pr);
    }
    public static void addListCumparatori(Cumparator pr){
        listCumparatori.add(pr);
    }
    public static void deleteListCumparatori(Cumparator pr){
        listCumparatori.remove(pr);
    }

    public static void serealiseToFiles(File fileDepozit, File fileFrunizori, File fileCumparatori){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileDepozit));
            oos.writeObject(Depozit.getListProduse());
            oos.close();

            oos = new ObjectOutputStream(new FileOutputStream(fileFrunizori));
            oos.writeObject(Depozit.getListFurnizori());
            oos.close();

            oos = new ObjectOutputStream(new FileOutputStream(fileCumparatori));
            oos.writeObject(Depozit.getListCumparatori());
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void clear(){
        listCumparatori.clear();
        listFurnizori.clear();
        listProduse.clear();
    }

    public static void buyFromFurnizor(Furnizor furnizor, int nrProd){
        Produs produs = furnizor.getListProd().get(nrProd);
        listProduse.add(produs);
        furnizor.deleteProd(produs);
    }

    public static void sellToCumparator(Cumparator cumparator, int nrProd){
        Produs produs = listProduse.get(nrProd);
        cumparator.getListProd().add(produs);
        listProduse.remove(produs);
    }

    public static void serialiseProduse(File fileProduse){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileProduse));
            oos.writeObject(Depozit.getListProduse());
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void serialiseFurnizori(File fileFrunizori){
        try{
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(fileFrunizori));
            oos.writeObject(Depozit.getListFurnizori());
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void serialiseCumparatori(File fileCumparatori){
        try{
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(fileCumparatori));
            oos.writeObject(Depozit.getListCumparatori());
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getFromSerialisedFiles(File fileDepozit, File fileFrunizori, File fileCumparatori){
        try {
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(fileDepozit));
            ArrayList<Produs> p = (ArrayList<Produs>) ois.readObject();
            Depozit.setListProduse(p);

            ois = new ObjectInputStream(new FileInputStream(fileFrunizori));
            ArrayList<Furnizor> f = (ArrayList<Furnizor>) ois.readObject();
            Depozit.setListFurnizori(f);


            ois = new ObjectInputStream(new FileInputStream(fileCumparatori));
            ArrayList<Cumparator> c = (ArrayList<Cumparator>) ois.readObject();
            Depozit.setListCumparatori(c);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deserialiseProduse(File fileProduse){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileProduse));
            ArrayList<Produs> p = (ArrayList<Produs>) ois.readObject();
            Depozit.setListProduse(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deserialiseFurnizori(File fileFrunizori){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileFrunizori));
            ArrayList<Furnizor> f = (ArrayList<Furnizor>) ois.readObject();
            Depozit.setListFurnizori(f);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deserialiseCumparatori(File fileCumparatori){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileCumparatori));
            ArrayList<Cumparator> c = (ArrayList<Cumparator>) ois.readObject();
            Depozit.setListCumparatori(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String toStaticString() {
        return "Produse:\n" +  listProduse.toString() + "\n\n\n" +
                "Furnizori:\n" + listFurnizori.toString() + "\n\n" +
                "Cumparatori:\n" + listCumparatori.toString();

    }
}
