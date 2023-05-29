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

class OlahData {

    void dataSama(LinkedHashMap<Integer, Pemain> kumpulanDataA, LinkedHashMap<Integer, Pemain> kumpulanDataB) {
        System.out.println("Data yang memiliki tinggi yang sama:");
        System.out.printf("%-5s%-10s%-5s%-3s\n", "No.", "Tim A", "No.", "Tim B");
        int indexA = 1;
        int indexB = 1;
        LinkedHashMap<Integer, Pemain> dataSama = new LinkedHashMap<>();
        ArrayList<Pemain> dataA = new ArrayList<>(kumpulanDataA.values());
        ArrayList<Pemain> dataB = new ArrayList<>(kumpulanDataB.values());
        Set<Integer> indexATerpakai = new HashSet<>();
        Set<Integer> indexBTerpakai = new HashSet<>();

        for (Pemain pemainA : dataA) {
            indexB = 1;
            for (Pemain pemainB : dataB) {
                if (pemainA.tinggi == pemainB.tinggi) {
                    if (!indexATerpakai.contains(indexA) && !indexBTerpakai.contains(indexB)) {
                        dataSama.put(indexA,pemainA);
                        indexATerpakai.add(indexA);
                        indexBTerpakai.add(indexB);
                    }
                    System.out.printf("%-5d%-5d  |   %-5d%-5d\n", indexA, pemainA.tinggi, indexB, pemainB.tinggi);
                }
                indexB++;
            }
            indexA++;
        }
        System.out.println();
        System.out.printf("%-10s%-3s\n","Tinggi", "Berat");
        for (Pemain pemain : dataSama.values()) {
            System.out.printf("%-5d  |   %-5d\n", pemain.tinggi, pemain.berat);
        }

        System.out.println();
        System.out.println("Data yang memiliki berat yang sama:");
        System.out.printf("%-5s%-10s%-5s%-3s\n", "No.", "Tim A", "No.", "Tim B");
        indexA = 1;
        for (Pemain pemainA : dataA) {
            indexB = 1;
            for (Pemain pemainB : dataB) {
                if(pemainA.berat == pemainB.berat){
                    System.out.printf("%-5d%-5d  |   %-5d%-5d\n", indexA, pemainA.berat, indexB, pemainB.berat);
                }
                indexB++;
            }
            indexA++;
        }
    }

    void maxMin(Map<Integer, Pemain> kumpulanData){
        int maxTinggi = 0;
        int minTinggi = 200;
        ArrayList<Pemain> dataA = new ArrayList<>(kumpulanData.values());
        for (Pemain data : dataA) {
            if(data.tinggi > maxTinggi){
                maxTinggi = data.tinggi;
            }
        }
        for (Pemain data : dataA) {
            if(data.tinggi < minTinggi){
                minTinggi = data.tinggi;
            }
        }
        System.out.printf("%-25s: ", "Rentang tinggi badan");
        System.out.println(minTinggi + " - " + maxTinggi + " cm");

        int maxBerat = 0;
        int minBerat = 200;
        for (Pemain data : dataA) {
            if(data.berat > maxBerat){
                maxBerat = data.berat;
            }
        }
        for (Pemain data : dataA) {
            if(data.berat < minBerat){
                minBerat = data.berat;
            }
        }
        System.out.printf("%-25s: ", "Rentang berat badan");
        System.out.println(minBerat + " - " + maxBerat + " kg");
    }

    void cariKomplemen(Map<Integer,Pemain> kumpulanDataA, Map<Integer,Pemain> kumpulanDataB) {
        ArrayList<Pemain> dataA = new ArrayList<>(kumpulanDataA.values());
        ArrayList<Pemain> dataB = new ArrayList<>(kumpulanDataB.values());
        ArrayList<Integer> dataTinggiA = new ArrayList<>();     
        ArrayList<Integer> dataTinggiB = new ArrayList<>();
        ArrayList<Integer> dataBeratA = new ArrayList<>();     
        ArrayList<Integer> dataBeratB = new ArrayList<>();
        for (Pemain tinggiA : dataA) {
            dataTinggiA.add(tinggiA.tinggi);
        }
        for (Pemain tinggiB : dataB) {
            dataTinggiB.add(tinggiB.tinggi);
        }
        for (Pemain beratA : dataA) {
            dataBeratA.add(beratA.berat);
        }
        for (Pemain beratB : dataB) {
            dataBeratB.add(beratB.berat);
        }
        ArrayList<Integer> dataKomplemenTinggi = new ArrayList<>(dataTinggiA);
        dataKomplemenTinggi.removeAll(dataTinggiB);
        System.out.printf("%-25s: ", "data tinggi badan:");
        for (int data : dataKomplemenTinggi) {
            System.out.print(data + " ");
        }
        ArrayList<Integer> dataKomplemenBerat = new ArrayList<>(dataBeratA);
        dataKomplemenBerat.removeAll(dataBeratB);
        System.out.printf("\n%-25s: ", "data berat badan:");
        for (int data : dataKomplemenBerat) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    void editData(Map <Integer, Pemain> data){
        ArrayList<Pemain> listData = new ArrayList<>(data.values());
        System.out.printf("%-10s%-3s\n","Tinggi", "Berat");
        for (Pemain pemain : listData) {
            if(pemain.tinggi == 168){
                pemain.berat = 66;
            }
            System.out.printf("%-5d  |   %-5d\n", pemain.tinggi, pemain.berat);
        }
    }
}  

public class JavaCollection {
    public static void main(String[] args) {

        LinkedHashMap <Integer, Pemain> timA = new LinkedHashMap<>();
        timA.put(1, new Pemain(168, 50));
        timA.put(2, new Pemain(170, 60));
        timA.put(3, new Pemain(165, 56));
        timA.put(4, new Pemain(168, 55));
        timA.put(5, new Pemain(172, 60));
        timA.put(6, new Pemain(170, 70));
        timA.put(7, new Pemain(169, 66));
        timA.put(8, new Pemain(165, 56));
        timA.put(9, new Pemain(171, 72));
        timA.put(10, new Pemain(166, 56));

        LinkedHashMap <Integer, Pemain> timB = new LinkedHashMap<>();
        timB.put(1, new Pemain(170, 66));
        timB.put(2, new Pemain(167, 60));
        timB.put(3, new Pemain(165, 59));
        timB.put(4, new Pemain(166, 58));
        timB.put(5, new Pemain(168, 58));
        timB.put(6, new Pemain(175, 71));
        timB.put(7, new Pemain(172, 68));
        timB.put(8, new Pemain(171, 68));
        timB.put(9, new Pemain(168, 65));
        timB.put(10, new Pemain(169, 60));

        // timB.put(5, new Pemain(168, 66));
        // timB.put(9, new Pemain(168, 66));

        OlahData coba = new OlahData();
        coba.dataSama(timA, timB);
        // System.out.println("Tim A");
        // coba.maxMin(timA);
        // System.out.println();
        // System.out.println("Tim B");
        // coba.maxMin(timB);
        // System.out.println("Data A yang tidak terdapat di B: ");
        // coba.cariKomplemen(timA, timB);
        // System.out.println();
        // System.out.println("Data B yang tidak terdapat di A: ");
        // coba.cariKomplemen(timB, timA);
        // coba.editData(timB);

        


        // Map<Integer, Integer> tinggiTimA = new HashMap<>();
        // tinggiTimA.put(1, 168);
        // tinggiTimA.put(2, 170);
        // tinggiTimA.put(3, 165);
        // tinggiTimA.put(4, 168);
        // tinggiTimA.put(5, 172);
        // tinggiTimA.put(6, 170);
        // tinggiTimA.put(7, 169);
        // tinggiTimA.put(8, 165);
        // tinggiTimA.put(9, 171);
        // tinggiTimA.put(10, 166);

        // Map<Integer, Integer> beratTimA = new HashMap<>();
        // beratTimA.put(1, 50);
        // beratTimA.put(2, 60);
        // beratTimA.put(3, 56);
        // beratTimA.put(4, 55);
        // beratTimA.put(5, 60);
        // beratTimA.put(6, 70);
        // beratTimA.put(7, 66);
        // beratTimA.put(8, 56);
        // beratTimA.put(9, 72);
        // beratTimA.put(10, 56);

        // LinkedHashMap<Integer, Integer> tinggiTimB = new LinkedHashMap<>();
        // tinggiTimB.put(1, 170);
        // tinggiTimB.put(2, 167);
        // tinggiTimB.put(3, 165);
        // tinggiTimB.put(4, 166);
        // tinggiTimB.put(5, 168);
        // tinggiTimB.put(6, 175);
        // tinggiTimB.put(7, 172);
        // tinggiTimB.put(8, 171);
        // tinggiTimB.put(9, 168);
        // tinggiTimB.put(10, 169);

        // Map<Integer, Integer> beratTimB = new HashMap<>();
        // beratTimB.put(1, 66);
        // beratTimB.put(10, 60);
        // beratTimB.put(2, 59);
        // beratTimB.put(3, 58);
        // beratTimB.put(4, 58);
        // beratTimB.put(5, 71);
        // beratTimB.put(6, 68);
        // beratTimB.put(7, 68);
        // beratTimB.put(8, 65);
        // beratTimB.put(9, 60);
        
        

        

    }
}
