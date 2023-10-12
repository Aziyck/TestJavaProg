package entity;

import java.util.ArrayList;
import java.util.List;

public class Locatii extends Entity{
    int idLocatie;
    String numeLocatie;

    public Locatii() {
    }

    public Locatii(int idLocatie, String numeLocatie) {
        this.idLocatie = idLocatie;
        this.numeLocatie = numeLocatie;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public String getNumeLocatie() {
        return numeLocatie;
    }

    public void setNumeLocatie(String numeLocatie) {
        this.numeLocatie = numeLocatie;
    }

    @Override
    public String toString() {
        return "Locatii{" +
                "idLocatie=" + idLocatie +
                ", numeLocatie='" + numeLocatie + '\'' +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<>(List.of(
                Integer.toString(idLocatie),
                numeLocatie
        ));
    }
}
