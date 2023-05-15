package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.text.DecimalFormat;

interface Payable {
    public int getPayableAmount();
}

class Invoice implements Payable{
    String productName;
    int quantity;
    int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public int getPayableAmount(){
        return quantity*pricePerItem;
    }
}

class Employee implements Payable{
    String registrationNumber;
    String name;
    int salaryPerMonth;
    Invoice[] invoices = new Invoice[20];
    int totalInvoice;
    int i = 0;
    DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

    public Employee(String registrationNumber, String name, int salaryPerMonth) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
    }

    void buyItem(String nama, int jumlah, int harga){
        Invoice inv = new Invoice(nama, jumlah, harga);
        invoices[i] = inv;
        i++;
        totalInvoice += inv.getPayableAmount();
    }

    public int getPayableAmount(){
        return salaryPerMonth - totalInvoice;
    }

    void slipGaji(){
        System.out.println("==========================================================");
        System.out.printf("%35s\n", "DATA KARYAWAN");
        System.out.println("==========================================================");
        System.out.printf("%-25s: %s\n","Nama", this.name);
        System.out.printf("%-25s: %s\n","Nomor Registrasi", this.registrationNumber);
        System.out.printf("%-25s: %s\n", "Gaji", rupiah.format(this.salaryPerMonth));
        System.out.println();
        System.out.println("==========================================================");
        System.out.printf("%-20s", "Nama Barang");
        System.out.printf("%-20s", "Jumlah");
        System.out.printf("%-20s\n", "Harga Per Barang");
        System.out.println("==========================================================");
        for (int i = 0; i < invoices.length; i++) {
            if(invoices[i] != null){
                System.out.printf("%-23s", invoices[i].productName);
                System.out.printf("%-20s", invoices[i].quantity);
                System.out.printf("%s", rupiah.format(invoices[i].pricePerItem));
                System.out.println();
            }                 
        }
        System.out.println("==========================================================");
        System.out.printf("%-30s: %s\n", "Banyaknya Invoice", rupiah.format(totalInvoice));
        System.out.printf("%-30s: %s", "Total Gaji Bersih", rupiah.format(this.getPayableAmount()));
    }
}

public class Meneer {
    public static void main(String[] args) {
        Employee emp = new Employee("225150201111018", "Hironemus Apriliano Diesa Putra", 20000000);
        emp.buyItem("nasi goreng", 10, 10000);
        emp.buyItem("susu", 15, 5000);
        emp.buyItem("Maklor", 20, 5000);
        emp.buyItem("Kasur", 1, 2000000);
        emp.getPayableAmount();
        emp.slipGaji();
    }
}
