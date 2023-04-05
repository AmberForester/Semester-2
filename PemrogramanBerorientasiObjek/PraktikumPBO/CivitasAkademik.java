package PemrogramanBerorientasiObjek.PraktikumPBO;

abstract class CivitasAkademik {
    private String nama;
    private String prodi;
    private String fakultas;
    private String alamat;

    public CivitasAkademik(){}
    public CivitasAkademik(String nama, String prodi, String fakultas) {
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
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

    public Mahasiswa(String nim, String nama, String prodi, String fakultas){
        super(nama, prodi, fakultas);
        this.nim = nim;
    }
    
    public void tampilkanData(){
        System.out.printf("%-10s: %s\n","Nama", getNama());
        System.out.printf("%-10s: %s\n","Prodi", getProdi());
        System.out.printf("%-10s: %s\n","Fakultas", getFakultas());
        System.out.printf("%-10s: %s\n","Alamat", getAlamat());
        System.out.printf("%-10s: %s\n","NIM", nim);
        System.out.printf("%-10s: %s\n","UKT", ukt);
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

    public Dosen(String nidn, String nama, String prodi, String fakultas) {
        super(nama, prodi, fakultas);
        this.nidn = nidn;
    }

    public Dosen(String nama, String prodi, String fakultas, String nidn, String gaji) {
        super(nama, prodi, fakultas);
        this.nidn = nidn;
        this.gaji = gaji;
    }

    public void tampilkanData(){
        System.out.printf("%-10s: %s\n","Nama", getNama());
        System.out.printf("%-10s: %s\n","Prodi", getProdi());
        System.out.printf("%-10s: %s\n","Fakultas", getFakultas());
        System.out.printf("%-10s: %s\n","Alamat", getAlamat());
        System.out.printf("%-10s: %s\n","NIDN", nidn);
        System.out.printf("%-10s: %s\n","Gaji", gaji);
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
    private MataKuliah[] matkul = new MataKuliah[12];
    int totalSKS;
    int jumlahMatkul;

    public KRS(){};

    public KRS(Mahasiswa mhs, MataKuliah[] matkul) {
        this.mhs = mhs;
    }

    void tambahMatkul(MataKuliah matkulBaru){
        System.out.println(totalSKS);
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
        System.out.printf("%-10s: %s\n","UKT", mhs.getUkt());
        System.out.println();
        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.printf("%-20s: %s\n","Nama Mata Kuliah", matkul[i].getNamaMatkul());
            System.out.printf("%-20s: %s\n","Kode Mata Kuliah", matkul[i].getKodeMatkul());
            System.out.printf("%-20s: %s\n","Dosen Pengampu", matkul[i].getDsn().getNama());
            System.out.printf("%-20s: %s\n","jumlah SKS", matkul[i].getSks());
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
        // CivitasAkademik mhs1 = new Mahasiswa();
        // mhs1.tampilkanData();
        // System.out.println();
        // CivitasAkademik dsn1 = new Dosen();
        // dsn1.tampilkanData();

        Dosen d1 = new Dosen("123","Paijo","TIF","FILKOM");
        Dosen d2 = new Dosen("124","Paino","TIF","FILKOM");
        Dosen d3 = new Dosen("125", "Paimin", "TIF", "FILKOM");
        d1.tampilkanData();
        d2.tampilkanData();
        d3.tampilkanData();
        KRS krs1 = new KRS();
        KRS krs2 = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
        // MataKuliah m5 = new MataKuliah("CIF62005", "AL", 2, d3);
        krs1.setMhs(new Mahasiswa("225150201111018","Hironemus Apriliano D. P","TIF","FILKOM"));
        krs2.setMhs(new Mahasiswa("225150201111016","Daffarel Adyatma", "TIF", "FILKOM"));
        
        krs1.tambahMatkul(m1);
        krs1.tambahMatkul(m2);
        krs1.tambahMatkul(m3);
        krs1.tambahMatkul(m4);
        // krs1.tambahMatkul(m5);
        krs1.tampilKRS();
    }
}
