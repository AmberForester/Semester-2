package AlgoritmadanStrukturData.PraktikumASD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LiaProplayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arrayInput = input.split(" ");   
        int[] waktu = new int[arrayInput.length];
        
        for(int i = 0; i < arrayInput.length; i++){
            waktu[i] = Integer.parseInt(arrayInput[i]);
        }
    }

    static void menghitungStreak(int[] input){
        int jumlahStreak = 0;
        int streakTerpanjang = 0;
        int totalWaktu = 0;
        
        for(int i = 0; i < input.length; i++){
            if(input[i] >= 30){
                ++jumlahStreak;
                streakTerpanjang = jumlahStreak;
                totalWaktu += input[i];
            }
            else{
                jumlahStreak = 0;
                totalWaktu = 0;
            }
            System.out.println("Longest Streak is " + jumlahStreak + "days (" + totalWaktu + ")" + " mins");
            System.out.println(totalWaktu);
        }
    }
}
