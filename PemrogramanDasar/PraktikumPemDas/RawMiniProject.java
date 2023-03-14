package PemrogramanDasar.PraktikumPemDas;
import java.util.Scanner;
public class RawMiniProject {
    public static void main(String[] args){

// camelCase --> variable
// PascalCase --> class
// SCREAMING_SNAKE_CASE --> variable final

    Scanner x = new Scanner(System.in);
    System.out.println("MENGONVERSIKAN SATUAN PANJANG KE SATUAN INTERNASIONAL");
    System.out.printf("%-25s: ", "Masukkan panjang");
        float jarak = x.nextFloat();
        x.nextLine();
    System.out.println("=====================================");
    System.out.println("Silahkan pilih satuan awal : ");
    System.out.printf("%-15s \n", "1. Kilometer");
    System.out.printf("%-15s \n", "2. Hektometer");
    System.out.printf("%-15s \n", "3. Dekameter");
    System.out.printf("%-15s \n", "4. Desimeter");
    System.out.printf("%-15s \n", "5. Centimeter");
    System.out.printf("%-15s \n", "6. Milimeter");
    System.out.print("ketikan angka : ");
        String angka = x.nextLine();
    System.out.println("=====================================");

    if(angka.equals("1")){
        System.out.println("Konversi satuan kilometer ke meter");
        float hasil = jarak * 1000;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }
    else if(angka.equals("2")) {
        System.out.println("Konversi satuan hektometer ke meter");
        float hasil = jarak * 100;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }
    else if(angka.equals("3")) {
        System.out.println("Konversi satuan dekameter ke meter");
        float hasil = jarak * 10;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }
    else if(angka.equals("4")) {
        System.out.println("Konversi satuan desimeter ke meter");
        float hasil = jarak / 10;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }
    else if(angka.equals("5")) {
        System.out.println("Konversi satuan centimeter ke meter");
        float hasil = jarak / 100;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }
    else if(angka.equals("6")) {
        System.out.println("Konversi satuan milimeter ke meter");
        float hasil = jarak / 1000;
        System.out.println("hasil konversi : " + hasil + " m");
        System.out.println("=====================================");
    }

    }
}
