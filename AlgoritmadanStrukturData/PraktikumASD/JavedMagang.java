import java.util.Scanner;
class NodeJaved {
    String data;
    NodeJaved under;
    
    public NodeJaved(String data){
        this.data = data;
        under = null;
    }
}

class Stack {  
    NodeJaved top;
    
    boolean isEmpty(){
        return top == null;
    }
    
     void makeEmpty(){
        top = null;
    }
    
    void push(String dataBaru){
        NodeJaved nodeBaru = new NodeJaved(dataBaru);
        if(isEmpty()){
            top = nodeBaru;
        }
        else{
            nodeBaru.under = top;
            top = nodeBaru;
        }
    }
    
    String peek(){
        return (isEmpty())? "Homepage" : top.data;
    }
    
    String pop(){
        if(isEmpty()){
            return "";
        }
        else{
            String data = top.data;
            top = top.under;
            return data;
       }
   }
}

/*
 * BOLEH KALO MAU BIKIN CLASS TAMBAHAN !
 */

public class JavedMagang {
    public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
//         int jumlah = sc.nextInt;
//         for(int i = 0; i < jumlah; i++){
            
//         }
        Stack tumpukan = new Stack();
        Stack penyimpanan = new Stack();
        String sekarang = "Homepage";
        
        int jumlah = sc.nextInt(); sc.nextLine();
        String perintah = "";
        String[] splitPerintah = new String[2];
        for (int i = 0; i < jumlah; i++) {
            perintah = sc.nextLine();
            splitPerintah = perintah.split(" ");

            if (splitPerintah[0].equalsIgnoreCase("visit")) {
                tumpukan.push(splitPerintah[1]);
                // sekarang = splitPerintah[1];
                penyimpanan.makeEmpty();          
            } 
            else if (splitPerintah[0].equalsIgnoreCase("back")) {
                if(tumpukan.isEmpty()){
                    System.out.println("No pages back.");
                    // sekarang = "Homepage";
                }
                else{
                    penyimpanan.push(tumpukan.pop());
                    // sekarang = tumpukan.pop();
                }         
            }      
            else if (splitPerintah[0].equalsIgnoreCase("forward")) {
                if(penyimpanan.isEmpty()){
                    System.out.println("No pages forward.");
                    // sekarang = "Homepage";
                }
                else{
                    tumpukan.push(penyimpanan.pop());
                    // sekarang = penyimpanan.pop();
                }            
            }         
            else if (splitPerintah[0].equalsIgnoreCase("current")) {
                System.out.println(tumpukan.peek());
            }
        }
        sc.close();
    }
}

