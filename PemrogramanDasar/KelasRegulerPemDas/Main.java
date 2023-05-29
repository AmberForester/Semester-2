import java.util.Scanner;
public class Main {
public static void main(String []args){
Scanner x = new Scanner(System.in);
    double a1 = x.nextDouble();
    double a2 = x.nextDouble();
    double jumlah = a1 + a2;
    double selisih = a1 - a2;
    double kali = a1 * a2;
    double bagi = a1 / a2;
        System.out.printf("%-20s : %-5.4s \n", "operator pertama", a1);
        System.out.printf("%-20s : %-5.4s \n", "operator kedua", a2);
        System.out.printf("%-20s : %-5.4s \n", "penjumlahan", jumlah);
        System.out.printf("%-20s : %-5.4s \n", "pengurangan", selisih);
        System.out.printf("%-20s : %-5.4s \n", "perkalian", kali);
        System.out.printf("%-20s : %-5.4s \n", "pembagian", bagi);
}
}
