package PemrogramanBeorientasiObyek.Praktikum;
import java.util.*;

public class KartuRencanaStudi{
    public Scanner sc = new Scanner(System.in);
    public int jumlahMataKuliah = sc.nextInt();   
    public String[] daftarMatKul = new String[jumlahMataKuliah];

    public void tambahMataKuliah(){
        sc.nextLine();    
        for(int i = 0; i < this.jumlahMataKuliah; i++){
            this.daftarMatKul[i] = sc.nextLine();            
        }
    }
    public void print(){
            if(this.jumlahMataKuliah > 5){
            System.out.println("KRS Telah Penuh");
            System.out.println("Daftar Mata Kuliah: ");
            for(int j = 0; j < 5;j++){
                System.out.println(this.daftarMatKul[j]);
            }
        }
        else{
            System.out.println("Daftar Mata Kuliah: ");
            for(int j = 0; j < this.jumlahMataKuliah;j++){
                System.out.println(this.daftarMatKul[j]);
            }
        }        
    }
    class Main{
        public static void main(String[] args) {
            KartuRencanaStudi krs1 = new KartuRencanaStudi();
            krs1.tambahMataKuliah();
            krs1.print();
            KartuRencanaStudi krs2 = new KartuRencanaStudi();
            krs2.tambahMataKuliah();
            krs2.print();
            
        }    
    }
}
