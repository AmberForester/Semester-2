import java.sql.SQLOutput;
import java.util.Scanner;
public class lingkaran {
    public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
        System.out.print("jari jari : ");

    double r = x.nextDouble();
        if (r <= 0) {
            System.out.println("jari-jari harus lebih dari 0");
        }
        else {
            double d = 2 * r;
            double phi = (double) 22 / 7;
            double Luas = phi * r * r;
            double Kel = phi * d;
            double kel2 = phi * d / 2 + d;
            System.out.println("Luas Lingkaran : " + Luas + " cm^2");
            System.out.println("Keliling Lingkaran : " + Kel + " cm");
            System.out.println("Keliling setengah lingkaran : " + kel2 + " cm");
        }
    }
}
