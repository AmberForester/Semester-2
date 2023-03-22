// package PemrogramanBerorientasiObjek.PraktikumPBO;
// import java.text.DecimalFormat;
// import java.util.ArrayList;
// import java.util.Random;
// import java.util.Scanner;

// import javax.lang.model.element.Element;
// import javax.management.ValueExp;

// class AkunPelanggan{ 
//     private static String nama;
//     private static double saldo;
//     private static String pin;
//     private static String nomorPelanggan;
//     private static String jenisRekening;
//     static Scanner sc = new Scanner(System.in);
//     public int min = 10000000;
//     public int max = 99999999;
//     public int NomorAcak = (int)Math.floor(Math.random() * (max - min + 1) + min);
//     // int NomorAcak = ;
//     static DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

//     public AkunPelanggan(String nama, String pin, String jenisRekening, double saldo){
//         this.nama = nama;
//         this.pin = pin;
//         this.jenisRekening = jenisRekening;
//         this.saldo = saldo;
//         if(jenisRekening.equals("silver")){
//             this.nomorPelanggan = "36" + String.valueOf(NomorAcak);
//         }
//         else if(jenisRekening.equals("gold")){
//             this.nomorPelanggan = "56" + String.valueOf(NomorAcak);
//         }
//         else if(jenisRekening.equals("platinum")){
//             this.nomorPelanggan = "74" + String.valueOf(NomorAcak);
//         }       
//     }
//     public AkunPelanggan(String nama, String nomorPelanggan, String pin, String jenisRekening,  double saldo){
//         this.nama = nama;
//         this.nomorPelanggan = nomorPelanggan;
//         this.pin = pin;
//         this.jenisRekening = jenisRekening;
//         this.saldo = saldo;     
//     }


  
//     public void setNama(){
//         System.out.printf("%-20s:\n", "Silakan masukkan nama Baru");
//         this.nama = sc.nextLine();
        
//     }

//     public void setNomorPelanggan() {
//         this.nomorPelanggan = nomorPelanggan;
//         this.pin = pin;
//     }

//     public void setPin(){
//         System.out.printf("%-20s:\n", "Silakan masukkan pin baru");
//         this.pin = sc.nextLine();
//     }

//     public static double getSaldo() {
//         return saldo;
//     }

//     public String getNama() {
//         return nama;
//     }

//     public String getNomorPelanggan() {
//         return nomorPelanggan;
//     }

//     public String getPin(){
//         return this.pin;
//     }

//     public static String getJenisRekening(){
//         return jenisRekening;
//     }

//     public static void BuatAkun(){
//         System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");       
//         String nama = sc.nextLine();
//         System.out.printf("%-20s: ", "Silakan masukkan pin");
//         String pin = sc.nextLine();
//         System.out.printf("%-20s: ", "Silakan pilih jenis rekening (silver, gold, platinum)");
//         String jenisRek = sc.nextLine();
//         System.out.printf("%-20s: ", "Setorkan saldo awal (minimal Rp 50,000.00)");
//         double saldo = sc.nextDouble();
        
//         AkunPelanggan akun = new AkunPelanggan(nama, pin, jenisRek, saldo );
//         Swalayan.daftarAkun.add(akun);
//     }

//     public static void cekAkun(){
//         System.out.printf("%-20s: ", "Silakan masukkan nama pengguna");
//         String cekNama = sc.nextLine();
//         for (AkunPelanggan element : Swalayan.daftarAkun){
//             if(element.nama.contains(cekNama)){
//                 for(int i = 0; i < 3; i++){
//                     System.out.printf("%-20s: ", "Silakan masukkan pin");
//                     String cekPin = sc.nextLine();
//                     if(element.pin.contains(cekPin)){
//                         System.out.println();
//                         System.out.printf("%-15s: %s\n", "Nama Pengguna", nama);
//                         System.out.printf("%-15s: %s\n", "Nomor Pelanggan", nomorPelanggan);
//                         System.out.printf("%-15s: %s\n", "Saldo", rupiah.format(saldo));
//                         break;
//                     }
//                     else if(i == 2){
//                         System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
//                     }
//                     else{
//                         System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
//                     }
//                 }
//                 break;
//             }
//             else{
//                 System.out.printf("%-15s\n", "Nama pengguna tidak ditemukan, silakan coba lagi!");   
//             }
//         }      
//     } 
//     public static void isiSaldo(){
//         System.out.printf("%-20s\n:", "Silakan masukkan nomor pelanggan");
//         String cekNomor = sc.nextLine();
//         for (AkunPelanggan element : Swalayan.daftarAkun){
//             if(element.nomorPelanggan.contains(cekNomor)){
//                 for(int i = 0; i < 3; i++){
//                     System.out.printf("%-20s:\n", "Silakan masukkan pin");
//                     String cekPin = sc.nextLine();
//                     if(element.pin.contains(cekPin)){
//                         System.out.printf("%-20s%f\n:", "Saldo saat ini", saldo);
//                         System.out.printf("%-20s\n:", "Silakan masukkan jumlah uang");
//                         double setorSaldo = sc.nextDouble();
//                         saldo = saldo + setorSaldo;
//                         System.out.printf("%-20s%f\n:", "Saldo saat ini", saldo);
//                     }
//                     else if(i == 2){
//                         System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");

//                     }
//                     else{
//                         System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
//                     }
//                 }
//                 break;
//             }
//             else{
//                 System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
//             }
//         }
//     }
//     public static void tarikSaldo(){
//         System.out.printf("%-20s\n:", "Silakan masukkan nomor pelanggan");
//         String cekNomor = sc.nextLine();
//         for (AkunPelanggan element : Swalayan.daftarAkun){
//             if(element.nomorPelanggan.contains(cekNomor)){
//                 for(int i = 0; i < 3; i++){
//                     System.out.printf("%-20s:\n", "Silakan masukkan pin");
//                     String cekPin = sc.nextLine();
//                     if(element.pin.contains(cekPin)){
//                         System.out.printf("%-20s%f\n:", "Saldo saat ini", saldo);
//                         System.out.printf("%-20s\n:", "Silakan masukkan jumlah uang");
//                         double tarikSaldo = sc.nextDouble();
//                         saldo = saldo - tarikSaldo;
//                         System.out.printf("%-20s%f\n:", "Saldo saat ini", saldo);
//                     }
//                     else if(i == 2){
//                         System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
//                         Swalayan.daftarAkun.remove(element);
//                     }
//                     else{
//                         System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
//                     }
//                 }
//                 break;
//             }
//             else{
//                 System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
//             }
//         }
//     }
// }

// class Handphone{
//     public String merk;
//     public String seri;
//     public double harga;
//     DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");
//     static Scanner sc = new Scanner(System.in);
//     static ArrayList <Handphone> daftarHp = new ArrayList<Handphone>();

//     public Handphone(String merk, String seri, double harga){
//         this.merk = merk;
//         this.seri = seri;
//         this.harga = harga;
//     }

    
    
//     // public static double keuntunganMember(){
//     //     switch(AkunPelanggan.getJenisRekening()){
//     //         case "silver":
//     //             if(harga >= 1000000){
//     //             harga = harga - (harga*0.05);
//     //             }
//     //         break;
            
//     //         case "gold":
//     //             if(harga >= 1000000){
//     //             harga = harga - (harga*0.07);
//     //             }
//     //             else{
//     //             harga = harga - (harga*0.02);
//     //             }
//     //         break;
//     //         case "platinum":
//     //             if(harga >= 1000000){
//     //                 harga = harga - (harga*0.1);
//     //             }
//     //             else{
//     //                 harga = harga - (harga*0.05);
//     //             }
//     //         break; 
//     //     }
//     //     return harga;     
//     // }
// }

// public class Swalayan {

//     static Scanner sc = new Scanner(System.in);
//     static ArrayList <AkunPelanggan> daftarAkun = new ArrayList<AkunPelanggan>();
//     static DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");
//     // static ArrayList <Handphone> daftarHP = new ArrayList<Handphone>();

//     static void start(){
//         System.out.printf("%-15s\n", "SELAMAT DATANG");
//         System.out.printf("%-15s\n", "Silakan pilih menu");
//         System.out.printf("%s\n%s\n", "1. Login Akun", "2. Sign Up Akun (membuat akun baru)");
//         System.out.printf("%s: ", "Pilihan anda"); 

//         int pilihan = sc.nextInt();
//         System.out.println();
//         switch(pilihan){
//             case 1:
//                 AkunPelanggan.cekAkun();
//                 System.out.println("==================================");
//                 System.out.printf("%-15s\n", "Silakan pilih menu");
//                 System.out.printf("%s\n%s\n", "1. Ubah Data Akun", "2. Transaksi");
//                 System.out.printf("%s: ", "Pilihan anda");
//                 int pilihan2 = sc.nextInt();
//                 System.out.println("==================================");
                
                
//                 switch(pilihan2){
//                     case 1:
//                         menuEditAkun();
//                         break;
//                     case 2:
//                         menuTransaksi();
//                         break;
//                 }
//                 break;
//             case 2:
//                 AkunPelanggan.BuatAkun();
//                 break;           
//         }
//     }

//     static void menuAkun(){
//         System.out.printf("%-15s\n", "Silakan Pilih Menu Akun");
//         System.out.printf("%s\n%s\n%s\n", "1. Daftar Akun", "2. Cek Akun", "3. Ubah Data Akun");
//         System.out.printf("%s: ", "Pilihan anda");
//         int pilihan = sc.nextInt();
//         System.out.println();
//         switch(pilihan){
//             case 1:
//                 AkunPelanggan.BuatAkun();
//                 break;
//             case 2:
//                 AkunPelanggan.cekAkun();
//                 break;
//             case 3:
//                 menuEditAkun();
//                 break;
//         }
//     }

//     static void menuTransaksi(){
//         System.out.printf("%s\n%s\n%s\n", "1. Setor Saldo", "2. Tarik Saldo", "3. Pembelian");
//         System.out.printf("%s", "Pilihan anda: ");
        
//         int pilihan = sc.nextInt();
//         System.out.println("==============================");
//         System.out.println();
//         switch(pilihan){
//             case 1:
//                 AkunPelanggan.isiSaldo();
//                 break;
//             case 2:
//                 AkunPelanggan.tarikSaldo();
//                 break;
//             case 3:
//                 // pembelian();
//                 break;
//         }
//     }

//     static void menuEditAkun(){
//         System.out.printf("%-20s\n:", "Silakan masukkan nama pengguna");
//         String cekNama = sc.nextLine();
//         for (AkunPelanggan element : Swalayan.daftarAkun){
//             if(element.getNama().contains(cekNama)){
//                 for(int i = 0; i < 3; i++){
//                     System.out.printf("%-20s:\n", "Silakan masukkan pin");
//                     String cekPin = sc.nextLine();
//                     if(element.getPin().contains(cekPin)){
//                         System.out.printf("%s\n%s\n", "1. Ganti Nama", "2. Ganti PIN");
//                         System.out.printf("%-15s", "Pilihan anda: ");
//                         int pilihan = sc.nextInt();
//                         System.out.println();
//                         switch(pilihan){
//                             case 1:                                           
//                             element.setNama();
//                             break;
//                             case 2:
//                             element.setPin();
//                             break;
//                         }               
//                     }                                       
//                     else if(i == 2){
//                         System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
//                     }
//                     else{
//                         System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
//                     }
//                 }
//                 break;
//             }           
//             else{
//                 System.out.printf("%-15s", "Nama pengguna tidak ditemukan, silakan coba lagi!");
//             }   
//         }
//     }
    
//     // public static void pembelian(){
//     //     // double harga2 = Handphone.harga;
//     //     Handphone handphoneSiomay1 = new Handphone("Siomay", "BlueMi", 4000000.0);
//     //     Handphone handphoneSiomay2 = new Handphone("Siomay", "May 5", 10000000.0);
//     //     Handphone handphoneIpul1 = new Handphone("Ipul", "20", 15000000.0);
//     //     Handphone handphoneIpul2 = new Handphone("Ipul", "Pro MAX", 25000000.0);
//     //     Handphone handphoneFakeMe1 = new Handphone("FakeMe", "Saske", 1500000.0);
//     //     Handphone handphoneFakeMe2 = new Handphone("FakeMe", "Super Saske", 3000000.0);
//     //     Handphone.daftarHp.add(handphoneSiomay1);
//     //     Handphone.daftarHp.add(handphoneSiomay2);
//     //     Handphone.daftarHp.add(handphoneIpul1);
//     //     Handphone.daftarHp.add(handphoneIpul2);
//     //     Handphone.daftarHp.add(handphoneFakeMe1);
//     //     Handphone.daftarHp.add(handphoneFakeMe2);

//     //     System.out.printf("%s\n","Silakan Pilih Produk");
        
//     //     // for (Handphone element : daftarHp) {
//     //     //     for(int i = 0; i < daftarHp.size(); i++){
//     //     //         System.out.print((i+1) + " " + daftarHp.get(i).merk + " " + daftarHp.get(i).seri + ": " + Handphone.daftarHp.get(i).harga);            
//     //     //     }

            
//     //     // }
//     //     // System.out.println(Handphone.daftarHp.harga);
//     //     // System.out.println(daftarHp.);
//     //     System.out.printf("%s %s %-15s: %s\n","1.", handphoneSiomay1.merk, handphoneSiomay1.seri, rupiah.format(handphoneSiomay1.harga) );
//     //     System.out.printf("%s %s %-15s: %s\n","2.", handphoneSiomay2.merk, handphoneSiomay2.seri, rupiah.format(handphoneSiomay2.harga));
//     //     System.out.printf("%s %s %-15s: %s\n","3.", handphoneIpul1.merk, handphoneIpul1.seri, rupiah.format(handphoneIpul1.harga));
//     //     System.out.printf("%s %s %-15s: %s\n", "4.", handphoneIpul2.merk, handphoneIpul2.seri, rupiah.format(handphoneIpul2.harga));
//     //     System.out.printf("%s %s %-15s: %s\n","5.", handphoneFakeMe1.merk, handphoneFakeMe1.seri, rupiah.format(handphoneFakeMe1.harga));
//     //     System.out.printf("%s %s %-15s: %s\n","6.", handphoneFakeMe2.merk, handphoneFakeMe2.seri, rupiah.format(handphoneFakeMe2.harga));
//     //     System.out.printf("%s: ", "Pilihan anda"); 
//     //     int pilihan = sc.nextInt();
//     //     System.out.println();
//     //     System.out.printf("%s: ", "Yakin dengan Pilihan anda? (1. y/2. n)");
//     //     int yakin = sc.nextInt();
//     //     if(yakin == 1){
//     //         System.out.printf("%-20s\n:", "Silakan masukkan nomor pelanggan");
//     //         String cekNomor = sc.nextLine();
//     //         for (AkunPelanggan element : Swalayan.daftarAkun){
//     //             if(element.getNomorPelanggan().contains(cekNomor)){
//     //                 for(int i = 0; i < 3; i++){
//     //                     System.out.printf("%-20s:\n", "Silakan masukkan pin");
//     //                     String cekPin = sc.nextLine();
//     //                     if(element.getPin().contains(cekPin)){
//     //                         if(AkunPelanggan.getSaldo() > harga2 + 10000){
//     //                             // Handphone.keuntunganMember();
//     //                             System.out.println("Pembayaran Berhasil");
//     //                             System.out.println("Saldo Anda saat ini: " + rupiah.format(AkunPelanggan.getSaldo() - harga2));
//     //                             break;
//     //                         }
//     //                         else{
//     //                             System.out.println("Maaf, saldo anda tidak cukup");
//     //                         }
//     //                     }
//     //                     else if(i == 2){
//     //                         System.out.printf("%-15s\n", "Mohon Maaf, akun anda telah terblokir");
//     //                         Swalayan.daftarAkun.remove(element);
//     //                     }
//     //                     else{
//     //                         System.out.printf("%-15s\n", "Pin salah, silakan coba lagi!");
//     //                     }
//     //                 }
//     //                 break;
//     //             }
//     //             else{
//     //                 System.out.printf("%-15s", "Nomor pelanggan tidak ditemukan, silakan coba lagi!");   
//     //             }
//     //         }
//     //     }
//     // }
        
//     public static void main(String[] args) {
//         AkunPelanggan pelanggan1 = new AkunPelanggan("hironemus","7412345678", "1234", "platinum", 10000000);
//         Swalayan.daftarAkun.add(pelanggan1);
//         start();
//     }
// }
