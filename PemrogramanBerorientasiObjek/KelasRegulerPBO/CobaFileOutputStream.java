package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CobaFileOutputStream {
    public static void main(String[] args) {
        String namaFile;
        byte[] bufferData = new byte[1024];
        Scanner sc =new Scanner(System.in);
        System.out.print("Masukkan nama file: ");
        namaFile = sc.nextLine();
        System.out.println("Masukkan teks: ");
        try{
            System.in.read(bufferData);
        }
        catch(IOException e){
            System.err.println("Data tak terbaca");
        }
        try{
            FileOutputStream output = new FileOutputStream(namaFile);
            output.write(bufferData, 0, bufferData.length);
            output.close();
        }
        catch(IOException e){
            System.err.println("Maaf, file gagal dibuat dan ditulisi");
            System.exit(1);
        }
        System.out.println("file berhasil dibuka dan diisi");
    }
}
