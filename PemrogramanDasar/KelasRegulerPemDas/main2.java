import java.util.Scanner;
public class main2 {
    public static void main (String []args){
        Scanner x = new Scanner(System.in);

        String nama = x.nextLine();
        String kel = x.nextLine();
        int kwh1 = x.nextInt();
        int kwh2 = x.nextInt();
        int biaya = x.nextInt();
        int ppj = x.nextInt();
        int pemakaian = kwh2 - kwh1;
        int tarif = pemakaian * biaya;
        int PPJ2 = tarif / 10;
        int total = tarif + PPJ2;

            System.out.println("Nama \t\t\t\t\t: " + nama );
            System.out.println("kelurahan \t\t\t\t: " + kel);
            System.out.println("posisi awal kwh meter \t: " + kwh1);
            System.out.println("posisi akhir kwh meter \t: " + kwh2);
            System.out.println("biaya beban saat ini \t: " + biaya);
            System.out.println("PPJ (dalam persen) \t\t: " + ppj);
            System.out.println("==========PLN Java========== ");
            System.out.println("Nama \t\t\t\t\t: " + nama );
            System.out.println("kelurahan \t\t\t\t: " + kel);
            System.out.println("Pemakaian bulan ini \t: " + pemakaian + " Kwh Meter");
            System.out.println("Tarif Listrik \t\t\t: Rp " + tarif +",-" );
            System.out.println("PPJ 10% \t\t\t\t: Rp " + PPJ2+",-" );
            System.out.println("Total bayar \t\t\t: Rp " + total+",-" );


    }
}
