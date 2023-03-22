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
    static Scanner in = new Scanner(System.in);
    
    public AkunPelanggan(String nama, String pin, String jenisRekening, double saldo){
        this.nama = nama;
        this.pin = pin;
        this.jenisRekening = jenisRekening;
        this.saldo = saldo;
        if(jenisRekening.equals("silver")){
            this.nomorPelanggan = "38" + String.valueOf(NomorAcak);
        }
        else if(jenisRekening.equals("gold")){
            this.nomorPelanggan = "56" + String.valueOf(NomorAcak);
        }
        else if(jenisRekening.equals("platinum")){
            this.nomorPelanggan = "74" + String.valueOf(NomorAcak);
        }
    }
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
        this.nama = in.nextLine();      
    }
    public void setPin(){
        System.out.printf("%-20s: ", "Silakan masukkan pin baru");
        this.pin = in.nextLine();
    } 
}

class Handphone{
    public String merk;
    public String seri;
    public double harga;
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
        System.out.println("Akun berhasil ditambahkan!");
        System.out.println("Apakah ingin kembali ke menu start untuk mengecek akun?");
        System.out.println("1. Ya \n2. tidak");
        System.out.print("Pilihan Anda: ");
        int pilihan = sc.nextInt(); sc.nextLine();
        switch(pilihan){
            case 1:
                start();;
            case 2:
                System.exit(0);
            case 3:
                start();
        }                      
    } 
    static void cekAkun(){
        System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");
        String cekNama = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.nama.equals(cekNama)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    if(element.getPin().equals(cekPin)){
                        System.out.println("================================");
                        System.out.printf("%-15s: %s\n", "Nama Pengguna", element.nama);
                        System.out.printf("%-15s: %s\n", "Nomor Pelanggan", element.getNomorPelanggan());
                        System.out.printf("%-15s: %s\n", "Jenis Rekening", element.jenisRekening);
                        System.out.printf("%-15s: %s\n", "Saldo", rupiah.format(element.getSaldo()));
                        System.out.println("==================================");
                        break;
                    }
                    else if(i == 2){
                        System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                        System.out.println("==================================");
                        daftarAkun.remove(element);
                        
                        start();
                        break;
                    }
                    else{
                        System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                    }
                }
                break;
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
                        System.out.println("========================");
                        System.out.printf("%-20s: %s\n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.printf("%-20s: ", "Silakan masukkan jumlah uang");
                        double setorSaldo = sc.nextDouble();
                        element.saldo += setorSaldo;
                        System.out.printf("%-20s: %s \n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.println("============================");
                        start();
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
            if(element.getNomorPelanggan().equals(cekNomor)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    if(element.getPin().equals(cekPin)){
                        System.out.printf("%-20s: %s \n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.printf("%-20s: ", "Silakan masukkan jumlah uang");
                        double tarikSaldo = sc.nextDouble();
                        element.saldo -= tarikSaldo;
                        System.out.printf("%-20s: %s\n", "Saldo saat ini", rupiah.format(element.saldo));
                        System.out.println("===========================");
                        start();
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
                System.out.printf("%-15s\n", "Silakan pilih menu");
                System.out.printf("%s\n%s\n%s\n%s\n", "1. Ubah Data Akun", "2. Transaksi", "3. Kembali", "4. exit");
                System.out.printf("%s: ", "Pilihan anda");
                int pilihan2 = sc.nextInt(); sc.nextLine();
                System.out.println("==================================");
                                
                switch(pilihan2){
                    case 1:
                        menuEditAkun();
                        break;
                    case 2:
                        menuTransaksi();                     
                        break;                   
                }
                break;
            case 2:
                buatAkun();
                break;           
        }
    }
    static void menuTransaksi(){
        System.out.printf("%s\n%s\n%s\n", "1. Setor Saldo", "2. Tarik Saldo", "3. Pembelian", "4. Kembali e menu awal");
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
            case 4:
                start();
                break;
        }
    }
    static void menuEditAkun(){
        System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");
        String cekNama = sc.nextLine();
        for (AkunPelanggan element : TinySwalayan.daftarAkun){
            if(element.getNama().equals(cekNama)){
                for(int i = 0; i < 3; i++){
                    System.out.printf("%-20s: ", "Silakan masukkan pin");
                    String cekPin = sc.nextLine();
                    System.out.println("===========================");
                    if(element.getPin().equals(cekPin)){
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
                            System.out.println("Apakah anda ingin kembali ke menu start untuk cek perubahan nama?(1. Ya, 2. Tidak)");
                            System.out.print("Pilihan anda: ");
                            int pilihan2 = sc.nextInt(); sc.nextLine();
                            System.out.println("=================================");
                            if(pilihan2 == 1){
                                start();
                            }
                            else{
                                System.exit(0);
                            }
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
                Handphone handphoneYeskia = new Handphone("Yeskia", "Brick", 700000);
                Handphone.daftarHp.add(handphoneSiomay);
                Handphone.daftarHp.add(handphoneIpul);
                Handphone.daftarHp.add(handphoneFakeMe);
                Handphone.daftarHp.add(handphoneYeskia);
                System.out.printf("%s\n","Silakan Pilih Produk");
                System.out.printf("%s %s %-12s: %s\n","1.", handphoneSiomay.merk, handphoneSiomay.seri, rupiah.format(handphoneSiomay.harga) );
                System.out.printf("%s %s %-14s: %s\n","2.", handphoneIpul.merk, handphoneIpul.seri, rupiah.format(handphoneIpul.harga));
                System.out.printf("%s %s %-12s: %s\n","3.", handphoneFakeMe.merk, handphoneFakeMe.seri, rupiah.format(handphoneFakeMe.harga));
                System.out.printf("%s %s %-12s: %s\n","4.", handphoneYeskia.merk, handphoneYeskia.seri, rupiah.format(handphoneYeskia.harga));
                System.out.printf("%s: ", "Pilihan anda"); 
                int pilihan = sc.nextInt(); sc.nextLine();
                System.out.println("=====================================");
                System.out.printf("%-20s: ", "Silakan masukkan nomor pelanggan");
                String cekNomor = sc.nextLine();
                for (AkunPelanggan element : daftarAkun){
                    if(element.getNomorPelanggan().equals(cekNomor)){
                        for(int i = 0; i < 3; i++){
                            System.out.printf("%-20s: ", "Silakan masukkan pin");
                            String cekPin = sc.nextLine();
                            if(element.getPin().equals(cekPin)){
                                switch(pilihan){
                                    case 1:
                                        if(element.getSaldo() > handphoneSiomay.harga + 10000){
                                            System.out.println("cek if");
                                            if(element.getNomorPelanggan().contains("38")){
                                                handphoneSiomay.harga = handphoneSiomay.harga - (handphoneSiomay.harga*0.05);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneSiomay.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("56")){
                                                handphoneSiomay.harga = handphoneSiomay.harga - (handphoneSiomay.harga*0.07);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneSiomay.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("74")){
                                                handphoneSiomay.harga = handphoneSiomay.harga - (handphoneSiomay.harga*0.1);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " +  rupiah.format(element.getSaldo() - handphoneSiomay.harga));
                                            }                                           
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");                                         
                                        }
                                        break;
                                    case 2:
                                        if(element.getSaldo() > handphoneIpul.harga + 10000){
                                            if(element.getNomorPelanggan().contains("38")){
                                                handphoneIpul.harga = handphoneIpul.harga - (handphoneIpul.harga*0.05);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneIpul.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("56")){
                                                handphoneIpul.harga = handphoneIpul.harga - (handphoneIpul.harga*0.07);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneIpul.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("74")){
                                                handphoneIpul.harga = handphoneIpul.harga - (handphoneIpul.harga*0.1);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " +  rupiah.format(element.getSaldo() - handphoneIpul.harga));
                                            }                                           
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                        }
                                        break;                                      
                                    case 3:
                                        if(element.getSaldo() > handphoneFakeMe.harga + 10000){
                                            if(element.getNomorPelanggan().contains("38")){
                                                handphoneFakeMe.harga = handphoneFakeMe.harga - (handphoneFakeMe.harga*0.05);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneFakeMe.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("56")){
                                                handphoneFakeMe.harga = handphoneFakeMe.harga - (handphoneFakeMe.harga*0.07);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneFakeMe.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("74")){
                                                handphoneFakeMe.harga = handphoneFakeMe.harga - (handphoneFakeMe.harga*0.1);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " +  rupiah.format(element.getSaldo() - handphoneFakeMe.harga));
                                            }                                                                                   ;
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                        }
                                        break;
                                    case 4:
                                        if(element.getSaldo() > handphoneYeskia.harga + 10000){
                                            if(element.getNomorPelanggan().contains("56")){
                                                handphoneYeskia.harga = handphoneYeskia.harga - (handphoneYeskia.harga*0.02);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " + rupiah.format(element.getSaldo() - handphoneYeskia.harga));
                                            }
                                            else if(element.getNomorPelanggan().contains("74")){
                                                handphoneYeskia.harga = handphoneYeskia.harga - (handphoneYeskia.harga*0.05);
                                                System.out.println("Pembayaran Berhasil!");
                                                System.out.println("Saldo Anda saat ini: " +  rupiah.format(element.getSaldo() - handphoneYeskia.harga));
                                            }                                                                                   
                                        }
                                        else{
                                            System.out.println("Maaf, saldo anda tidak cukup");
                                        }
                                        break;
                                }
                            
                            }                                                     
                            else if(i == 2){
                                System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
                                daftarAkun.remove(element);
                            }
                            else{
                                System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
                            }
                            break;
                        } 
                        break;                          
                    }
                }
            }

    public static void main(String[] args) {
        AkunPelanggan pelanggan1 = new AkunPelanggan("hironemus", "1234", "platinum", 10000000);
        AkunPelanggan pelanggan2 = new AkunPelanggan("doni", "1111", "silver", 2000000);
        AkunPelanggan pelanggan3 = new AkunPelanggan("putri", "3456", "gold", 5000000);
        daftarAkun.add(pelanggan1);
        daftarAkun.add(pelanggan2);
        daftarAkun.add(pelanggan3);
        start();       
    }
}
