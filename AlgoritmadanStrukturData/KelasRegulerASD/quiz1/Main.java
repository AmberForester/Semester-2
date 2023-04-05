package quiz1;

/* 
Nama  : Hironemus Apriliano D. P
NIM   : 225150201111018
Kelas : TIF-C
*/

public class Main {
    public static void main(String[] args) {
    //     int[][] graf = {
    // //       0 1 2 3 4 5 6 7 
    // /*0*/   {0,1,0,1,0,0,0,0}, 
    // /*1*/   {1,0,1,1,0,0,1,0}, 
    // /*2*/   {0,1,0,0,0,0,0,0}, 
    // /*3*/   {1,1,0,0,1,0,0,0}, 
    // /*4*/   {0,0,0,1,0,1,0,0}, 
    // /*5*/   {0,0,0,0,1,0,0,0}, 
    // /*6*/   {0,1,0,0,0,0,0,1}, 
    // /*7*/   {0,0,0,0,0,0,1,0}  
    //         };

    int[][] graf = {
        //   0 1 2 3 4 5 6 7 
       {0,1,1,0,0,0,0,0},
       {1,0,0,1,0,1,0,0},
       {1,0,0,1,1,0,0,0},
       {0,1,1,0,0,0,1,0},
       {0,0,1,0,0,0,0,1},
       {0,1,0,0,0,0,1,0},
       {0,0,0,1,0,1,0,1},
       {0,0,0,0,1,0,1,0}
    };

        int awal = 0;
        int akhir = 7;
        TemukanJalan gas = new TemukanJalan(graf, awal, akhir);
        gas.jalanTersedia();
        System.out.println();
        gas.cari();
        gas.tumpukan.PrintStack();
    }

}
