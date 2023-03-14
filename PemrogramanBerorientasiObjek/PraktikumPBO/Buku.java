package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.util.Scanner;

public class Buku {
    public String kategori;
    public int jumlahBuku;
    public String judulBuku;
    public String namaPenulis;
    public String[] listNamaPenulis;
    public String sinopsis;
    public int harga;
    public int terjualPerBulan;
    public static Scanner sc = new Scanner(System.in);

    public Buku(){

    }

    public Buku(String kategori, String judulBuku, String namaPenulis, String sinopsis, int harga, int terjualPerBulan){
        this.kategori = kategori;
        this.judulBuku = judulBuku;
        this.namaPenulis = namaPenulis;
        this.sinopsis = sinopsis;
        this.harga = harga;
        this.terjualPerBulan = terjualPerBulan;
    }

    public void tambahBuku2(){
        this.kategori = sc.nextLine();
        this.judulBuku = sc.nextLine();
        this.namaPenulis = sc.nextLine();
        this.listNamaPenulis = this.namaPenulis.split("[,]+");
        this.sinopsis = sc.nextLine();
        this.harga = sc.nextInt(); sc.nextLine();
        this.terjualPerBulan = sc.nextInt(); sc.nextLine();

    }

    public void hitungKata(){
        String[] kataKata = this.sinopsis.split("[ .!?]+");
        System.out.println("Jumlah Kata: " + kataKata.length);
    }

    public String sinopsisKapital(){
        String[] kalimatSalah = this.sinopsis.split("(?<=[.!?])\\s+");
        sinopsis = "";
        for(int i = 0; i < kalimatSalah.length; i++){
            sinopsis = sinopsis + kalimatSalah[i].substring(0,1).toUpperCase() + kalimatSalah[i].substring(1) + " ";           
        }
        return this.sinopsis;
    }
    
    public double hitungRoyalti(double penjualan){
        return penjualan * 0.1;
    }

    public double hitungRoyalti(double penjualan, double persenRoyalti){
        return penjualan * persenRoyalti;
    }

    public void cetakDaftarBuku2(){
        System.out.println("Kategori Buku: " + this.kategori);
        System.out.println("Judul Buku: " + this.judulBuku);
        System.out.println("Penulis: ");
        for(int i = 0; i < this.listNamaPenulis.length; i++){           
            System.out.println(i+1 + ". " + this.listNamaPenulis[i]);
        }
        System.out.println("Sinopsis: " + this.sinopsis);
        System.out.println("Royalti 10%: " + hitungRoyalti(harga*terjualPerBulan));
        System.out.println("Royalti 20%: " + hitungRoyalti(harga*terjualPerBulan, 0.2));
    }
}

class RunBuku{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        // Buku contoh = new Buku("teknologi", "Pemrograman Java", "hiro,nemus", "baiklah ini. adalah. sebuah contoh. sinopsis buku.", 2500, 1000);
        // contoh.listNamaPenulis = contoh.namaPenulis.split("[,]+");
        // contoh.sinopsisKapital();
        // contoh.cetakDaftarBuku2();
        // contoh.hitungKata();

        int jumlahBuku = input.nextInt(); input.nextLine();
        Buku daftarBuku[] = new Buku[jumlahBuku];
        for(int i = 0; i < jumlahBuku; i++){
            Buku inputBuku = new Buku();
            inputBuku.tambahBuku2();
            inputBuku.sinopsisKapital();
            daftarBuku[i] = inputBuku;
        }
        for(int i = 0; i < jumlahBuku; i++){
            daftarBuku[i].cetakDaftarBuku2();
            daftarBuku[i].hitungKata();
        }
        
        // int jumlahKategori = input.nextInt();
        // Perpustakaan2 daftarPengisi[] = new Perpustakaan2[jumlahKategori];
        // for(int i = 0; i < jumlahKategori; i++){
        //     Perpustakaan2 pengisi = new Perpustakaan2();
        //     pengisi.tambahBuku2();
        //     daftarPengisi[i] = pengisi;
        //     }
        // for(int j = 0; j < jumlahKategori; j++){ 
        //     daftarPengisi[j].cetakDaftarBuku2();
        // }
    } 
}
