package PemrogramanDasar.PraktikumPemDas;
import java.util.Scanner;
public class UlarHuruf {
//    public static void main(String[] args) {
//        Scanner x = new Scanner(System.in);
//        int range = x.nextInt();
//
//        for(int i=0;i<=range;i++){
//            String wadah = "";
//            if (i%2!=0)
//                if(i == range-1)
//                    wadah = i + " ";
//                else if(i < range)
//                    wadah = i + ", ";
//
//                else if (i == range)
//                    wadah = i + " ";
//
//            System.out.print(wadah);
//        }
//    }
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int jumlah = x.nextInt();
        for (int i=0; i < jumlah; i++){
            String badan = "";
            for(int j=jumlah-1; j > i; j--){
                badan = " " + badan;
            }
            for(int k=0; k <= i; k++){
            badan = badan + "*";

            }
            System.out.println(badan);
        }
    }
}
