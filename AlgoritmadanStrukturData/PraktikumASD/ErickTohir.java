import java.util.Scanner;
public class ErickTohir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int banyakJenis = sc.nextInt();
        int stokBarang[] = new int[banyakJenis];
        for(int i = 0; i < banyakJenis; i++){
            stokBarang[i] = sc.nextInt();
            //System.out.println(stokBarang[i]);
            
        }     
        int banyakClient = sc.nextInt();
        int requestBarang[][] = new int[banyakClient][banyakJenis];
        for(int i = 0; i < banyakClient; i++){
            for(int j = 0; j < banyakJenis; j++){
                requestBarang[i][j] = sc.nextInt();
            //System.out.println(requestBarang[i][j]);
            }
            
        }
        // System.out.println(banyakClient);
        // System.out.println(banyakJenis);
        for(int i = 0; i < banyakClient;i++){
            for(int j = 0; j < banyakJenis; j++){
                int sisaBarang = stokBarang[j] - requestBarang[i][j];
                if (stokBarang[j] < 0) stokBarang[j] = 0;
                if(stokBarang[j] >= requestBarang[i][j]){
                    System.out.print(requestBarang[i][j] + "   ");
                }
                else if(stokBarang[j] <= requestBarang[i][j] && sisaBarang > 0){
                    System.out.print(sisaBarang + "   ");
                }
                else if(sisaBarang < 0 && stokBarang[j] <= requestBarang[i][j]){
                    System.out.print(stokBarang[j] + "   ");
                }
                stokBarang[j] = sisaBarang;
            }
            System.out.println();
        }        
    }
}



