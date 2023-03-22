package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class CetakInter implements Interface3 {
    public String cetakString1(String x){
        return "Cetak String 1: " + x;
    }
    public String cetakString2(String x){
        return "Cetak String 2: " + x;
    }
    public String cetakInt1(int x){
        return "Cetak Integer 1: " + x;
    }
    public String cetakInt2(int x){
        return "Cetak Integer 2: " + x;
    }
    public void cetak(){
        System.out.println("Semua Sudah tercetak");
    }
}
