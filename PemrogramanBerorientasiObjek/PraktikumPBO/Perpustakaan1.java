package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.util.Scanner;
public class Perpustakaan1 {
    public String kategori;
    public int jumlahBuku;
    public String[] judulBuku;
    public String[] namaPenulis;
    public String[][] listNamaPenulis;
    public static Scanner sc = new Scanner(System.in);
    
    public void tambahBuku(){
        this.kategori = sc.next();
        this.jumlahBuku = sc.nextInt(); sc.nextLine();
        this.judulBuku = new String[this.jumlahBuku];
        this.listNamaPenulis = new String[this.jumlahBuku][];
        this.namaPenulis = new String[this.jumlahBuku];

            for(int i = 0; i < this.jumlahBuku; i++){
            this.judulBuku[i] = sc.nextLine();
            this.namaPenulis[i] = sc.nextLine();

            this.listNamaPenulis[i] = this.namaPenulis[i].split("[,]+");
        }
    }   
    public void cetakDaftarBuku(){
        System.out.println("Kategori Buku: " + this.kategori);
        for(int j = 0; j < this.judulBuku.length; j++){
            System.out.println("Judul Buku: " + this.judulBuku[j]);
            System.out.println("Penulis: ");
            for(int k = 0; k < this.listNamaPenulis[j].length; k++){
                    System.out.println(k+1 + ". " + this.listNamaPenulis[j][k]);
            }
        }
    }
}
class RunPerpustakaan{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahKategori = input.nextInt();
        Perpustakaan1 daftarPengisi[] = new Perpustakaan1[jumlahKategori];
        for(int i = 0; i < jumlahKategori; i++){
            Perpustakaan1 pengisi = new Perpustakaan1();
            pengisi.tambahBuku();
            daftarPengisi[i] = pengisi;
            }
        for(int j = 0; j < jumlahKategori; j++){ 
            daftarPengisi[j].cetakDaftarBuku();
        }
    }
}


