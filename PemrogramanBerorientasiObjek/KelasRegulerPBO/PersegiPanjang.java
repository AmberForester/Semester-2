package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class PersegiPanjang extends BangunDatar{
    public double panjang;
    public double lebar;

    public PersegiPanjang(){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double luas(){
        return panjang*lebar;
    }

    public double keliling(){
        return 2*(panjang+lebar);
    }    
}
