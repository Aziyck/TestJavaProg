import java.io.Serializable;
import java.util.ArrayList;

public class Furnizor implements Serializable {
    private String nume;
    private ArrayList<Produs> listProd = new ArrayList<>();

    public Furnizor() {
    }

    public Furnizor(String nume, ArrayList<Produs> listProd) {
        this.nume = nume;
        this.listProd = listProd;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public ArrayList<Produs> getListProd() {
        return listProd;
    }

    public void setListProd(ArrayList<Produs> listProd) {
        this.listProd = listProd;
    }

    public void addProd(Produs produs){
        listProd.add(produs);
    }

    public void deleteProd(Produs produs){
        listProd.remove(produs);
    }

    @Override
    public String toString() {
        return "Furnizor{" +
                "nume='" + nume + '\'' +
                ", listProd=" + listProd +
                '}';
    }
}
