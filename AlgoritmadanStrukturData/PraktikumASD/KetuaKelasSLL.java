package AlgoritmadanStrukturData.PraktikumASD;
import java.io.*;
import java.util.*;

class Node2 {
    String data;
    Node2 next;

    public Node2(){
        next = null;
    }
    public Node2(String namaInput) {
        this.data = namaInput;
        this.next = null;
    }
}
 
class SLL {
    Node2 kepala;
    Node2 ekor;
    int size;
    
    SLL(){
        this.kepala = null;
        this.ekor = null;
    }
  
    boolean isEmpty() {
        return kepala == null && ekor == null;
    }
 
    int getSize() {
        return size;
    }
  
    void addLast(String command) { //addFirst("Hiro")
        Node2 nodeBaru = new Node2(command);
        if(isEmpty()){
            kepala = ekor = nodeBaru;            
        }
        else{
            ekor.next = nodeBaru;
            ekor = nodeBaru;
        }
        this.size++;
    }
 
    void addFirst(String command) {
        Node2 nodeBaru = new Node2(command);
        if(isEmpty()){
            kepala = ekor = nodeBaru;    
        }
        else{
            nodeBaru.next = kepala;
            kepala = nodeBaru;
        }
        this.size++;
    }
  
    void printList() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else{
            Node2 current = kepala;
            while(current != null){
                System.out.print(current.data + " -> ");
                current = current.next;
            }            
        }
    }
  
    void removeFirst() {
        if(isEmpty()){
            System.out.println("List masih kosong.");                       
        }
        else if(getSize() == 1){
            kepala = ekor = null;
            this.size--;            
        }
        else{
            kepala = kepala.next;            
        }
    }
  
    void removeLast() {
        Node2 current = new Node2();
        current = kepala;
        if(isEmpty()){
            System.out.println("List masih kosong.");           
        }
        else if(getSize() == 1){
            kepala = ekor = null;
            this.size--;
        }        
        else{            
            while(current.next != ekor){
                current = current.next;
            }
            ekor = current;
            ekor.next = null;
            this.size--;
        }
    }
}
 
public class KetuaKelasSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        SLL sll = new SLL();
 
        int n = sc.nextInt(); // jumlah loop/input yg mau dimasukkan
        sc.nextLine(); // consume new line, tanya chatGPT aja kalo gatau
 
        String command = ""; // -> digunakan untuk input, misal : "MAKAN JAGUNG"
        String[] splitted = new String[2]; // -> split dari command, akan berisi [MAKAN, JAGUNG]
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");
 
            if (splitted[0].toLowerCase().equals("addfirst")) {
                sll.addFirst(splitted[1]);
            } 
            else if (splitted[0].toLowerCase().equals("addlast")) {
                sll.addLast(splitted[1]);
            } 
            else if (splitted[0].toLowerCase().equals("print")) {
                sll.printList();
            } 
            else if (splitted[0].toLowerCase().equals("remove")) {
                if (splitted[1].toLowerCase().equals("last")) {
                    sll.removeLast();
                } 
                else if (splitted[1].toLowerCase().equals("first")) {
                    sll.removeFirst();
                }
            }
        }
    }
}
