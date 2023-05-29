import java.util.*;
public class Kuis1fix {
    public static void main(String[]args){
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String[] namaBarang = new String[n];
            for(int i = 0; i < n; i++){
                namaBarang[i] = x.next();
        }
    }
}
