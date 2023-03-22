package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class AkunPelanggan{
    public String nama;
    public double saldo;
    private String pin;
    private String nomorPelanggan;  
    public String jenisRekening;
    public int min = 10000000;
    public int max = 99999999;
    public int NomorAcak = (int)Math.floor(Math.random() * (max - min + 1) + min);
    static Scanner sc = new Scanner(System.in);
    

    public AkunPelanggan(String nama, String pin, String jenisRekening, double saldo){
        this.nama = nama;
        this.pin = pin;
        this.jenisRekening = jenisRekening;
        this.saldo = saldo;
        if(jenisRekening.equals("silver")){
            this.nomorPelanggan = "36" + String.valueOf(NomorAcak);
        }
        else if(jenisRekening.equals("gold")){
            this.nomorPelanggan = "56" + String.valueOf(NomorAcak);
        }
        else if(jenisRekening.equals("platinum")){
            this.nomorPelanggan = "74" + String.valueOf(NomorAcak);
        }
    }

    // public AkunPelanggan(String nama, String nomorPelanggan, String pin, String jenisRekening, double saldo){
    //     this.nama = nama;
    //     this.nomorPelanggan = nomorPelanggan;
    //     this.pin = pin;
    //     this.jenisRekening = jenisRekening;
    //     this.saldo = saldo;     
    // }

    public String getNama(){
        return nama;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public void setNama(){
        System.out.printf("%-20s: ", "Silakan masukkan nama Baru");
        this.nama = sc.nextLine();
        
    }

    public void setPin(){
        System.out.printf("%-20s: ", "Silakan masukkan pin baru");
        this.pin = sc.nextLine();
    }

    static void buatAkun(){
        System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");       
        String nama = sc.nextLine();
        System.out.printf("%-20s: ", "Silakan masukkan pin");
        String pin = sc.nextLine();
        System.out.printf("%-20s: ", "Silakan pilih jenis rekening (silver, gold, platinum)");
        String jenisRek = sc.nextLine();
        System.out.printf("%-20s: ", "Setorkan saldo awal (minimal Rp 50,000.00)");
        double saldo = sc.nextDouble(); sc.nextLine();    
        AkunPelanggan akun = new AkunPelanggan(nama, pin, jenisRek, saldo);
        TinySwalayan.daftarAkun.add(akun);

        for(int i = 0; i < TinySwalayan.daftarAkun.size(); i++){
            System.out.println(TinySwalayan.daftarAkun.get(i).nama);
        }

        System.out.println("Akun berhasil ditambahkan!");
        System.out.println("Apakah ingin melanjutkan ke menu login untuk mengecek akun?");
        System.out.println("1. Ya \n2. tidak");
        System.out.print("Pilihan Anda: ");
        int pilihan = sc.nextInt(); sc.nextLine();
        switch(pilihan){
            case 1:
                TinySwalayan.cekAkun();
            case 2:
                TinySwalayan.start();
        }                      
    }
    
    
}

class Handphone{
    public String merk;
    public String seri;
    public double harga;
    DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Handphone> daftarHp = new ArrayList<Handphone>();

    public Handphone(String merk, String seri, double harga){
        this.merk = merk;
        this.seri = seri;
        this.harga = harga;
    }
}

public class TinySwalayan {
    static ArrayList <AkunPelanggan> daftarAkun = new ArrayList<AkunPelanggan>();
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

    // static void buatAkun(){
    //     System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");       
    //     String nama = sc.nextLine();
    //     System.out.printf("%-20s: ", "Silakan masukkan pin");
    //     String pin = sc.nextLine();
    //     System.out.printf("%-20s: ", "Silakan pilih jenis rekening (silver, gold, platinum)");
    //     String jenisRek = sc.nextLine();
    //     System.out.printf("%-20s: ", "Setorkan saldo awal (minimal Rp 50,000.00)");
    //     double saldo = sc.nextDouble(); sc.nextLine();    
    //     AkunPelanggan akun = new AkunPelanggan(nama, pin, jenisRek, saldo);
    //     daftarAkun.add(akun);
    //     System.out.println("Akun berhasil ditambahkan!");
    //     System.out.println("Apakah ingin melanjutkan ke menu login untuk mengecek akun?");
    //     System.out.println("1. Ya \n2. tidak");
    //     System.out.print("Pilihan Anda: ");
    //     int pilihan = sc.nextInt(); sc.nextLine();
    //     switch(pilihan){
    //         case 1:
    //             cekAkun();
    //         case 2:
    //             start();
    //     }                      
    // }

    static void cekAkun(){
        System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");
        String cekNama = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.nama.contains(cekNama)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    if(element.getPin().contains(cekPin)){
                        System.out.println("================================");
                        System.out.printf("%-15s: %s\n", "Nama Pengguna", element.getNama());
                        System.out.printf("%-15s: %s\n", "Nomor Pelanggan", element.getNomorPelanggan());
                        System.out.printf("%-15s: %s\n", "Jenis Rekening", element.jenisRekening);
                        System.out.printf("%-15s: %s\n", "Saldo", rupiah.format(element.getSaldo()));
                        break;
                    }
                    else if(i == 2){
                        System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                        break;
                    }
                    else{
                        System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                    }
                }
                break;
            }
            else{
                System.out.printf("%-15s\n", "Nama pengguna tidak ditemukan, silakan coba lagi!");
                cekAkun();   
            }
        }      
    }
    static void isiSaldo(){
        System.out.printf("%-20s: ", "Silakan masukkan nomor pelanggan");
        String cekNomor = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.getNomorPelanggan().contains(cekNomor)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    if(element.getPin().contains(cekPin)){
                        System.out.printf("%-20s: %s\n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.printf("%-20s: ", "Silakan masukkan jumlah uang");
                        double setorSaldo = sc.nextDouble();
                        element.saldo += setorSaldo;
                        System.out.printf("%-20s:%s: \n", "Saldo saat ini", rupiah.format(element.saldo));
                        break;
                    }
                    else if(i == 2){
                        System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");

                    }
                    else{
                        System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                    }
                }
                break;
            }
            else{
                System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
            }
        }
    }
    static void tarikSaldo(){
        System.out.printf("%-20s: ", "Silakan masukkan nomor pelanggan");
        String cekNomor = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.getNomorPelanggan().contains(cekNomor)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    if(element.getPin().contains(cekPin)){
                        System.out.printf("%-20s: %s \n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.printf("%-20s: ", "Silakan masukkan jumlah uang");
                        double tarikSaldo = sc.nextDouble();
                        element.saldo -= tarikSaldo;
                        System.out.printf("%-20s: %s\n", "Saldo saat ini", rupiah.format(element.saldo));
                        break;
                    }
                    else if(i == 2){
                        System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                        TinySwalayan.daftarAkun.remove(element);
                    }
                    else{
                        System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                    }
                }
                break;
            }
            else{
                System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
            }
        }
    }
    static void start(){
        System.out.printf("%-15s\n", "SELAMAT DATANG DI TINY SWALAYAN");
        System.out.printf("%-15s\n", "Silakan pilih menu");
        System.out.printf("%s\n%s\n", "1. Login Akun", "2. Sign Up Akun (membuat akun baru)");
        System.out.printf("%s: ", "Pilihan anda"); 
        int pilihan = sc.nextInt(); sc.nextLine();
        System.out.println("=================================");
        switch(pilihan){
            case 1:
                cekAkun();
                System.out.println("==================================");
                System.out.printf("%-15s\n", "Silakan pilih menu");
                System.out.printf("%s\n%s\n%s\n%s\n", "1. Ubah Data Akun", "2. Transaksi", "3. Kembali", "4. exit");
                System.out.printf("%s: ", "Pilihan anda");
                int pilihan2 = sc.nextInt(); sc.nextLine();
                System.out.println("==================================");
                                
                switch(pilihan2){
                    case 1:
                        menuEditAkun();
                        start();
                        break;
                    case 2:
                        menuTransaksi(); 
                        // start();                    
                        break;                   
                }
                break;
            case 2:
                AkunPelanggan.buatAkun();
                break;
            case 3:
                start();
                break;
            case 4:
                System.exit(0);
                break;           
        }
    }
    static void menuTransaksi(){
        System.out.printf("%s\n%s\n%s\n", "1. Setor Saldo", "2. Tarik Saldo", "3. Pembelian");
        System.out.printf("%s", "Pilihan anda: ");
        
        int pilihan = sc.nextInt(); sc.nextLine();
        System.out.println("==============================");
        switch(pilihan){
            case 1:
                isiSaldo();
                break;
            case 2:
                tarikSaldo();
                break;
            case 3:
                pembelian();
                break;
        }
    }
    static void menuEditAkun(){
        System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");
        String cekNama = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.getNama().contains(cekNama)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    System.out.println("===========================");
                    if(element.getPin().contains(cekPin)){
                        System.out.printf("%-15s\n", "Silakan pilih menu");
                        System.out.printf("%s\n%s\n", "1. Ganti Nama", "2. Ganti PIN");
                        System.out.printf("%s: ", "Pilihan anda");
                        int pilihan = sc.nextInt();
                        System.out.println("===========================");                       
                        switch(pilihan){
                            case 1:                                           
                            element.setNama();
                            System.out.println("=============================");
                            System.out.println("Nama berhasil diubah");                            
                            System.out.printf("%-15s: %s\n", "Nama Pengguna Baru", element.getNama());
                            break;
                            case 2:
                            element.setPin();
                            break;
                        }
                        break;               
                    }                                       
                    else if(i == 2){
                        System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                    }
                    else{
                        System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                    }
                }
                break;
            }           
            else{
                System.out.printf("%-15s", "Nama pengguna tidak ditemukan, silakan coba lagi!");
            }   
        }
    }
    static void pembelian(){
                Handphone handphoneSiomay = new Handphone("Siomay", "BlueMi", 4000000.0);
                Handphone handphoneIpul = new Handphone("Ipul", "Pro MAX", 25000000.0);
                Handphone handphoneFakeMe = new Handphone("FakeMe", "Saske", 1500000.0);
                Handphone.daftarHp.add(handphoneSiomay);
                Handphone.daftarHp.add(handphoneIpul);
                Handphone.daftarHp.add(handphoneFakeMe);
                System.out.printf("%s\n","Silakan Pilih Produk");
                System.out.printf("%s %s %-12s: %s\n","1.", handphoneSiomay.merk, handphoneSiomay.seri, rupiah.format(handphoneSiomay.harga) );
                System.out.printf("%s %s %-14s: %s\n","2.", handphoneIpul.merk, handphoneIpul.seri, rupiah.format(handphoneIpul.harga));
                System.out.printf("%s %s %-12s: %s\n","3.", handphoneFakeMe.merk, handphoneFakeMe.seri, rupiah.format(handphoneFakeMe.harga));
                System.out.printf("%s: ", "Pilihan anda"); 
                int pilihan = sc.nextInt(); sc.nextLine();
                System.out.println("=====================================");
                System.out.printf("%-20s: ", "Silakan masukkan nomor pelanggan");
                String cekNomor = sc.nextLine();
                for (AkunPelanggan element : daftarAkun){
                    if(element.getNomorPelanggan().contains(cekNomor)){
                        for(int i = 0; i < 3; i++){
                            System.out.printf("%-20s: ", "Silakan masukkan pin");
                            String cekPin = sc.nextLine();
                            if(element.getPin().contains(cekPin)){
                                switch(pilihan){
                                    case 1:
                                        if(element.getSaldo() > handphoneSiomay.harga + 10000){
                                            System.out.println("Pembayaran Berhasil!");
                                            System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneSiomay.harga));
                                            // break;
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                            // break;
                                        }
                                        break;
                                    case 2:
                                        if(element.getSaldo() > handphoneIpul.harga + 10000){
                                            System.out.println("Pembayaran Berhasil!");
                                            System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneIpul.harga));
                                            // break;
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                            // break;
                                        }
                                        break;
                                        
                                    case 3:
                                        if(element.getSaldo() > handphoneFakeMe.harga + 10000){
                                            System.out.println("Pembayaran Berhasil!");
                                            System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneFakeMe.harga));
                                            // break;
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                            // break;
                                        }
                                        break;
                                
                                }
                                break;
                            }
                            
                            else if(i == 2){
                                System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                                daftarAkun.remove(element);
                            }
                            else{
                                System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                            }
                        }                           
                    }
                    else{
                            System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
                    }
                }
            }

    public static void main(String[] args) {
        AkunPelanggan pelanggan1 = new AkunPelanggan("hironemus", "1234", "platinum", 10000000);
        daftarAkun.add(pelanggan1);
        AkunPelanggan pelanggan2 = new AkunPelanggan("hironemus", "1234", "platinum", 10000000);
        daftarAkun.add(pelanggan2);
        // for(int i = 0; i < daftarAkun.size(); i++){
        //     System.out.println(daftarAkun.get(i).nama);
        // }
        // AkunPelanggan.buatAkun();
        start();
        // buatAkun();       
    }
}
