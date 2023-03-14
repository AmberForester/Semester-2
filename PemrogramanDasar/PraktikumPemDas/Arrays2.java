package PemrogramanDasar.PraktikumPemDas;
import java.util.*;
public class Arrays2 {
    public static void main(String[] args) {
//        int[] angka = new int[10];
//        angka[0] = 5;
//        angka[2] = 20;
//        System.out.println(Arrays.toString(angka));
//        for(int i = 0; i < angka.length; i++){
//            System.out.printf("index ke-%d, value = %d\n", i, angka[i]);
//    }

//    int[] angka = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for(int i = 0; i<angka.length;i++) {
//        System.out.printf("index ke-%d, value = %d\n", i, angka[i]);
//        }

        Scanner x = new Scanner(System.in);
        int panjang = x.nextInt(); x.nextLine();
        String[] text = new String[panjang];
        for(int i = 0; i<text.length;i++) {
            System.out.printf("isi array index ke-%d : ", i);
            text[i] = x.nextLine();
        }
        System.out.println("isi array nama : ");
        for(int i = 0; i < text.length; i++){
            System.out.print(text[i]);
            if(i == text.length-1) continue;
            System.out.print(", ");

        }
    }
}
