package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rute extends Entity{
    private Date date = new Date();
    private int codCursa = 1;
    private String dataPlecarii = "";
    private String oraPlecarii = "";
    private int locatieInitiala = 1;
    private String dataSosirii = "";
    private String oraSosirii = "";
    private int destinatie = 1;
    private long durata = 0;
    private int nrSaptamanii = 0;
    private int locDisponConfort = 0;
    private int locConfort = 0;
    private float pretConfort = 0;
    private int locDisponEco = 0;
    private int locEco = 0;
    private float pretEco = 0;
    private int idZiua = 1;

    public Rute() {
    }

    public Rute(int codCursa, String dataPlecarii, String oraPlecarii, int locatieInitiala, String dataSosirii, String oraSosirii, int destinatie, long durata, int nrSaptamanii, int locDisponConfort, int locConfort, float pretConfort, int locDisponEco, int locEco, float pretEco, int idZiua) {
        this.codCursa = codCursa;
        this.dataPlecarii = dataPlecarii;
        this.oraPlecarii = oraPlecarii;
        this.locatieInitiala = locatieInitiala;
        this.dataSosirii = dataSosirii;
        this.oraSosirii = oraSosirii;
        this.destinatie = destinatie;
        this.durata = durata;
        this.nrSaptamanii = nrSaptamanii;
        this.locDisponConfort = locDisponConfort;
        this.locConfort = locConfort;
        this.pretConfort = pretConfort;
        this.locDisponEco = locDisponEco;
        this.locEco = locEco;
        this.pretEco = pretEco;
        this.idZiua = idZiua;
    }

    public int getCodCursa() {
        return codCursa;
    }

    public void setCodCursa(int codCursa) {
        this.codCursa = codCursa;
    }

    public String getDataPlecarii() {
        return dataPlecarii;
    }

    public void setDataPlecarii(String dataPlecarii) {
        this.dataPlecarii = dataPlecarii;
    }

    public String getOraPlecarii() {
        return oraPlecarii;
    }

    public void setOraPlecarii(String oraPlecarii) {
        this.oraPlecarii = oraPlecarii;
    }

    public int getLocatieInitiala() {
        return locatieInitiala;
    }

    public void setLocatieInitiala(int locatieInitiala) {
        this.locatieInitiala = locatieInitiala;
    }

    public String getDataSosirii() {
        return dataSosirii;
    }

    public void setDataSosirii(String dataSosirii) {
        this.dataSosirii = dataSosirii;
    }

    public String getOraSosirii() {
        return oraSosirii;
    }

    public void setOraSosirii(String oraSosirii) {
        this.oraSosirii = oraSosirii;
    }

    public int getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(int destinatie) {
        this.destinatie = destinatie;
    }

    public long getDurata() {
        return durata;
    }

    public void setDurata(long durata) {
        this.durata = durata;
    }

    public int getNrSaptamanii() {
        return nrSaptamanii;
    }

    public void setNrSaptamanii(int nrSaptamanii) {
        this.nrSaptamanii = nrSaptamanii;
    }

    public int getLocDisponConfort() {
        return locDisponConfort;
    }

    public void setLocDisponConfort(int locDisponConfort) {
        this.locDisponConfort = locDisponConfort;
    }

    public int getLocConfort() {
        return locConfort;
    }

    public void setLocConfort(int locConfort) {
        this.locConfort = locConfort;
    }

    public float getPretConfort() {
        return pretConfort;
    }

    public void setPretConfort(float pretConfort) {
        this.pretConfort = pretConfort;
    }

    public int getLocDisponEco() {
        return locDisponEco;
    }

    public void setLocDisponEco(int locDisponEco) {
        this.locDisponEco = locDisponEco;
    }

    public int getLocEco() {
        return locEco;
    }

    public void setLocEco(int locEco) {
        this.locEco = locEco;
    }

    public float getPretEco() {
        return pretEco;
    }

    public void setPretEco(float pretEco) {
        this.pretEco = pretEco;
    }

    public int getIdZiua() {
        return idZiua;
    }

    public void setIdZiua(int idZiua) {
        this.idZiua = idZiua;
    }

    @Override
    public String toString() {
        return "Rute{" +
                "codCursa=" + codCursa +
                ", dataPlecarii=" + dataPlecarii +
                ", oraPlecarii=" + oraPlecarii +
                ", locatieInitiala=" + locatieInitiala +
                ", dataSosirii=" + dataSosirii +
                ", oraSosirii=" + oraSosirii +
                ", destinatie=" + destinatie +
                ", durata=" + durata +
                ", nrSaptamanii=" + nrSaptamanii +
                ", locDisponConfort=" + locDisponConfort +
                ", locConfort=" + locConfort +
                ", pretConfort=" + pretConfort +
                ", locDisponEco=" + locDisponEco +
                ", locEco=" + locEco +
                ", pretEco=" + pretEco +
                ", idZiua=" + idZiua +
                '}';
    }

    private String makeDurata(){
        long diffMin = durata / (60 * 1000);
        long diffHours = (long) diffMin / 60;
        diffMin = diffMin % 60;

        return String.format("%02d:%02d", diffHours, diffMin);
    }
    @Override
    public ArrayList<String> toStringArr() {

        return new ArrayList<String>(List.of(
                Integer.toString(codCursa),
                dataPlecarii,
                oraPlecarii,
                Integer.toString(locatieInitiala),
                dataSosirii,
                oraSosirii,
                Integer.toString(destinatie),
                makeDurata(),
                Integer.toString(nrSaptamanii),
                Integer.toString(locDisponConfort),
                Integer.toString(locConfort),
                Float.toString(pretConfort),
                Integer.toString(locDisponEco),
                Integer.toString(locEco),
                Float.toString(pretEco),
                Integer.toString(idZiua)
        ));
    }
}
