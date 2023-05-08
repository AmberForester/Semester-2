package PemrogramanBerorientasiObjek.PraktikumPBO;

class Buku{
    private String judul;
    private String penulis;
    private int jumlah;

    public Buku(String judul, String penulis, int jumlah) {
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenulis() {
        return penulis;
    }

    void tampilkanInfoBuku(){
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Jumlah: " + getJumlah());
    }
}

class Pelanggan{
    private String nama;
    private String nomorPelanggan;
    private Buku[] bukuPinjaman = new Buku[3];
    
    public Pelanggan(String nama, String nomorPelanggan) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }
    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }
    public Buku[] getBukuPinjaman() {
        return bukuPinjaman;
    }
    public void setBukuPinjaman(Buku[] bukuPinjaman) {
        this.bukuPinjaman = bukuPinjaman;
    }

    void tambahBuku(Buku bukupinjam){
        int i = 0;
        if(i < 3){
            bukuPinjaman[i] = bukupinjam;
        }
        i++;
    }

    void tampilkanInfoPelanggan(){
        System.out.println("Nama: " + getNama());
        System.out.println("Nomor pelanggan: " + getNomorPelanggan());
        for (int i = 0; i < bukuPinjaman.length; i++) {
            System.out.println(bukuPinjaman[i]);
        }
    }
}

class Pegawai{
    private String nama;
    private String nomorPegawai;
    // Perpustakaan perpus = new Perpustakaan();

    public Pegawai(String nama, String nomorPegawai) {
        this.nama = nama;
        this.nomorPegawai = nomorPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }
    
    void tampilkanInfoPegawai(){
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Pegawai: " + nomorPegawai);
    }
    
    void tambahPelanggan(String nama, String nomorPelanggan){
        Pelanggan plg = new Pelanggan(nama, nomorPelanggan);
        for (int i = 0; i < Perpustakaan.listPelanggan.length; i++) {
            Perpustakaan.listPelanggan[i] = plg;
        }
    }

    void tambahBuku(String judul, String penulis, int jumlah){
        // for (int i = 0; i < Perpustakaan.listBuku.length; i++) {
        //     Perpustakaan.listBuku[i] = bk;
        // }
        int jumlahBuku = Perpustakaan.jumlahBuku;  
        Perpustakaan.listBuku[jumlahBuku] = new Buku(judul, penulis, jumlah);
        Perpustakaan.jumlahBuku++;
    }
}

class Perpustakaan{
    Pegawai pegawaiPerpus;
    static Buku[] listBuku = new Buku[100];
    static int jumlahBuku = 0;
    static Pelanggan[] listPelanggan = new Pelanggan[20];

    public Perpustakaan(){}

    public Perpustakaan(Pegawai pegawaiPerpus) {
        this.pegawaiPerpus = pegawaiPerpus;
    }

    void pinjam(String namaPelanggan, String judulBuku){
        if(cariBuku(judulBuku) != null){
            for (Pelanggan pelanggan : listPelanggan) {
                if(pelanggan.getNama().equals(namaPelanggan)){
                    pelanggan.tambahBuku(cariBuku(judulBuku));
                }
            }
        }
        else{
            System.out.println("Buku Tidak Tersedia");
        }
    }

    Buku cariBuku(String judul){
        for (Buku buku : listBuku) {
            if(buku.getJudul().equals(judul)){
                return buku;
            }
        }
        return null;
    }

    void tampilkanInfoPerpustakaan(){
        System.out.println("Pegawai: " + pegawaiPerpus.getNama());
        for (int i = 0; i < listPelanggan.length; i++) {
            System.out.println(listPelanggan[i].getNama());
            System.out.println(listPelanggan[i].getNomorPelanggan());
            System.out.println("List Buku Dipinjam:");
            for (int j = 0; j < 3; j++) {    
                System.out.println(listPelanggan[i].getBukuPinjaman());
            }
        }
        for (int i = 0; i < listBuku.length; i++) {
            System.out.println(listBuku[i].getJudul());
            System.out.println(listBuku[i].getPenulis());
            System.out.println(listBuku[i].getJumlah());
        }
    }
}

public class UtpPbo2023 {
    public static void main(String[] args) {
        Pegawai pegawaiPerpus = new Pegawai("Hironemus Apriliano", "225150201111018");
        Perpustakaan perpus = new Perpustakaan(pegawaiPerpus);
        pegawaiPerpus.tambahBuku("Tutorial Java", "Graita", 2);
        pegawaiPerpus.tambahBuku("Tutorial Phyton", "Safir", 2);
        pegawaiPerpus.tambahBuku("Tutorial Javascript", "Bagus", 2);
        pegawaiPerpus.tambahBuku("Tutorial Golang", "Budi", 2);
        pegawaiPerpus.tambahBuku("Tutorial Javascript", "Shinta", 2);
        pegawaiPerpus.tambahPelanggan("Wildan", "1");
        pegawaiPerpus.tambahPelanggan("Machsun", "2");
        pegawaiPerpus.tambahPelanggan("Adin", "3");
        pegawaiPerpus.tambahPelanggan("Machsun", "4");
        perpus.pinjam("Wildan", "Tutorial Java");
        perpus.pinjam("Machsun", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Wildan", "Tutorial Golang");
        perpus.pinjam("Wildan", "Tutorial Javascript");
        perpus.pinjam("Wildan", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Tutorial Golang");
        // perpus.pinjam("Machsun", "Sastra Inggris");
        perpus.pinjam("Adin", "Tutorial Phyton");
        // perpus.pinjam("Cantika", "Cara cepat belajar Phyton");
        perpus.tampilkanInfoPerpustakaan();
    }
}
