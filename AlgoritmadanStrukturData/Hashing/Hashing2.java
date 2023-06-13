package Hashing;


import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

class Entry<K,V> {
    private K kunci;
    private V nilai;
    Entry<K,V> next;

    public Entry(K kunci, V nilai){
        this.kunci = kunci;
        this.nilai = nilai;
    }

    public K getKunci() {
        return kunci;
    }
    public void setKunci(K kunci) {
        this.kunci = kunci;
    }
    public V getNilai() {
        return nilai;
    }
    public void setNilai(V nilai) {
        this.nilai = nilai;
    }
}

class Hashmap<K,V> {
    private Entry<K,V>[] tabel;
    private final int SIZE = 27;
    
    public Hashmap() {
        tabel = new Entry[this.SIZE];
    }
    
    int hash(K kunci){
        if(kunci == null){
            return 0;
        }
        char charKey = kunci.toString().toLowerCase().charAt(0);
        int indexHuruf = (int) charKey - 96;
        
        if(indexHuruf < 1 || indexHuruf > 26){
            return 0;
        }

        return Math.abs(indexHuruf % SIZE);
    }

    void put(K kunci, V nilai){
        int hashKey = hash(kunci);
        Entry<K,V> entry = tabel[hashKey];

        if(entry == null){
            tabel[hashKey] = new Entry<>(kunci, nilai);
        } 
        else{
            while(entry.next != null){
                if(entry.getKunci().equals(kunci)){
                    entry.setNilai(nilai);
                    return;
                }
                entry = entry.next;
            }
            if(entry.getKunci().equals(kunci)){
                entry.setNilai(nilai);
                return;
            }

            entry.next = new Entry<>(kunci, nilai);
        }
    }

    void remove(K kunci){
        int hashKey = hash(kunci);
        Entry<K,V> entry = tabel[hashKey];

        if(entry ==  null){
            return;
        }

        if(entry.getKunci().equals(kunci)){
            tabel[hashKey] = entry.next;
            entry.next = null;
            return;
        }

        Entry<K,V> prev = entry.next;

        while(entry != null){
            if(entry.getKunci().equals(kunci)){
                prev.next = entry.next;
                entry.next = null;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
        return;
    }

    String get(K kunci){
        int hashKey = hash(kunci);
        Entry<K,V> entry = tabel[hashKey];

        if(entry == null){
            return null;
        }

        if(entry.getKunci().equals(kunci)){
            return entry.getNilai().toString();
        }

        Entry<K,V> prev = entry.next;

        while(entry != null){
            if(entry.getKunci().equals(kunci)){
                return entry.getNilai().toString();
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    void printHash(){
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%s %d%s", "--", i, ":");
            Entry<K,V> entry = tabel[i];

            while(entry != null){
                System.out.printf(" %s%s%s%s%s", "(", entry.getKunci(), ", ", entry.getNilai(), ")");
                entry = entry.next;
            }  
            System.out.println();
        }
    }
}

public class Hashing2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashmap<String, String> map = new Hashmap<>();

        int jumlah = sc.nextInt(); sc.nextLine();
        String perintah = "";

        for (int i = 0; i < jumlah; i++) {
            perintah = sc.nextLine();
            String[] pisah = perintah.split(" ");

            switch(pisah[0]){
                case "put": 
                map.put(pisah[1], pisah[2]);
                break;
                case "print":
                map.printHash();
                break;
                case "remove":
                map.remove(pisah[1]);
                break;
                case "get":
                System.out.println(map.get(pisah[1]));
                break;
            }
        }     
    }
}






