package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.util.*;
public class TreeMap1 {
    public static void main(String[] args) {
        TreeMap <Integer, String> map = new TreeMap<Integer, String>();
        map.put(100,"Tari");
        map.put(101, "syila");
        map.put(102,"Putra");    
        map.put(103,"Adi"); 
          
        
        for(Map.Entry m:map.entrySet()){    
        System.out.println(m.getKey()+" "+m.getValue());
        System.out.println(map.containsKey(100));   
        }

    }
}
