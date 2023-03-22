package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public interface Interface1 {
    public String cetakString1(String x);
    public String cetakString2(String x);

    public default void msg(){
        System.out.println("Default Method");
    }
    static void start(){
        System.out.println("Mulai Pencetakan");
    }
}
