package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class CoffeShop {
    public static void main(String[] args) {
        Coffee kapalApi = new Coffee(Size.SMALL);
        System.out.println(kapalApi.getPrice());
    }
}
