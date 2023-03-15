package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.util.Scanner;
public class Permainan {   
}

class Pahlawan{
    public int darahPahlawan;
    public int seranganPahlawan;
    public int koin;
    public int tambahSerangan;
    public int tambahDarah;

    // public Pahlawan(int darahPahlawan, int seranganPahlawan, int koin, int tambahSerangan, int tambahDarah){
    //     this.darahPahlawan = darahPahlawan;
    //     this.seranganPahlawan = seranganPahlawan;
    //     this.koin = koin;
    //     this.tambahSerangan = tambahSerangan;
    //     this.tambahDarah = tambahDarah;
    // }
}

class Monster{
    public int darahMonster;
    public int seranganMonster;

    // public Monster(int darahMonster, int seranganMonster){
    //     this.darahMonster = darahMonster;
    //     this.seranganMonster = seranganMonster;

    // }
    

}

class RunPermainan{

    public void pertempuran(Pahlawan hero, Monster villain){
        for(int i = 0; i < hero.koin; i++){

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int jumlahInput = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < jumlahInput; i++){
            Pahlawan hero = new Pahlawan();
            Monster villain = new Monster();
            hero.darahPahlawan = sc.nextInt();
            hero.seranganPahlawan = sc.nextInt();
            villain.darahMonster = sc.nextInt();
            villain.seranganMonster = sc.nextInt();
            hero.koin = sc.nextInt();
            hero.tambahSerangan = sc.nextInt();
            hero.tambahDarah = sc.nextInt();

            System.out.println();


        }
    }
}
