package PemrogramanBerorientasiObjek.PraktikumPBO;

class CivitasAkademik {
    private String nama;
    private String prodi;
    private String fakultas;
    private String alamat;

    void tampilkanData(){
        System.out.printf("%-10s: %s\n","Nama", nama);
        System.out.printf("%-10s: %s\n","Prodi", prodi);
        System.out.printf("%-10s: %s\n","Fakultas", fakultas);
        System.out.printf("%-10s: %s","Alamat", alamat);
    }

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
    
    void tampilkanData(){
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

    public Dosen(String nidn, String gaji) {
        this.nidn = nidn;
        this.gaji = gaji;
    }

    void tampilkanData(){
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

class KRS extends Mahasiswa{
    Mahasiswa mhs;
    MataKuliah[] matkul;

    public KRS(Mahasiswa mhs, MataKuliah[] matkul) {
        this.mhs = mhs;
        this.matkul = matkul;
    }
}

class MataKuliah{
    String kodeMatkul;
    String namaMatkul;
    int sks;
    Dosen dsn;

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
        CivitasAkademik mhs1 = new Mahasiswa();
        mhs1.tampilkanData();
        System.out.println();
        CivitasAkademik dsn1 = new Dosen();
        dsn1.tampilkanData();
    }
}
