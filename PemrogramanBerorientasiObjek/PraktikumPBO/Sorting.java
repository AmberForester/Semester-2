package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.util.*;

class Pemain{
    int tinggi;
    int berat;
    
    public Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }
}

class CompareTinggi implements Comparator<Pemain>{

    public int compare(Pemain p1, Pemain p2){
        if(p1.tinggi < p2.tinggi){
            return -1;
        }
        else if(p1.tinggi > p2.tinggi){
            return 1;
        }
        return 0;
    }
}

class CompareBerat implements Comparator<Pemain>{

    public int compare(Pemain p1, Pemain p2){
        if(p1.berat < p2.berat){
            return -1;
        }
        else if(p1.berat > p2.berat){
            return 1;
        }
        return 0;
    }
}

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain(168, 50));
        timA.add(new Pemain(170, 60));
        timA.add(new Pemain(165, 56));
        timA.add(new Pemain(168, 55));
        timA.add(new Pemain(172, 60));
        timA.add(new Pemain(170, 70));
        timA.add(new Pemain(169, 66));
        timA.add(new Pemain(165, 56));
        timA.add(new Pemain(171, 72));
        timA.add(new Pemain(166, 56));

        ArrayList<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain(170, 66));
        timB.add(new Pemain(167, 60));
        timB.add(new Pemain(165, 59));
        timB.add(new Pemain(166, 58));
        timB.add(new Pemain(168, 58));
        timB.add(new Pemain(175, 71));
        timB.add(new Pemain(172, 68));
        timB.add(new Pemain(171, 68));
        timB.add(new Pemain(168, 65));
        timB.add(new Pemain(169, 60)); 
        
        CompareTinggi ct = new CompareTinggi();
        CompareBerat cb = new CompareBerat();

        // nomor 1a
        Collections.sort(timA, ct);
        System.out.println("Sorting Ascending Tinggi Tim A");
        print(timA);
        Collections.sort(timA, ct.reversed());
        System.out.println("Sorting Decending Tinggi Tim A");
        print(timA);
        Collections.sort(timB, ct);
        System.out.println("Sorting Ascending Tinggi Tim B");
        print(timB);
        Collections.sort(timB, ct.reversed());
        System.out.println("Sorting Decending Tinggi Tim B");
        print(timB);

        // nomor 1b
        Collections.sort(timA, cb); 
        System.out.println("Sorting Ascending Berat Tim A");
        print(timA);
        Collections.sort(timA, cb.reversed());
        System.out.println("Sorting Decending Berat Tim A");
        print(timA);
        Collections.sort(timB, cb);
        System.out.println("Sorting Decending Berat Tim B");
        print(timB);
        Collections.sort(timB, cb.reversed());
        System.out.println("Sorting Decending Berat Tim B");
        print(timB);
        
        // nomor 1c
        Pemain maxTinggiA = Collections.max(timA, ct);
        System.out.println("Nilai tinggi max tim A: " + maxTinggiA.tinggi + " cm");
        Pemain minTinggiA = Collections.min(timA, ct);
        System.out.println("Nilai tinggi min tim A: " + minTinggiA.tinggi + " cm");
        Pemain maxBeratA = Collections.max(timA, ct);
        System.out.println("Nilai berat max tim A: " + maxBeratA.berat + " kg");
        Pemain minBeratA = Collections.min(timA, ct);
        System.out.println("Nilai berat min tim A: " + minBeratA.berat + " kg");

        Pemain maxTinggiB = Collections.max(timB, ct);
        System.out.println("Nilai tinggi max tim B: " + maxTinggiB.tinggi + " cm");
        Pemain minTinggiB = Collections.min(timB, ct);
        System.out.println("Nilai tinggi min tim B: " + minTinggiB.tinggi + " cm");
        Pemain maxBeratB = Collections.max(timB, ct);
        System.out.println("Nilai berat max tim B: " + maxBeratB.berat + " kg");
        Pemain minBeratB = Collections.min(timB, ct);
        System.out.println("Nilai berat min tim B: " + minBeratB.berat + " kg");

        System.out.println();

        // nomor 1d
        Pemain[] ukuran = new Pemain[10];
        List<Pemain> copyTimC = Arrays.asList(ukuran);
        Collections.copy(copyTimC, timB);
        ArrayList<Pemain> timC = new ArrayList<>(copyTimC);
        print(timC);
        
        // nomor 2b
        System.out.println("Mencari Data Tim B: ");
        cariTinggi(timB, 168);
        cetakCariTinggi(timB, 168);
        cariTinggi(timB, 160);
        cetakCariTinggi(timB, 160);
        System.out.println();

        // nomor 2c
        System.out.println("Mencari Data tim A");
        cariBerat(timA, 56);
        cetakCariBerat(timA, 56);
        cariBerat(timA, 53);
        cetakCariBerat(timA, 53);

        // nomor 2d
        System.out.println("Terdapat beberapa data yang sama dari data A dan data B");
        sama(timA, timB);   
    }

    static void print(ArrayList<Pemain> tim){
        System.out.printf("%-8s%-4s%s\n", "Tinggi", "|", "Berat");
        for (Pemain pemain : tim) {
            System.out.printf("%-1s%-7d%-5s%d\n","", pemain.tinggi, "|", pemain.berat);
        }
        System.out.println();
    }

    static void sama(ArrayList<Pemain> data1, ArrayList<Pemain> data2){
        System.out.println();
        System.out.printf("%-6s%-21s%s\n", "", "Tim A", "Tim B");
        for (Pemain pemain1 : data1) {
            for (Pemain pemain2 : data2) {
                if(pemain1.tinggi == pemain2.tinggi || pemain1.berat == pemain2.berat){
                    System.out.printf("%-1s%-7d%-5s%-8d","", pemain1.tinggi, "|", pemain1.berat);
                    System.out.printf("%-1s%-7d%-5s%d\n","", pemain2.tinggi, "|", pemain2.berat);
                }
            }
        }
    }

    static void cariTinggi(List<Pemain> data, int key) {
        CompareTinggi ct = new CompareTinggi();
        Collections.sort(data, ct);
        int firstIndex = Collections.binarySearch(data, new Pemain(key, -1), Comparator.comparingInt(p -> p.tinggi));
        int lastIndex = firstIndex;
        if (firstIndex >= 0) {
            while (firstIndex > 0 && data.get(firstIndex - 1).tinggi == key) {
                firstIndex--;
            }
            while (lastIndex < data.size() - 1 && data.get(lastIndex + 1).tinggi == key) {
                lastIndex++;
            }
    
            int count = lastIndex - firstIndex + 1;
            System.out.println("Jumlah pemain dengan tinggi " + key + " adalah " + count);
        } else {
            System.out.println("Pemain dengan tinggi " + key + " tidak ditemukan");
        }
    }
    
    static void cariBerat(List<Pemain> data, int key){
        CompareBerat cb = new CompareBerat();
        Collections.sort(data, cb);
        int firstIndex = Collections.binarySearch(data, new Pemain(0,key), cb);
        int lastIndex = firstIndex;
        if (firstIndex >= 0) {
            while (firstIndex > 0 && data.get(firstIndex - 1).berat == key) {
                firstIndex--;
            }
            while (lastIndex < data.size() - 1 && data.get(lastIndex + 1).berat == key) {
                lastIndex++;
            }
            int count = lastIndex - firstIndex + 1;
            System.out.println("Jumlah pemain dengan berat " + key + " adalah " + count);
        } else {
            System.out.println("Pemain dengan berat " + key + " tidak ditemukan");
        }
    }

    static void cetakCariTinggi(ArrayList<Pemain> data ,int key){
        boolean ketemu = false;
        for (Pemain dataPemain : data) {
            if(dataPemain.tinggi == key){
                System.out.printf("%-1s%-7d%-5s%d\n","", dataPemain.tinggi, "|", dataPemain.berat);
                ketemu = true;
            }
        }
        if(!ketemu){
            System.out.println("Data " + key + " tidak ditemukan");
        }
    }

    static void cetakCariBerat(ArrayList<Pemain> data ,int key){
        boolean ketemu = false;
        for (Pemain dataPemain : data) {
            if(dataPemain.berat == key){
                System.out.printf("%-1s%-7d%-5s%d\n","", dataPemain.tinggi, "|", dataPemain.berat);
                ketemu = true;
            }
        }
        if(!ketemu){
            System.out.println("Data " + key + " tidak ditemukan");
        }
    }
}

