package quiz1;

public class Main {
    public static void main(String[] args) {
        int[][] graf = {
    //       0 1 2 3 4 5 6 7 
    /*0*/   {0,1,0,1,0,0,0,0}, 
    /*1*/   {1,0,1,1,0,0,1,0}, 
    /*2*/   {0,1,0,0,0,0,0,0}, 
    /*3*/   {1,1,0,0,1,0,0,0}, 
    /*4*/   {0,0,0,1,0,1,0,0}, 
    /*5*/   {0,0,0,0,1,0,0,0}, 
    /*6*/   {0,1,0,0,0,0,0,1}, 
    /*7*/   {0,0,0,0,0,0,1,0}  
            };

        int awal = 0;
        int akhir = 2;
        TemukanJalan gas = new TemukanJalan(graf, awal, akhir);
        gas.jalanTersedia();
        gas.cari();
        gas.tumpukan.PrintStack();
    }

}
