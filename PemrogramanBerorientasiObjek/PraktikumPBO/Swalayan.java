package PemrogramanBerorientasiObjek.PraktikumPBO;

class akunPelanggan{
    private double saldo;
    private String nomorPelanggan;
    private String nama;
    private String password;

    public void setSaldo(double saldo, String password) {
        this.saldo = saldo;
        this.password = password;
    }
    
    public void setNama(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public void setNomorPelanggan(String nomorPelanggan, String password) {
        this.nomorPelanggan = nomorPelanggan;
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }
}





public class Swalayan {
    public static void main(String[] args) {
        
    }
}
