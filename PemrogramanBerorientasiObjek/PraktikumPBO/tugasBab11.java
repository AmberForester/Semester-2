package PemrogramanBerorientasiObjek.PraktikumPBO;

import java.util.*;

public class tugasBab11 {
    public static void main(String[] args) {
        String kalimat = "Saya belajar bahasa Java. Bahasa Java mempunyai kelas berupa String. Belajar String Java itu mudah. String Java juga sering diimplementasikan";
        String pembatas = ". ";
        memecahString(kalimat, pembatas);
    }

    static void memecahString(String kalimat, String pembatas){
        StringTokenizer tokenKalimat = new StringTokenizer(kalimat, pembatas);
        Map<String, Integer> listToken = new LinkedHashMap<>();
        while(tokenKalimat.hasMoreTokens()){
            String token = tokenKalimat.nextToken().toLowerCase();
            if(!listToken.containsKey(token)){
                listToken.put(token, 1);
            }
            else{
                int frekuensi = listToken.get(token);
                listToken.put(token, ++frekuensi);
            }
        }
        System.out.println("-----------------------------------------");
        System.out.printf("%-8s%-12s%-6s%-14s%s\n", "|","Token","|", "Frekuensi", "|");
        System.out.println("-----------------------------------------");
        for (Map.Entry<String, Integer> entry : listToken.entrySet()) {
            String token = entry.getKey();
            int frekuensi = entry.getValue(); 
            System.out.printf("%-2s%-18s%-10s%-10d%s\n","|", token,"|", frekuensi, "|");
        }
        System.out.println("-----------------------------------------");
    }
}
// static void memecahString2(String kalimat, String pembatas){
//     StringTokenizer tokenKalimat = new StringTokenizer(kalimat, pembatas);
//     List<String> listToken = new ArrayList<>();
//     while(tokenKalimat.hasMoreTokens()){
//         String token = tokenKalimat.nextToken();
//         listToken.add(token);
//     }

//     int[] arrFrekuensi = new int[listToken.size()];

//     for (int i = 0; i < listToken.size(); i++) {
//         int frekuensi = 0;
//         for (int j = 0; j < listToken.size(); j++) {
//             if(listToken.get(j).equalsIgnoreCase(listToken.get(i))){
//                 frekuensi++;
//             }
//         }
//         arrFrekuensi[i] = frekuensi;
//     }
    
//     boolean ada = false;
//     for (int i = 0; i < arrFrekuensi.length; i++) {
//         System.out.println(listToken.get(i) + ": " + arrFrekuensi[i]);
//     }
// }
