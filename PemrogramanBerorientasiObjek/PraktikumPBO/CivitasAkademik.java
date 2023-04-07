package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.text.DecimalFormat;

abstract class CivitasAkademik {
    private String nama;
    private String prodi;
    private String fakultas;
    private String alamat;
    DecimalFormat rp = new DecimalFormat("Rp ###,###.00");

    public CivitasAkademik(){}
    public CivitasAkademik(String nama, String alamat, String prodi, String fakultas) {
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.alamat = alamat;
    }

    public abstract void tampilkanData();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

class Mahasiswa extends CivitasAkademik{
    
    private String nim;
    private String ukt;

    public Mahasiswa() {}

    public Mahasiswa(String nim, String ukt) {
        this.nim = nim;
        this.ukt = ukt;
    }

    public Mahasiswa(String nim, String nama, String alamat, String prodi, String fakultas, String ukt){
        super(nama, alamat, prodi, fakultas);
        this.nim = nim;
        this.ukt = ukt;
    }
    
    public void tampilkanData(){
        System.out.printf("%-10s: %s\n","Nama", getNama());
        System.out.printf("%-10s: %s\n","Prodi", getProdi());
        System.out.printf("%-10s: %s\n","Fakultas", getFakultas());
        System.out.printf("%-10s: %s\n","Alamat", getAlamat());
        System.out.printf("%-10s: %s\n","NIM", nim);
        System.out.printf("%-10s: %s\n","UKT", rp.format(Integer.parseInt(ukt)));
        System.out.println();
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setUkt(String ukt) {
        this.ukt = ukt;
    }

    public String getNim() {
        return nim;
    }

    public String getUkt() {
        return ukt;
    }
}

class Dosen extends CivitasAkademik{
    private String nidn;
    private String gaji;

       public Dosen() {}

    public Dosen(String nidn, String gaji){
        this.nidn = nidn;
        this.gaji = gaji;
    }

    public Dosen(String nidn, String nama, String alamat, String prodi, String fakultas) {
        super(nama, alamat, prodi, fakultas);
        this.nidn = nidn;
    }

    public Dosen(String nama, String alamat, String prodi, String fakultas, String nidn, String gaji) {
        super(nama, alamat, prodi, fakultas);
        this.nidn = nidn;
        this.gaji = gaji;
    }

    public void tampilkanData(){
        System.out.printf("%-10s: %s\n","Nama", getNama());
        System.out.printf("%-10s: %s\n","Prodi", getProdi());
        System.out.printf("%-10s: %s\n","Fakultas", getFakultas());
        System.out.printf("%-10s: %s\n","Alamat", getAlamat());
        System.out.printf("%-10s: %s\n","NIDN", nidn);
        System.out.printf("%-10s: %s\n","Gaji", rp.format(Integer.parseInt(gaji)));
        System.out.println();
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getNidn() {
        return nidn;
    }

    public String getGaji() {
        return gaji;
    } 
}

class KRS{
    private Mahasiswa mhs;
    private MataKuliah[] matkul = new MataKuliah[100];
    int totalSKS;
    int jumlahMatkul;
    DecimalFormat rp = new DecimalFormat("Rp ###,###.00");

    public KRS(){};

    public KRS(Mahasiswa mhs, MataKuliah[] matkul) {
        this.mhs = mhs;
    }

    void tambahMatkul(MataKuliah matkulBaru){
        totalSKS += matkulBaru.getSks(); 
        if(totalSKS <= 24){
            matkul[jumlahMatkul] = matkulBaru;
            jumlahMatkul++;  
        }
    }

    void tampilKRS(){
        System.out.printf("%-10s: %s\n","Nama", mhs.getNama());
        System.out.printf("%-10s: %s\n","Prodi", mhs.getProdi());
        System.out.printf("%-10s: %s\n","Fakultas", mhs.getFakultas());
        System.out.printf("%-10s: %s\n","Alamat", mhs.getAlamat());
        System.out.printf("%-10s: %s\n","NIM", mhs.getNim());
        System.out.printf("%-10s: %s\n","UKT", rp.format(Integer.parseInt(mhs.getUkt())));
        System.out.println();
        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.printf("%-20s: %s\n","Nama Mata Kuliah", matkul[i].getNamaMatkul());
            System.out.printf("%-20s: %s\n","Kode Mata Kuliah", matkul[i].getKodeMatkul());
            System.out.printf("%-20s: %s\n","Dosen Pengampu", matkul[i].getDsn().getNama());
            System.out.printf("%-20s: %s\n\n","jumlah SKS", matkul[i].getSks());
        }
        if(totalSKS > 24){
            System.out.println();
            System.out.println("Jumlah SKS sudah lebih dari 24, Mata kuliah terakhir yang ditambahkan tidak akan dimasukkan kedalam KRS");
        }
    }

    public Mahasiswa getMhs() {
        return mhs;
    }

    public void setMhs(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public MataKuliah[] getMatkul() {
        return matkul;
    }

    public void setMatkul(MataKuliah[] matkul) {
        this.matkul = matkul;
    }
}

class MataKuliah{
    private String kodeMatkul;
    private String namaMatkul;
    private int sks;
    private Dosen dsn;

    public MataKuliah() {}
    
    public MataKuliah(String kodeMatkul, String namaMatkul, int sks, Dosen dsn) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.dsn = dsn;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public Dosen getDsn() {
        return dsn;
    }

    public void setDsn(Dosen dsn) {
        this.dsn = dsn;
    }
}

class Run{
    public static void main(String[] args) {
        Dosen d1 = new Dosen("Paijo","Tidar","TIF", "FILKOM","123", "10000000");
        Dosen d2 = new Dosen("Paino","Blimbing","TIF","FILKOM","234", "15000000");
        Dosen d3 = new Dosen("Paimin", "lowokwaru", "TIF", "FILKOM", "345", "12000000");
        Dosen d4 = new Dosen("Painem", "Klojen", "TIF", "FILKOM", "456", "18000000");
        d1.tampilkanData();
        d2.tampilkanData();
        d3.tampilkanData();
        d4.tampilkanData();

        KRS krs1 = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
        MataKuliah m5 = new MataKuliah("CIF62005", "AL", 10, d3);
        
        Mahasiswa mhs1 = new Mahasiswa("225150201111018","Hironemus Apriliano D. P", "Surakarta","TIF","FILKOM", "9500000");
        Mahasiswa mhs2 = new Mahasiswa("225150201111016","Daffarel Adyatma","Rembang","TIF", "FILKOM", "7500000"); 
        Mahasiswa mhs3 = new Mahasiswa("225150201111015","Moch. Gustav Ali","Nganjuk","TIF", "FILKOM", "8500000");
        mhs1.tampilkanData();
        mhs2.tampilkanData();
        mhs3.tampilkanData();
    }
}

// CivitasAkademik mhs1 = new Mahasiswa();
        // mhs1.tampilkanData();
        // System.out.println();
        // CivitasAkademik dsn1 = new Dosen();
        // dsn1.tampilkanData();

        // d1.tampilkanData();
        // d2.tampilkanData();
        // d3.tampilkanData();
        // d4.tampilkanData();

        // mhs1.tampilkanData();
        // mhs2.tampilkanData();
        // mhs3.tampilkanData();

        // MataKuliah m5 = new MataKuliah("CIF62005", "AL", 10, d3);
        // krs1.tambahMatkul(m5);
        
        // class Run{
        //     public static void main(String[] args) {
        //         Dosen d1 = new Dosen("Paijo","Tidar","TIF", "FILKOM","123", "10000000");
        //         Dosen d2 = new Dosen("Paino","Blimbing","TIF","FILKOM","234", "15000000");
        //         Dosen d3 = new Dosen("Paimin", "lowokwaru", "TIF", "FILKOM", "345", "12000000");
        //         Dosen d4 = new Dosen("Painem", "Klojen", "TIF", "FILKOM", "456", "18000000");
        
        //         KRS krs1 = new KRS();
        //         MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        //         MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        //         MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        //         MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
                
        //         Mahasiswa mhs1 = new Mahasiswa("225150201111018","Hironemus Apriliano D. P", "Surakarta","TIF","FILKOM", "9500000");
        //         Mahasiswa mhs2 = new Mahasiswa("225150201111016","Daffarel Adyatma","Rembang","TIF", "FILKOM", "7500000"); 
        //         Mahasiswa mhs3 = new Mahasiswa("225150201111015","Moch. Gustav Ali","Nganjuk","TIF", "FILKOM", "8500000");
                
        //         krs1.setMhs(mhs1);
        //         krs1.tambahMatkul(m1);
        //         krs1.tambahMatkul(m2);
        //         krs1.tambahMatkul(m3);
        //         krs1.tambahMatkul(m4);
        //         krs1.tampilKRS();    
        //     }
        // }
        
        // class Run{
        //     public static void main(String[] args) {
        //         Dosen d1 = new Dosen("Paijo","Tidar","TIF", "FILKOM","123", "10000000");
        //         Dosen d2 = new Dosen("Paino","Blimbing","TIF","FILKOM","234", "15000000");
        //         Dosen d3 = new Dosen("Paimin", "lowokwaru", "TIF", "FILKOM", "345", "12000000");
        //         Dosen d4 = new Dosen("Painem", "Klojen", "TIF", "FILKOM", "456", "18000000");
        
        //         KRS krs1 = new KRS();
        //         MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        //         MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        //         MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        //         MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
        //         MataKuliah m5 = new MataKuliah("CIF62005", "AL", 10, d3);
                
        //         Mahasiswa mhs1 = new Mahasiswa("225150201111018","Hironemus Apriliano D. P", "Surakarta","TIF","FILKOM", "9500000");
        //         Mahasiswa mhs2 = new Mahasiswa("225150201111016","Daffarel Adyatma","Rembang","TIF", "FILKOM", "7500000"); 
        //         Mahasiswa mhs3 = new Mahasiswa("225150201111015","Moch. Gustav Ali","Nganjuk","TIF", "FILKOM", "8500000");
                
        //         krs1.setMhs(mhs1);
        //         krs1.tambahMatkul(m1);
        //         krs1.tambahMatkul(m2);
        //         krs1.tambahMatkul(m3);
        //         krs1.tambahMatkul(m4);
        //         krs1.tambahMatkul(m5);
        //         krs1.tampilKRS();    
        //     }
        // }

        // class Run{
        //     public static void main(String[] args) {
        //         Dosen d1 = new Dosen("Paijo","Tidar","TIF", "FILKOM","123", "10000000");
        //         Dosen d2 = new Dosen("Paino","Blimbing","TIF","FILKOM","234", "15000000");
        //         Dosen d3 = new Dosen("Paimin", "lowokwaru", "TIF", "FILKOM", "345", "12000000");
        //         Dosen d4 = new Dosen("Painem", "Klojen", "TIF", "FILKOM", "456", "18000000");
        //         d1.tampilkanData();
        //         d2.tampilkanData();
        //         d3.tampilkanData();
        //         d4.tampilkanData();
        
        //         KRS krs1 = new KRS();
        //         MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        //         MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        //         MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        //         MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
        //         MataKuliah m5 = new MataKuliah("CIF62005", "AL", 10, d3);
                
        //         Mahasiswa mhs1 = new Mahasiswa("225150201111018","Hironemus Apriliano D. P", "Surakarta","TIF","FILKOM", "9500000");
        //         Mahasiswa mhs2 = new Mahasiswa("225150201111016","Daffarel Adyatma","Rembang","TIF", "FILKOM", "7500000"); 
        //         Mahasiswa mhs3 = new Mahasiswa("225150201111015","Moch. Gustav Ali","Nganjuk","TIF", "FILKOM", "8500000");
        //         mhs1.tampilkanData();
        //         mhs2.tampilkanData();
        //         mhs3.tampilkanData();
        //     }
        // }