package UapPbo2023;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    static ArrayList<Tanaman> tanamans = new ArrayList<>();
    static ArrayList<Integer> lokasi = new ArrayList<>();
    static Scanner in;

    static void mulai(){
        in = new Scanner(System.in);
        System.out.print("input masa tanam: ");
            int masaTanam = in.nextInt(); in.nextLine();
            int masaTanamHari =  masaTanam*30;

            for (int i = 0; i < 3; i++) {
                System.out.println("tes");
                menanam();
            }

        for (int i = 0; i < masaTanamHari; i++) {
            for (Tanaman t : tanamans) {
                if(t.status().equals("Hidup")){
                    if(t instanceof Tomat){
                        Tomat to = (Tomat) t;
                        to.berkembang();
                    }
                    else if(t instanceof Stroberi){
                        Stroberi stro = (Stroberi) t;
                        stro.berkembang();
                    }
                    else if(t instanceof Persik){
                        Persik per = (Persik) t;
                        per.berkembang();
                    }
                }
                // if(lokasi.equals(i)){
                //     continue;
                // }
                if(t.status().equals("Mati")){
                    lokasi.add(tanamans.indexOf(t));
                    menanam();
                }
                if(i % 90 == 0){
                     if (t instanceof Tomat){
                        Tomat to = (Tomat) t;
                        to.treatment();
                    }else if (t instanceof Stroberi){
                        Stroberi stro = (Stroberi) t;
                        stro.treatment();
                    }else if (t instanceof Persik){
                        Persik per = (Persik) t;
                        per.treatment();
                    }
                }
            }   
        }
    }


    static void menanam(){
        System.out.println("Pilih mau tanam apa");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");

        int input = in.nextInt(); 
        // in.nextLine();
        switch(input) {
            case 1:
                tanamans.add(new Tomat());
                System.out.println("Tanaman Berhasil ditanam lur");
                break;
            case 2:
                tanamans.add(new Stroberi());
                System.out.println("Tanaman Berhasil ditanam lur");
                break;
            case 3:
                tanamans.add(new Persik());
                System.out.println("Tanaman Berhasil ditanam lur");
                break;
        }
    }

    static void info(){
        for(int i = 0; i < tanamans.size(); i++){
            System.out.println("Tanaman nomor: " + (i+1));
            System.out.println(tanamans.get(i).toString());
        }
    }
}
