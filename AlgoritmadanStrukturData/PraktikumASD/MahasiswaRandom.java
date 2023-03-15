import java.util.Scanner;
public class MahasiswaRandom {
    String nama, nim, jurusan, univ;

    public MahasiswaRandom(String nama, String nim, String jurusan, String univ) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.univ = univ;
    }
    public void cetak(){
        System.out.print(this.nama + ", ");
        System.out.print(this.nim + ", ");
        System.out.print(this.jurusan + ", ");
        System.out.print(this.univ);
    }
}
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String m = sc.nextLine();
        String[] splitM = m.split(" ");
                  
        MahasiswaRandom[] mhs = new MahasiswaRandom[n];
        for(int i = 0; i < n; i++){
            mhs[i] = new MahasiswaRandom(sc.next(), sc.next(), sc.next(), sc.next());
        }
        for(String data : splitM){
            int index = Integer.parseInt(data);
            mhs[index-1].cetak();
            System.out.println("");
        }      
    }
}

