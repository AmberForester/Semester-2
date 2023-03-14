package PemrogramanDasar.PraktikumPemDas;
import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("PENGONVERSI SATUAN PANJANG");
        System.out.println("=====================================");
        System.out.println("Silahkan pilih satuan awal");
        System.out.printf("%-15s \n", "1. Kilometer");
        System.out.printf("%-15s \n", "2. Meter");
        System.out.printf("%-15s \n", "3. Centimeter");
        System.out.printf("%-15s \n", "4. Milimeter");
        System.out.printf("%-18s: ", "ketikan angka");
        String angka = scn.nextLine();
        System.out.println("=====================================");
        System.out.println("Silahkan pilih satuan akhir");
        System.out.printf("%-15s \n", "1. Kilometer");
        System.out.printf("%-15s \n", "2. Meter");
        System.out.printf("%-15s \n", "3. Centimeter");
        System.out.printf("%-15s \n", "4. Milimeter");
        System.out.printf("%-18s: ", "ketikan angka");
        String angka2 = scn.nextLine();
        System.out.println("========================================================");
        System.out.printf("%-18s: ", "Masukkan panjang");
        float jarak = scn.nextFloat();
        scn.nextLine();
        System.out.println("========================================================");

        float puluhan = jarak * 10;
        float puluhan2 = jarak / 10;
        float ratusan = jarak * 100;
        float ratusan2 = jarak / 100;
        float ribuan = jarak * 1000;
        float ribuan2 = jarak / 1000;
        float ratusanribu = jarak * 100000;
        float ratusanribu2 = jarak / 100000;
        float jutaan = jarak * 1000000;
        float jutaan2 = jarak / 1000000;

        if(angka.equals("1") && angka2.equals("1")){
            System.out.println("Konversi Kilometer ke Kilometer");
            System.out.println("Panjang sudah memiliki satuan yang sama");
            System.out.println("Silakan masukkan satuan awal dan akhir yang berbeda");
        }
        else if(angka.equals("1") && angka2.equals("2")){
            System.out.println("Konversi Kilometer ke Meter");
            System.out.println("Hasil konversi : "+ ribuan + " m");
        }
        else if(angka.equals("1") && angka2.equals("3")) {
            System.out.println("Konversi Kilometer ke Centimeter");
            System.out.println("Hasil konversi : " + ratusanribu + " cm");
        }
        else if(angka.equals("1") && angka2.equals("4")) {
            System.out.println("Konversi Kilometer ke Milimeter");
            System.out.println("Hasil konversi : " + jutaan + " mm");
        }
        else if(angka.equals("2") && angka2.equals("1")){
            System.out.println("Konversi Meter ke Kilometer");
            System.out.println("Hasil konversi : "+ ribuan2 + " km");
        }
        else if(angka.equals("2") && angka2.equals("2")){
            System.out.println("Konversi Meter ke Meter");
            System.out.println("Panjang sudah memiliki satuan yang sama");
            System.out.println("Silakan masukkan satuan awal dan akhir yang berbeda");
        }
        else if(angka.equals("2") && angka2.equals("3")) {
            System.out.println("Konversi Meter ke Centimeter");
            System.out.println("Hasil konversi : " + ratusan + " cm");
        }
        else if(angka.equals("2") && angka2.equals("4")) {
            System.out.println("Konversi Meter ke Milimeter");
            System.out.println("Hasil konversi : " + ribuan + " mm");
        }
        else if(angka.equals("3") && angka2.equals("1")) {
            System.out.println("Konversi Centimeter ke Kilometer");
            System.out.println("Hasil konversi : " + ratusanribu2 + " km");
        }
        else if(angka.equals("3") && angka2.equals("2")) {
            System.out.println("Konversi Centimeter ke Meter");
            System.out.println("Hasil konversi : " + ratusan2 + " m");
        }
        else if(angka.equals("3") && angka2.equals("3")) {
            System.out.println("Konversi Centimeter ke Centimeter");
            System.out.println("Panjang sudah memiliki satuan yang sama");
            System.out.println("Silakan masukkan satuan awal dan akhir yang berbeda");
        }
        else if(angka.equals("3") && angka2.equals("4")) {
            System.out.println("Konversi Centimeter ke Milimeter");
            System.out.println("Hasil konversi : " + puluhan + " mm");
        }
        else if(angka.equals("4") && angka2.equals("1")) {
            System.out.println("Konversi Milimeter ke Kilometer");
            System.out.println("Hasil konversi : " + jutaan2 + " km");
        }
        else if(angka.equals("4") && angka2.equals("2")) {
            System.out.println("Konversi Milimeter ke Meter");
            System.out.println("Hasil konversi : " + ribuan2 + " m");
        }
        else if(angka.equals("4") && angka2.equals("3")) {
            System.out.println("Konversi Milimeter ke Centimeter");
            System.out.println("Hasil konversi : " + puluhan2 + " cm");
        }
        else if(angka.equals("4") && angka2.equals("4")) {
            System.out.println("Konversi Milimeter ke Milimeter");
            System.out.println("Panjang sudah memiliki satuan yang sama");
            System.out.println("Silakan masukkan satuan awal dan akhir yang berbeda");
        }else{
            System.out.println("angka tidak tersedia pada pilihan satuan");
            System.out.println("silakan masukkan angka yang tersedia pada pilihan satuan");
        }
        System.out.println("========================================================");

    }


}
