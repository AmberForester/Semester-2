package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CobaFileReader {
    public static void main(String[] args) {
        String namaFile;
        int jumlahByte = 0;
        byte[] bufferData = new byte[1024];
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan nama file: ");
        namaFile = sc.nextLine();
        FileReader fileInput = null;
        try{
            fileInput = new FileReader(namaFile);
        }
        catch(IOException e){
            System.err.println("maaf, file tidak dapat dibuka");
            System.exit(1);
        }

        BufferedReader streamInput = new BufferedReader(fileInput);

        try{
            while(true){
                String barisData = streamInput.readLine();
                if(barisData == null) break;
                System.out.println(barisData);
            }
        }
        catch(IOException e){
            System.err.println("maaf, gagap");
            System.exit(1);
        }
        try{
            fileInput.close();
        }
        catch(IOException e){
            System.err.println("ada kesalahan menutup file");
            System.exit(1);
        }
    }
}
