package tbl;

import entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class TableHelper {

//    public static <T extends Entity> ArrayList<ArrayList<String>> ConvertObjListToStrList(ArrayList<T> arr) throws InvocationTargetException, IllegalAccessException {
//        ArrayList<ArrayList<String>> arrConverted = new ArrayList<>();
//        T t = null;
//        for(T elemet : arr){
//            ArrayList<String> temp = new ArrayList<>();
//            for(String className : elemet.TableOrder()){
//                for(Method m : elemet.getClass().getMethods()){
//                    if(m.getName().equals(className)){
//
//                        temp.add(m.invoke(elemet).toString());
//
//                    }
//                }
//            }
//            arrConverted.add(temp);
//        }
//        return arrConverted;
//    }

    public static <T extends Entity> ArrayList<ArrayList<String>> ConvertObjListToStringList(List<T> arr){
        ArrayList<ArrayList<String>> arrConverted = new ArrayList<>();
        for(T element : arr){
            arrConverted.add(element.toStringArr());
        }
        return arrConverted;
    }
}
