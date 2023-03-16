package PemrogramanBerorientasiObjek.PraktikumPBO;
import java.util.Scanner;

class Pahlawan{
    public long darahPahlawan;
    public long seranganPahlawan;
    public long koin;
    public long tambahSerangan;
    public long tambahDarah;
}

class Monster{
    public long darahMonster;
    public long seranganMonster;
}

public class Permainan{

    public static void pertempuran(Pahlawan hero, Monster villain){
        
        // hero.seranganPahlawan += hero.koin * hero.tambahSerangan;
        // hero.darahPahlawan += hero.koin * hero.tambahDarah;
        for(int i = 0; i < hero.koin; i++){
            if(i % 2 == 0){
                hero.seranganPahlawan = hero.seranganPahlawan + hero.tambahSerangan;
            }
            else{
                hero.darahPahlawan = hero.darahPahlawan + hero.tambahDarah;
            }
        }
        // // System.out.print(hero.darahPahlawan + ", " + villain.darahMonster + " --> ");
        // while(hero.darahPahlawan > 0 && villain.darahMonster > 0){
        //     villain.darahMonster = villain.darahMonster - hero.seranganPahlawan;
        //     hero.darahPahlawan = hero.darahPahlawan - villain.seranganMonster;
        //     // System.out.print(hero.darahPahlawan + ", " + villain.darahMonster + " --> ");
        //     if(villain.darahMonster <= 0 && hero.darahPahlawan > 0){
        //         System.out.println("YES");
        //     }
        //     else if(villain.darahMonster <= 0 && hero.darahPahlawan <= 0){
        //         System.out.println("YES");
        //     }
        //     else if(hero.darahPahlawan <= 0 && villain.darahMonster > 0){
        //         System.out.println("NO");
        //     }
        // }
        long caraMonster = (long)Math.ceil((double)hero.darahPahlawan / (double)villain.seranganMonster);
        long caraPahlawan = (long)Math.ceil((double)villain.darahMonster / (double)hero.seranganPahlawan);
        long sisaDarahMonster = hero.darahPahlawan % villain.seranganMonster;
        long sisaDarahPahlawan = villain.darahMonster % hero.seranganPahlawan;
        
        if(caraPahlawan <= caraMonster){
            System.out.println("YES");
        }
        else if(caraPahlawan > caraMonster){
            System.out.println("NO");
        }
        else if(caraPahlawan == caraMonster){
            if(sisaDarahPahlawan < sisaDarahMonster){
                System.out.println("YES");
                
            }
            else{
                System.out.println("NO");
            }
        
        }  
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlahInput = sc.nextInt(); 
        Pahlawan hero = new Pahlawan();
        Monster villain = new Monster();
        for(int i = 0; i < jumlahInput; i++){           
            hero.darahPahlawan = sc.nextLong();
            hero.seranganPahlawan = sc.nextLong();
            villain.darahMonster = sc.nextLong();
            villain.seranganMonster = sc.nextLong();
            hero.koin = sc.nextLong();
            hero.tambahSerangan = sc.nextLong();
            hero.tambahDarah = sc.nextLong();
            pertempuran(hero, villain);
        }   
    }
}
