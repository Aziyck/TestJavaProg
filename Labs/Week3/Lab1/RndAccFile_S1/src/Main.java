import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String FILE = "E:\\JavaPrograms\\Labs\\Week3\\Lab1\\RndAccFile_S1\\src\\data.dat";

//        Person x = new Person("Bors", "Alexandru", "Str. Viilor 19");
//        RandAccFileReadWrite.writeEnd(FILE, x.toString());
//        x = new Person("Lungu", "Dumitru", "Str.Stefan cel Mare 20");
//        RandAccFileReadWrite.writeEnd(FILE, x.toString());

        System.out.println( RandAccFileReadWrite.read(FILE) );

        System.out.println();
        RandAccFileReadWrite.writeOnPoz(FILE,"13\n",4);

        System.out.println( RandAccFileReadWrite.read(FILE) );

    }
}
