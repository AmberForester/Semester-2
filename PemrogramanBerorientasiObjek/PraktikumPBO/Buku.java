package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.text.DecimalFormat;
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
    public double persenRoyalti;
    public DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

    public Buku(){}

    public Buku(String kategori, String judulBuku, String namaPenulis, String sinopsis, int harga, int terjualPerBulan, double persenRoyalti){
        this.kategori = kategori;
        this.judulBuku = judulBuku;
        this.namaPenulis = namaPenulis;
        this.sinopsis = sinopsis;
        this.harga = harga;
        this.terjualPerBulan = terjualPerBulan;
        this.persenRoyalti = persenRoyalti;
    }

    public void hitungKata(){
        String[] kataKata = this.sinopsis.split("[ .!?]+");
        System.out.printf("%-15s: %d \n", "Jumlah Kata", kataKata.length);
    }

    public String sinopsisKapital(){
        String[] kalimatSalah = this.sinopsis.split("(?<=[.!?])\\s+");
        sinopsis = "";
        for(int i = 0; i < kalimatSalah.length; i++){
            sinopsis = sinopsis + kalimatSalah[i].substring(0,1).toUpperCase() + kalimatSalah[i].substring(1) + " ";           
        }
        return this.sinopsis;
    }
    
    public String hitungRoyalti(double penjualan){
        double royalti = penjualan * 0.1;
        return rupiah.format(royalti);
    }

    public String hitungRoyalti(double penjualan, double persenRoyalti){
        double royalti = penjualan * persenRoyalti / 100;
        return rupiah.format(royalti);
    }

    public void cetakDaftarBuku2(){
        this.listNamaPenulis = this.namaPenulis.split("[,]+");
        System.out.printf("%-15s: %s \n", "Kategori Buku", this.kategori);
        System.out.printf("%-15s: %s \n", "Judul", this.judulBuku);
        System.out.printf("%-15s: ", "Penulis");
        for(int i = 0; i < this.listNamaPenulis.length; i++){           
            // System.out.println(i+1 + ". " + this.listNamaPenulis[i]);
            if(i == this.listNamaPenulis.length-1){
                System.out.println(this.listNamaPenulis[i]);
            }
            else{               
                System.out.print(this.listNamaPenulis[i] + ", ");
            }           
        }
        System.out.printf("%-15s: %s \n", "Sinopsis", this.sinopsis);
        System.out.printf("%-15s: %s \n", "Royalti 10%", this.hitungRoyalti(harga*terjualPerBulan));
        System.out.printf("%s %.0f%-5s: %s \n", "Royalti", this.persenRoyalti, "%", this.hitungRoyalti(harga*terjualPerBulan, this.persenRoyalti));
    }
}

class RunBuku{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);      
        int jumlahBuku = sc.nextInt(); sc.nextLine();                       
        Buku daftarBuku[] = new Buku[jumlahBuku];

        for(int i = 0; i < jumlahBuku; i++){
            String kategori = sc.nextLine();
            String judulBuku = sc.nextLine();
            String namaPenulis = sc.nextLine();
            String sinopsis = sc.nextLine();
            int harga = sc.nextInt(); sc.nextLine();
            int terjualPerBulan = sc.nextInt(); sc.nextLine();
            int persenRoyalti = sc.nextInt(); sc.nextLine();

            Buku inputBuku = new Buku(kategori, judulBuku, namaPenulis, sinopsis, harga, terjualPerBulan, persenRoyalti);
            inputBuku.sinopsisKapital();
            daftarBuku[i] = inputBuku;
        }
        for(int i = 0; i < jumlahBuku; i++){
            daftarBuku[i].cetakDaftarBuku2();
            daftarBuku[i].hitungKata();
            System.out.println();
            
        }
    } 
}
