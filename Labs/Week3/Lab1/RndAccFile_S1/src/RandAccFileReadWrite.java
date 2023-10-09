import java.io.RandomAccessFile;

public class RandAccFileReadWrite {

    public static void writeEnd(String file, String data){
        RandomAccessFile randomAccessFile;

        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(data.getBytes());
            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeOnPoz(String file, String data, long poz){
        RandomAccessFile randomAccessFile;

        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            long current = findPers(file, poz);
            randomAccessFile.seek(current);

            //randomAccessFile.readLine();

            while (randomAccessFile.getFilePointer() < randomAccessFile.length()){;
                data += (char)randomAccessFile.readByte();
            }

            randomAccessFile.seek(current);
            randomAccessFile.write(data.getBytes());
            randomAccessFile.

            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static long findPers(String file, long poz){
        RandomAccessFile randomAccessFile;

        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            for (int i = 1; i < poz; i++) {
                randomAccessFile.readLine();
            }
            long pointer = randomAccessFile.getFilePointer();
            randomAccessFile.close();
            return pointer;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public static String read(String file){
        String rez = new String("");
        RandomAccessFile randomAccessFile;

        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long poz = 0;

            while (poz < randomAccessFile.length()){
                randomAccessFile.seek(poz);
                rez += (char)randomAccessFile.readByte();
                poz++;
            }
            randomAccessFile.close();
            return rez;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return rez;
        }
    }


}
