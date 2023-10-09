import entity.Student;
import tbl.Table;
import tbl.TableHelper;
import dao.Implements.StudetDAOimpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printStudenti(List<Student> ListOfStudents){
        ArrayList<String> header = new ArrayList<>(List.of("Student Name", "ID", "An", "Grupa", "Nota1", "Nota2", "Nota3", "Average"));
        ArrayList<ArrayList<String>> tableBody = TableHelper.ConvertObjListToStringList(ListOfStudents);

        Table table = new Table(header, tableBody);
        try {
            table.addCountToTable();
            table.calculateDinamicLenghOfCells(1);
        }catch (Exception e){}

        System.out.println(table);
    }

    public static void main(String[] args) throws Exception {
//        SqlHelper.insertStudents();

        StudetDAOimpl studetDAOimpl = new StudetDAOimpl();


        List<Student> ListOfStudents = studetDAOimpl.findAll();
        printStudenti(ListOfStudents);

        try {
            ListOfStudents = List.of(studetDAOimpl.findEntityById(34));
            printStudenti(ListOfStudents);
        } catch (Exception e){}


        ListOfStudents = studetDAOimpl.findStudentByName("Onica Iulian");
        printStudenti(ListOfStudents);

        ListOfStudents = studetDAOimpl.findEntityByGroup("P-2031");
        printStudenti(ListOfStudents);

        ListOfStudents = studetDAOimpl.findEntityByAn(4);
        printStudenti(ListOfStudents);


        try {
            List<Student> students = studetDAOimpl.findStudentByName("Hancu Maria");
            Student student = students.get(0);
            student.setStud_name("Bors Alexandru");
            studetDAOimpl.update(student);
            ListOfStudents = studetDAOimpl.findAll();
            printStudenti(ListOfStudents);

            student.setStud_name("Hancu Maria");
            studetDAOimpl.update(student);
            ListOfStudents = studetDAOimpl.findAll();
            printStudenti(ListOfStudents);

            students = studetDAOimpl.findStudentByName("Hancu Maria");
            studetDAOimpl.create(student);
            ListOfStudents = studetDAOimpl.findAll();
            printStudenti(ListOfStudents);

            studetDAOimpl.delete(students);
            ListOfStudents = studetDAOimpl.findAll();
            printStudenti(ListOfStudents);

            studetDAOimpl.create(student);
            ListOfStudents = studetDAOimpl.findAll();
            printStudenti(ListOfStudents);

        } catch (Exception e){}


//
//        System.out.println("INSERTED AND PRINTED THE TABLE STUDENTS");
//        SqlHelper.insertStudents();
//        SqlHelper.printStudents();
//
//        System.out.println("CREATED INSERTED AND PRINTED THE TABLE OBIECTE");
//        SqlHelper.createObiecte();
//        //dropObiecte();
//        //insertObiecte();
//        SqlHelper.printObiecte();
//
//        System.out.println("PRINT STUDENTS WITH CONDITION");
//        SqlHelper.printStudents("WHERE \"group\" = 'P-2041'");
//
//        System.out.println("UPDATED TABLE STUDENTS");
//        SqlHelper.executeStatment("UPDATE public.\"Students\" SET stud_name='Carmanschi Alexandru' WHERE card_id = 9");
//        SqlHelper.printStudents();
//        SqlHelper.executeStatment("UPDATE public.students SET stud_name='Hancu Maria' WHERE card_id = '10'");
//        SqlHelper.printStudents();
//
//        System.out.println("ADDED AND REMOVED DATA INTO TABLE STUDENTS");
//        SqlHelper.executeStatment("INSERT INTO public.Students(stud_name, \"year\", \"group\", note1, note2, note3, average) " +
//                "VALUES ('Bors Alexandru', 4, 'P-2041', 10, 9, 10, " + SqlHelper.average(10, 9, 10) + ")");
//        SqlHelper.printStudents();
//        SqlHelper.executeStatment("DELETE FROM public.students Where card_id = '11'");
//        SqlHelper.printStudents();

    }


}
