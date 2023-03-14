package PemrogramanDasar.PraktikumPemDas;

public class Method {
    public static void main(String[] args){
        //System.out.println(sayHello("Elle"));
        //System.out.println(fungsi(2));
        //grafik(10);
    }
    public static String sayHello(String nama){
        return "Hello " + nama;
    }
    // hitung f(x) = x^2 + 5x + 20
    public static int fungsi(int x){
        int a = x * x;
        int b = 5 * x;
        int c = 20;
        int hasil = a + b + c;
        return hasil;
    }
    public static void grafik(int banyakInterval){
        for(int i = 0; i < banyakInterval; i++){
            System.out.println(i + " = " + fungsi(i));
        }
        return;
    }
//    public static int faktorialLoop(int bil){
//        for(int i = bil; i >= 1;i--){
//
}



