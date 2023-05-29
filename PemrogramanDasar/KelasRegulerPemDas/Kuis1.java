import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Kuis1 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(); x.nextLine();
        String kasir = x.nextLine();
        String[] namaBarang = new String[n];
        int[] jumlahBarang = new int[n];
        int[] hargaBarang = new int[n];
        int[] hargaTotalBarang = new int[n];
        int subTotal = 0;

        for(int i = 0; i < n; i++){
            namaBarang[i] = x.next();
            jumlahBarang[i] = x.nextInt();
            hargaBarang[i] = x.nextInt();
            hargaTotalBarang[i] = jumlahBarang[i] * hargaBarang[i];
            subTotal += hargaTotalBarang[i];
        }
        int bayar = x.nextInt();
        System.out.println("");
        System.out.println("FILKOM-MART");
        System.out.println("Jl. VETERAN, MALANG");
        System.out.println("TELP. 0341-577911");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy\t\t\t\t  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.printf("%-20s:%13s\n", "Receipt Number",(int)Math.floor(Math.random()*30000)+15000);
        System.out.printf("%-20s:%13s\n", "Order ID",(int)Math.floor(Math.random()*30000)+15000);
        System.out.printf("%-20s:%13s\n", "Collected by", kasir);
        System.out.println("====================================");

        for(int j = 0; j < n; j++){
            System.out.println(namaBarang[j]);
            System.out.printf("%dx\t@%-15d Rp.%10d \n", jumlahBarang[j], hargaBarang[j], hargaTotalBarang[j]);
        }

        System.out.println("====================================");
        System.out.printf("%-20s Rp.%10d\n", "Subtotal", subTotal);
        System.out.println("Diskon");
        int diskon = subTotal / 10;
        System.out.printf("%-20s Rp.%10d\n", "10%", diskon);
        System.out.println("====================================");
        int total = subTotal - diskon;
        int kembali = bayar - total;
        System.out.printf("%-20s Rp.%10d\n", "total", total);
        System.out.printf("%-20s Rp.%10d\n", "bayar", bayar);
        System.out.println("====================================");
        System.out.printf("%-20s Rp.%10d\n", "kembali", kembali);
        System.out.println("====================================");
        System.out.println("Terimakasih Telah Berbelanja di FILKOM-MART");


//        int jumlahBarang = 0, hargaBarang = 0, hargaTiapBarang = 0, subTotal = 0;
//        for (int i = 0; i < n; i++) {
//            namaBarang = x.nextLine();
//            jumlahBarang = x.nextInt(); x.nextLine();
//            hargaBarang = x.nextInt(); x.nextLine();
//            hargaTiapBarang = jumlahBarang * hargaBarang;
//            subTotal += hargaBarang;
//        }
//        for(int j = 0; j < n; j++){
//            System.out.println(namaBarang);
//            System.out.printf("%d%s \t %-15d %5d\n", jumlahBarang,"x" , hargaBarang, hargaTiapBarang);
//        }
//        System.out.println("=======================================");
//        System.out.printf("%s%15d\n", "Subtotal", subTotal);
//        System.out.println("Diskon");
//        int diskon = subTotal / 10;
//        System.out.printf("%s-%d\n", "10%", diskon);
//        System.out.println("=======================================");

    }
}







