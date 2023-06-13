package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.io.File;
import java.util.Scanner;

public class UkurFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama file: ");
        String namaFile = sc.nextLine();
        var file = new File(namaFile);
        double ukuranFile = file.length();

        String ukuran;
        if(ukuranFile < 1024 * 1024){
            ukuran = String.format("%.3f %s", ukuranFile / 1024, "KB");
        }
        else{
            ukuran = String.format("%.3f %s", ukuranFile / (1024*1024), "MB");
        }

        System.out.println("Nama file: " + namaFile);
        System.out.println("Ukuran file: " + ukuran);
    }
}
