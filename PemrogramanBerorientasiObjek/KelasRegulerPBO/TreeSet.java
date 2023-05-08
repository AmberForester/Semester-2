package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.util.*;
public class TreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        set.add("Hadi");
        set.add("Putra");
        set.add("Farel");
        set.add("Gustav");
        System.out.println(set.first());
        Iterator itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
