package PemrogramanBerorientasiObjek.KelasRegulerPBO;

public class JavaString {
    public static void main(String[] args) {
        String dokumen = "Saya belajar Java. Java adalah salah satu bahasa pemorgraman. Belajar Java sangat mudah apabila rajin berlatih. Belajar bahasa JAVA dilakukan seminggu dua kali";
        // hitungKata(dokumen, "java");
        System.out.print("Jumlah kata java: ");
        System.out.println(hitungKata(dokumen, "java"));
        System.out.print("Jumlah kata bahasa: ");
        System.out.println(hitungKata(dokumen, "bahasa"));
        System.out.print("Jumlah kata belajar: ");
        System.out.println(hitungKata(dokumen, "belajar"));
    }
    
    static int hitungKata(String kalimat, String kunci){
        int jumlahKata = 0;
        String[] split = kalimat.split("[., ]");
        for (String kata : split) {
            if(kata.equalsIgnoreCase(kunci)){
                jumlahKata++;
            }
        }
        return jumlahKata;
    }

    
}
