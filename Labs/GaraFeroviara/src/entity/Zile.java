package entity;

import java.util.ArrayList;
import java.util.List;

public class Zile extends Entity{
    int idZiua;
    String numeZi;

    public Zile() {
    }

    public Zile(int idZiua, String numeZi) {
        this.idZiua = idZiua;
        this.numeZi = numeZi;
    }

    public int getIdZiua() {
        return idZiua;
    }

    public void setIdZiua(int idZiua) {
        this.idZiua = idZiua;
    }

    public String getNumeZi() {
        return numeZi;
    }

    public void setNumeZi(String numeZi) {
        this.numeZi = numeZi;
    }

    @Override
    public String toString() {
        return "Zile{" +
                "idZiua=" + idZiua +
                ", numeZi='" + numeZi + '\'' +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<>(List.of(
                Integer.toString(idZiua),
                numeZi
        ));
    }
}
