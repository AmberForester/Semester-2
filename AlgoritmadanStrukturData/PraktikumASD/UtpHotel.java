package PraktikumASD;
import java.util.Scanner;

public class UtpHotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Mobil mobil = new Mobil();
        Motor motor = new Motor();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        
        String command = ""; 
        String[] splitted = new String[3]; 
        for (int i = 0; i < m; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");
            int temp = Integer.parseInt(splitted[2]);

            if (splitted[0].equals("mobil")) {
                mobil.masuk(splitted[1], temp);
            } else if (splitted[0].equals("motor")) {
                motor.masuk(splitted[1], temp);
            }
        }
        
        // mobil.print();
        // motor.print();
        
        System.out.println("Kendaraan selamat :");
        if (mobil.isEmpty()){
            System.out.println("Tidak ada mobil di dalam basement.");
        }
        mobil.cek_selamat(n);
        motor.cek_selamat(n);
        System.out.println();
        
        System.out.println("Kendaraan tertimbun :");
        if (mobil.isEmpty()){
            System.out.println("Tidak ada mobil yang tertimbun.");
        }
        if (motor.isEmpty()){
            System.out.println("Tidak ada motor yang tertimbun.");
        }else{
            mobil.cek_timbun();
            motor.cek_timbun();
        }
        System.out.println();
        
        int tertimbun = mobil.orangTimbun + motor.getSize();
        System.out.println("Total korban tertimbun sebanyak "+ tertimbun +" orang.");
    }
}

class Node {
  String data1;
    int data2;
    Node next;
      Node(String data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
        this.next = null;
    }
  
      Node(String data1, int data2, Node next){
        this.data1 = data1;
        this.data2 = data2;
        this.next = null;
    }
  
}

class Mobil {
    Node head;
    Node tail;
    int size;
    int tempSize;
    public int orangTimbun;
    
 
      boolean isEmpty(){
        return head == null && tail == null;
    }
    
    int getSize(){
        return size;
    }
  
      void masuk(String plat, int penumpang){
        Node newNode = new Node(plat, penumpang);
        if (isEmpty()) {
            head = tail = newNode;
        }else if (getSize() == 1){
            head.next = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }   
  
      void keluar(){
       if (tail != null) {
            if (head != null && head == tail) {
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
            }
            size--;
        } else if (isEmpty()) {
            System.out.println("List masih kosong.");
        }
    }
  
      void cek_selamat(int durasi){
        String selamat = "";
        while (durasi != 0){
            if (!isEmpty()){
            selamat += tail.data1 + ", ";
            keluar();
            }
            durasi--;
        }
        System.out.println("Mobil dengan plat nomor " + selamat + "berhasil keluar dengan selamat.");
    }
  
      void cek_timbun(){
        Node temp = head;
        orangTimbun =0;
        String timbun = "";
        while (temp != null){
            timbun += head.data1 + ", ";
            orangTimbun += head.data2; 
            temp = temp.next;
        }
        System.out.println("Mobil dengan plat nomor: " + timbun + "masih tertimbun reruntuhan.");
    }
    
    void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data1 + " " + temp.data2);
            temp = temp.next;
        }
    }
 
}

class Motor {
    Node head;
    Node tail;
    int size;
    
      boolean isEmpty() {
        return head == null && tail == null;
    }
    
    int getSize(){
        return size;
    }
  
      void masuk(String plat, int cc){
      Node newNode = new Node(plat, cc);
        if (isEmpty()) {
            head = tail = newNode;
        } else if (getSize() == 1) {
            if (head.data2 < newNode.data2) {
                newNode.next = head;
                head = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        } else {
            if (newNode.data2 > head.data2) {
                newNode.next = head;
                head = newNode;
            } else if (newNode.data2 < tail.data2) {
                tail.next = newNode;
                tail = newNode;
            } else {
                Node temp = head;
                while (temp.next != null && temp.next.data2 >= newNode.data2) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        size++;
    }
  
      void keluar(){
        if (getSize() == 1){
            head = null;
            tail = null;
        }else if (getSize() == 2){
            head = tail;
        }else{
            head = head.next;
        }
        size--;
    }
  
      void cek_selamat(int durasi){
        String selamat = "";
        int orangSafe;
        while (durasi != 0){
            if (getSize()>0){
               selamat += head.data1 + ", ";
            }
            keluar();
            durasi--;
        }
        System.out.println("Motor dengan plat nomor " + selamat + "berhasil keluar dengan selamat.");
    }
  
      void cek_timbun(){
    Node temp = head;
    String timbun = "";
    while (temp != null){
        timbun += temp.data1 + ", ";
        temp = temp.next;
    }
    System.out.println("Motor dengan plat nomor: " + timbun + "masih tertimbun reruntuhan.");
}

    
    void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data1 + " " + temp.data2);
            temp = temp.next;
        }
    }
}