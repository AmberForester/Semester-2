
import java.util.Scanner;

public class BelajarLoop2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int p = x.nextInt(); // panjang ular keseluruhan
        int q = x.nextInt(); // panjang ular kesamping sebelum ditekuk
        float l = (float)p / (float)q;
        char kini = 'a';
        int sisaSlot = 0;
        boolean kiriKanan = true;

        for (int i = 0; i < l; i++) {
            String tubuh = "";
            for (int j = 0; j < q; j++) {
                if (kini > 'z') kini = 'a';
                if (i % 2 == 0) {
                    if (sisaSlot == p) {
                        tubuh = tubuh + "_";
                    } else {
                        tubuh = tubuh + kini;
                        kini++;
                        sisaSlot++;
                    }
                } else {
                    if (sisaSlot == p) {
                        tubuh = "_" + tubuh;
                    } else {
                        tubuh = kini + tubuh;
                        kini++;
                        sisaSlot++;
                    }

                }

            }System.out.println(tubuh);
        }
    }
//    public static void main(String[]args){
//
//    }
}
