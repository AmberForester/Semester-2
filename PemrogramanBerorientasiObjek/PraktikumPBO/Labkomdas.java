package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.text.DecimalFormat;
import java.util.Scanner;

class Kalkulator{
    
    static double tambah(double operan1, double operan2){
        return operan1 + operan2;
    }

    static double kurang(double operan1, double operan2){
        return operan1 - operan2;
    }

    static double kali(double operan1, double operan2){
        return operan1 * operan2;
    }

    static double bagi(double operan1, double operan2){
        return operan1 / operan2;
    }
}

public class Labkomdas {
    static final double HARGA_JAKET_A = 100000;
    static final double HARGA_JAKET_B = 125000;
    static final double HARGA_JAKET_C = 175000;
    double jumlahBarangA;
    double jumlahBarangB;
    double jumlahBarangC;
    double totalHarga;
    double totalHargaA, totalHargaB, totalHargaC;
    DecimalFormat rupiah = new DecimalFormat("###,###.00");
    Scanner sc = new Scanner(System.in);

    void perhitunganHarga(){
        if (jumlahBarangA >= 100) {
            totalHargaA += Kalkulator.kurang(Kalkulator.kali(HARGA_JAKET_A, jumlahBarangA), Kalkulator.kali(jumlahBarangA, Kalkulator.bagi(HARGA_JAKET_A, 20)));
            System.out.println(totalHargaA);
        } 
        else {
            totalHargaA += Kalkulator.kali(HARGA_JAKET_A, jumlahBarangA);
        }
        if (jumlahBarangB >= 100) {
            totalHargaB += Kalkulator.kurang(Kalkulator.kali(HARGA_JAKET_B, jumlahBarangB), Kalkulator.kali(jumlahBarangB, Kalkulator.bagi(HARGA_JAKET_B, 25)));
        } 
        else {
            totalHargaB += Kalkulator.kali(HARGA_JAKET_B, jumlahBarangB);
        }
        if (jumlahBarangC >= 100) {
            totalHargaC += Kalkulator.kurang(Kalkulator.kali(HARGA_JAKET_C, jumlahBarangC), Kalkulator.kali(jumlahBarangC,15000));
        } 
        else { 
            totalHargaC += Kalkulator.kali(HARGA_JAKET_C, jumlahBarangC);
        }
    }

    void finalisasi(){
        System.out.println();
        System.out.println("Jumlah Barang yang dibeli:");
        System.out.printf("%s: %.0f\n", "Jaket A", jumlahBarangA);
        System.out.printf("%s: %.0f\n", "Jaket B", jumlahBarangB);
        System.out.printf("%s: %.0f\n", "Jaket C", jumlahBarangC);

        System.out.println("Konfirmasi Pembelian");
        System.out.println("1. Oke \n2. Batal");
        System.out.print("Pilihan anda: ");
        int pilihan = sc.nextInt();
        switch(pilihan){
            case 1:
            notaPembelian();
            break;
            case 2:
            start();
            break; 
        }
    }

    void start(){
        System.out.println("Selamat Datang");
        System.out.println("Silakan Pilih Barang yang akan anda beli");
        System.out.println("1. Jaket A");
        System.out.println("Harga normal / harga satuan         : " + rupiah.format(HARGA_JAKET_A));
        System.out.println("Harga jika pembelian diatas 100 buah: " + rupiah.format(95000));
        System.out.println();
        System.out.println("2. Jaket B");
        System.out.println("Harga normal / harga satuan         : " + rupiah.format(HARGA_JAKET_B));
        System.out.println("Harga jika pembelian diatas 100 buah: " + rupiah.format(120000));
        System.out.println();
        System.out.println("3. Jaket C");
        System.out.println("Harga normal / harga satuan         : " + rupiah.format(HARGA_JAKET_C));
        System.out.println("Harga jika pembelian diatas 100 buah: " + rupiah.format(160000));
        System.out.println();
        System.out.print("Pilihan Anda: ");
        int pilihan = sc.nextInt(); sc.nextLine();
        switch(pilihan){
            case 1:
            System.out.print("jumlah barang: ");
            jumlahBarangA = sc.nextInt();
            perhitunganHarga();
            break;
            case 2:
            System.out.print("jumlah barang: ");
            jumlahBarangB = sc.nextInt();
            perhitunganHarga();
            break;
            case 3:
            System.out.print("jumlah barang: ");
            jumlahBarangC = sc.nextInt();
            perhitunganHarga();
            break;
        }
        yakin();
    }
    
    void yakin(){
        System.out.println();
        System.out.println("Apakah anda ingin menambah pesanan lain?");
        System.out.println("1. Ya \n2. Tidak");
        System.out.print("Pilihan anda: ");
        int pilihan = sc.nextInt();
        switch(pilihan){
            case 1:
            start();
            break;
            case 2:
            finalisasi();
            break;
        }
        System.out.println();
    }

    void notaPembelian(){
        totalHarga = Kalkulator.tambah(totalHargaA, Kalkulator.tambah(totalHargaB, totalHargaC));
        System.out.println();
        System.out.println("======================================================");
        System.out.printf("%-20s%-20s%s\n", "Nama Barang", "jumlah", "total");
        System.out.println("======================================================");
        System.out.printf("%-20s%-18.0f%s\n", "Jaket A", jumlahBarangA, rupiah.format(totalHargaA));
        System.out.printf("%-20s%-18.0f%s\n", "Jaket B", jumlahBarangB, rupiah.format(totalHargaB));
        System.out.printf("%-20s%-18.0f%s\n", "Jaket C", jumlahBarangC, rupiah.format(totalHargaC));
        System.out.println("======================================================");
        System.out.printf("%-38s%s\n", "total harga:", rupiah.format(totalHarga));
    }

    public static void main(String[] args) {
        Labkomdas beli = new Labkomdas();
        beli.start();
    }
}
