package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.io.FileOutputStream;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileOutputStream file = new FileOutputStream("D:/coba.txt")){
            String pesan = "Saya sedang mencoba Try With Resources";
            byte byteArray[] = pesan.getBytes();
            file.write(byteArray);
            System.out.println("Pesan Sudah Tersampaikan");
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}
