
import java.util.Scanner;
public class BelajarLoop {
//    public static void main(String[]args){
//        Scanner x = new Scanner(System.in);
//        int l = x.nextInt(); // panjang ular ke kanan (panjang)
//        int t = x.nextInt(); // jumlah lengkungan (lebar)
//        char kini = 'a';
//        for(int i=0;i<t;i++){
//            String tubuh = "";
//            for(int j=0;j<l;j++) {
//                if (kini > 'z') kini = 'a';
//                if (i % 2 == 0)
//                    tubuh = tubuh + kini;
//                 else
//                    tubuh = kini + tubuh;
//                    kini++;
//
//            }
//            System.out.println(tubuh);
//        }
//    }
    public static void main(String[]args){

        int hasil = 0;
        for(int i=0;i<10;i++){
            hasil += i;
            System.out.println(hasil);
        }

    }
}

