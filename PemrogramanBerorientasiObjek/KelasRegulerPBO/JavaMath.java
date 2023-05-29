package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class JavaMath {
    static void soal1(double x, double y){
        double hasil = 0;
        for (int i = 0; i < 10; i++) {
            hasil = Math.log(i);
        }
        System.out.printf("%.4f\n", hasil + Math.sin(y) + Math.cos(x));
    }

    static void soal2(double x, double y){
        x = Math.pow(x, 5);
        y  = Math.pow(y, 3);

        double hasil = Math.sqrt(x*(1/y));
        System.out.printf("%.4f\n", hasil);
    }

    public static void main(String[] args) {
        System.out.print("Hasil soal 1: ");
        soal1(16, 2);
        System.out.print("Hasil soal 2: ");
        soal2(2, 3);
    }
}
