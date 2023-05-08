import java.util.Scanner;

public class Kalkulator {
    double data1;
    double data2;

    public Kalkulator(double data1, double data2){
        this.data1 = data1;
        this.data2 = data2;
    }
    
    double tambah(){
        return data1 + data2;
    }

    double kurang(){
        return data1 - data2;
    }

    double kali(){
        return data1 * data2;
    }

    double bagi(){
        return data1 / data2;
    }
}

class jalan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Operand 1: ");
        double data1 = sc.nextDouble(); sc.nextLine();

        System.out.print("Operator: "); 
        String operator = sc.nextLine();

        System.out.print("Operand 2: ");
        double data2 = sc.nextDouble(); sc.nextLine();
        
        Kalkulator diva = new Kalkulator(data1, data2);

        switch(operator){
            case "+":
            System.out.print("Hasil : ");
            System.out.println(diva.tambah());
            break;
            case "-":
            System.out.print("Hasil : ");
            System.out.println(diva.kurang());
            break;
            case "*":
            System.out.print("Hasil : ");
            System.out.println(diva.kali());
            break;
            case "/":
            System.out.print("Hasil : ");
            System.out.println(diva.bagi());
            break;
        }
    }
}



