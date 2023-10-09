package entity;

import tbl.TableOrder;

import java.util.ArrayList;
import java.util.List;

public class Student extends Entity {
    private String stud_name;
    private int card_id;
    private int year;
    private String group;
    private int note1;
    private int note2;
    private int note3;
    private double average;


    public Student() {
    }

    public Student(String stud_name, int card_id, int year, String group, int note1, int note2, int note3, double average) {
        this.stud_name = stud_name;
        this.card_id = card_id;
        this.year = year;
        this.group = group;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.average = average;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(int note2) {
        this.note2 = note2;
    }

    public int getNote3() {
        return note3;
    }

    public void setNote3(int note3) {
        this.note3 = note3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stud_name='" + stud_name + '\'' +
                ", card_id=" + card_id +
                ", year=" + year +
                ", group='" + group + '\'' +
                ", note1=" + note1 +
                ", note2=" + note2 +
                ", note3=" + note3 +
                ", average=" + average +
                '}';
    }

    @Override
    public ArrayList<String> toStringArr() {
        return new ArrayList<String>(List.of(stud_name, Integer.toString(card_id), Integer.toString(year), group, Integer.toString(note1), Integer.toString(note2), Integer.toString(note3), Double.toString(average)));
    }
}
