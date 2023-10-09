package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rute extends Entity{
    int codCursa;
    Date dataPlecarii = new Date();
    Date oraPlecarii = new Date();
    int locatieInitiala = 1;
    Date dataSosirii = new Date();
    Date oraSosirii = new Date();
    int destinatie = 1;
    long durata = 0;
    int nrSaptamanii = 0;
    int locDisponConfort = 0;
    int locConfort = 0;
    float pretConfort = 0;
    int locDisponEco = 0;
    int locEco = 0;
    float pretEco = 0;
    int idZiua = 1;

    public Rute() {
    }

    public Rute(int codCursa, Date dataPlecarii, Date oraPlecarii, int locatieInitiala, Date dataSosirii, Date oraSosirii, int destinatie, long durata, int nrSaptamanii, int locDisponConfort, int locConfort, float pretConfort, int locDisponEco, int locEco, float pretEco, int idZiua) {
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

    public Date getDataPlecarii() {
        return dataPlecarii;
    }

    public void setDataPlecarii(Date dataPlecarii) {
        this.dataPlecarii = dataPlecarii;
    }

    public Date getOraPlecarii() {
        return oraPlecarii;
    }

    public void setOraPlecarii(Date oraPlecarii) {
        this.oraPlecarii = oraPlecarii;
    }

    public int getLocatieInitiala() {
        return locatieInitiala;
    }

    public void setLocatieInitiala(int locatieInitiala) {
        this.locatieInitiala = locatieInitiala;
    }

    public Date getDataSosirii() {
        return dataSosirii;
    }

    public void setDataSosirii(Date dataSosirii) {
        this.dataSosirii = dataSosirii;
    }

    public Date getOraSosirii() {
        return oraSosirii;
    }

    public void setOraSosirii(Date oraSosirii) {
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

    @Override
    public ArrayList<String> toStringArr() {

        return new ArrayList<String>(List.of(
                Integer.toString(codCursa),
                dataPlecarii.toString(),
                oraPlecarii.toString(),
                Integer.toString(locatieInitiala),
                dataSosirii.toString(),
                oraSosirii.toString(),
                Integer.toString(destinatie),
                Long.toString(durata),
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
