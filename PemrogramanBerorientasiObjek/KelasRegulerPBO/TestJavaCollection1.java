package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.util.ArrayList;
import java.util.Iterator;

public class TestJavaCollection1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hadi");
        list.add("Putra");
        list.add("Farel");
        list.add("Gustav");
        // list.remove("Putra");
        // list.clear();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Hadi");
        list1.add("Putra");
        list.removeAll(list1);
        
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
