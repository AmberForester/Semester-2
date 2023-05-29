import java.util.*;
public class Latihan {
    public static void main(String[] args) {

        int[][][] arrays = new int[3][3][2];
        int isian = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 2; k++){
                    arrays[i][j][k] = ++isian;
                    System.out.print(arrays[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
//        int[][][] arrays = {
//                { {1,2}, {3,4} },
//                { {5,6}, {7,8} },
//                { {9,10}, {11,12} }
//        };
//arrays[i][j][k] = ++isian;



//{ { {1,2}, {3,4} },
//        { {5,6}, {7,8} },
//        { {9,10}, {11,12} } };
//    Scanner x = new Scanner(System.in);
//    float[] array = new float[3];
//        for(int i = 0; i < 3; i++){
//        array[i] = x.nextInt();
//        }
//        System.out.println(Arrays.toString(array));
//        float terkecil = array[2];
//        for(int i = 0; i < 3; i++){
//        if(array[i] < terkecil){
//        terkecil = array[i];
//        }
//        }
//        System.out.println(terkecil);




//    Scanner z = new Scanner(System.in);
//    int n = z.nextInt();
//        for(int i = n; i > 0; i--){
//                for (int j = 0; j < i; j++){
//        System.out.print("* ");
//        }
//        System.out.println();
//        }

//    int x,y,z;
//        for(x = 0; x < 4; x++){
//        for(y = 0; y < 3; y++){
//        for(z = 0; z < 3; z++){
//        if(z == 2) break;
//        }
//        System.out.printf("Selamat\n");
//        }
//        System.out.printf("Datang\n");
//        }
//        System.out.printf("di TIF-FILKOMUB\n");