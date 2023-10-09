package tbl;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableCellLenght = 12;
    private ArrayList<String> header;
    private ArrayList<ArrayList<String>> cels;

    private ArrayList<Integer> cellDimentions = new ArrayList<>();

    public Table() {
    }

    public Table(ArrayList<String> header, ArrayList<ArrayList<String>> cels, int tableRowLenght) {
        this.tableCellLenght = tableRowLenght;
        this.header = header;
        this.cels = cels;

        for (int i = 0; i < header.size(); i++){
            cellDimentions.add(tableRowLenght);
        }

    }

    public Table(ArrayList<String> header, ArrayList<ArrayList<String>> cels) {
        this.header = header;
        this.cels = cels;

        for (int i = 0; i < header.size(); i++){
            cellDimentions.add(tableCellLenght);
        }
    }

    public int getTableCellLenght() {
        return tableCellLenght;
    }

    public void setTableCellLenght(int tableCellLenght) {
        this.tableCellLenght = tableCellLenght;
    }

    public ArrayList<String> getHeader() {
        return header;
    }

    public void setHeader(ArrayList<String> header) {
        this.header = header;
    }

    public ArrayList<ArrayList<String>> getCels() {
        return cels;
    }

    public void setCels(ArrayList<ArrayList<String>> cels) {
        this.cels = cels;
    }


    public void addCountToTable() throws Exception {
        ArrayList<String> headerTemp = new  ArrayList<>(List.of("Nr"));
        headerTemp.addAll(header);
        header = new ArrayList<>(headerTemp);

        cellDimentions.add(tableCellLenght);

        ArrayList<ArrayList<String>> celsTemp = new ArrayList<>();

        int i = 1;
        for(ArrayList<String> rows : cels){
            ArrayList<String> rowsTemp = new  ArrayList<>(List.of(Integer.toString(i)));
            rowsTemp.addAll(rows);

            rows = new ArrayList<>(rowsTemp);
            celsTemp.add(rows);

            i++;
        }

        cels = new ArrayList<>(celsTemp);

//        calculateDinamicLenghOfCells(1);
    }
    public void calculateDinamicLenghOfCells() throws Exception {
        for(int i = 0; i < header.size(); i++){
            int max = header.get(i).length();

            for (int j = 0; j < cels.size(); j++){
                if (cels.get(j).size() != header.size()) throw new Exception("Invalid number of cels!");
                if (cels.get(j).get(i).length() > max) max = cels.get(j).get(i).length();
            }
            cellDimentions.set(i,max);
        }

    }

    public void calculateDinamicLenghOfCells(int plusSpaces) throws Exception {
        if(plusSpaces < 0) throw new Exception("Incorect number of spaces");
        for(int i = 0; i < header.size(); i++){
            int max = header.get(i).length();

            for (int j = 0; j < cels.size(); j++){
                if (cels.get(j).size() != header.size()) throw new Exception("Invalid number of cels!");
                if (cels.get(j).get(i).length() > max) max = cels.get(j).get(i).length();
            }
            cellDimentions.set(i,max+plusSpaces);
        }

    }

    private String buildHeadder(){
        final String ANSI_BOLD = "\u001B[1m";
        final String ANSI_RESET = "\u001B[0m";

        String rez = buildTableSeparator(header.size());
        rez += ANSI_BOLD;
        rez += "|";
        int i = 0;
        for(String headerItem : header){
            rez += addPaddingSpaces(headerItem, cellDimentions.get(i));
            i++;
        }
        rez += ANSI_RESET;
        rez += "\n";
        rez += buildTableSeparator(header.size());

        return  rez;
    }

    private String buildBody() throws Exception {
        String rez = new String();
        for(ArrayList<String> tableRow : cels){
            if (tableRow.size() != header.size()) throw new Exception("Invalid number of cels!");

            rez += "|";
            int i = 0;
            for(String cellData : tableRow){
                rez += addPaddingSpaces(cellData,cellDimentions.get(i));
                i++;
            }
            rez += "\n";
        }
        rez += buildTableSeparator(header.size());
        return rez;
    }

    private String buildTable() throws Exception {
        return buildHeadder() + buildBody();
    }

    private String buildTableSeparator(int tableColums){
        StringBuilder rez = new StringBuilder("|");
        for(int i=0; i<tableColums; i++){
            rez.append(addPaddingSpaces("",cellDimentions.get(i)));
        }
        return rez.toString().replace(" ", "-") + "\n";
    }

    private  String addPaddingSpaces(String text) {
        if(text.length() > tableCellLenght){
            text = text.substring(0, tableCellLenght);
        }
        return String.format( "%-" + tableCellLenght + "s|", text);
    }

    private  String addPaddingSpaces(String text, int tableCellLenght) {
        if(text.length() > tableCellLenght){
            text = text.substring(0, tableCellLenght);
        }
        return String.format( "%-" + tableCellLenght + "s|", text);
    }

    @Override
    public String toString() {
        try {
            return buildTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
