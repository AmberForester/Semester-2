package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class RunInterface {
    public static void main(String[] args) {
        CetakInter cetak = new CetakInter();
        Interface1.start();
        System.out.println(cetak.cetakString1("Halo Masbro!"));
        System.out.println(cetak.cetakString2("Halo Lur!"));
        System.out.println(cetak.cetakInt1(7));
        System.out.println(cetak.cetakInt2(8));
        cetak.cetak();
        cetak.msg();
    }

}
