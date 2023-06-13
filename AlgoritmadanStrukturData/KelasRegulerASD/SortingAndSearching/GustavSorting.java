package SortingAndSearching;

import java.util.Scanner;

class Node {
	Node next;
    Node prev;
    String lagu;
    int jumlahMain;
    
    public Node(){}
    
    public Node(String lagu, int dimainkan){
        this.lagu = lagu;
        this.jumlahMain = dimainkan;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    Node kepala;
    Node ekor;
    int size;
    
    boolean isEmpty(){
        return kepala == null && ekor == null;
    }
    
    void addLast(String laguBaru, int jumlah){
        Node nodeBaru = new Node(laguBaru, jumlah);
        if(isEmpty()){
            kepala = ekor = nodeBaru;
        }
        else{
            ekor.next = nodeBaru;
            nodeBaru.prev = ekor;
            ekor = nodeBaru;
        }
        size++;
    }

    void tukarNode(Node current){
        String tempLagu = "";
        int tempKali = 0;

        tempKali = current.jumlahMain;
        tempLagu = current.lagu;

        current.jumlahMain = current.next.jumlahMain;
        current.lagu = current.next.lagu;

        current.next.jumlahMain = tempKali;
        current.next.lagu = tempLagu;
    }
    
    // void sort(){
    //    Node current = kepala;
    //    String tempLagu = "";
    //    int tempKali = 0;
    //     while (current != null){
    //         if (current.jumlahMain > current.next.jumlahMain){
    //             tempKali = current.jumlahMain;
    //             tempLagu = current.lagu;

    //             current.jumlahMain = current.next.jumlahMain;
    //             current.lagu = current.next.lagu;

    //             current.next.jumlahMain = tempKali;
    //             current.next.lagu = tempLagu;

    //             current = current.next;

    //         }
    //             // temp.prev.next = temp.next;
    //             // temp.next.prev = temp.prev;
    //             // temp.next = temp.next.next;
    //             // if(temp.next.next != null){
    //             //     temp.next.next = temp;
    //             //     temp.prev = temp.next;
    //             //     temp.next.next.prev = temp;
    //         // if (temp.prev != null) {
    //         //     temp.prev.next = temp.next;
    //         // } else {
    //         //     kepala = temp.next;
    //         // }
    //         // temp.next.prev = temp.prev;

    //         // // Update prev dari temp.next dan next dari node
    //         // temp.next = temp.next.next;
    //         // if (temp.next.next != null) {
    //         //     temp.next.next.prev = temp;
    //         // }
    //         // temp.next.next = temp;
    //         // temp.prev = temp.next;
                        
    //     }
    // } 
    public void bubbleSort() {
        // Jika tidak ada node atau hanya ada satu node, tidak perlu melakukan sorting
        if (kepala == null || kepala.next == null) {
            return;
        }
  
        boolean swapped;
        Node current;
        Node last = null;
  
        do {
            swapped = false;
            current = kepala;
  
            while (current.next != last) {
                if (current.jumlahMain > current.next.jumlahMain) {
                    tukarNode(current);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    void print(){
        Node temp = kepala;
        int urutan = 1;
        // System.out.println("=========================================================================");
        // System.out.println();
        // System.out.println("                              RECEIPTIFY");
        // System.out.println("                              This Month");
        // System.out.println();
        // System.out.println("=========================================================================");
        // System.out.println(" NO.  ITEM                                                  TIMES PLAYED");
        // System.out.println("-------------------------------------------------------------------------");

        System.out.println("=========================================================================");
        System.out.println();
        System.out.printf("%50s", "RECEIPTIFY");
        System.out.printf("%50s", "This Month");
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println(" NO.  ITEM                                                  TIMES PLAYED");
        System.out.printf("%s%2s%50s", "NO", "ITEM", "TIMES PLAYED");
        System.out.println("-------------------------------------------------------------------------");
        
        if(size < 11){
            for(int j = 0; j < 10-size; j++){
                while(temp != null){
                    System.out.printf(" %02d   %-63s %d\n", urutan, temp.lagu, temp.jumlahMain);
                    temp = temp.next;
                    urutan++;
                }
                System.out.printf(" %02d   %-63s %s\n", urutan, "-", "-");
                urutan++;    
            }
        }
        else{
            while(temp != null && urutan <= 10){
                System.out.printf(" %02d   %-63s %d\n", urutan, temp.lagu, temp.jumlahMain);
                temp = temp.next;
                urutan++;
            }
        }  
    }
}

public class GustavSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah = sc.nextInt(); sc.nextLine();
        // String input = "";
        LinkedList daftar = new LinkedList();
        
        for(int i = 0; i < jumlah; i++){
            String input = sc.nextLine();
            String[] pisah = input.split(" -- ");
            if(pisah[1].equals("0 ")){}
            else{
                daftar.addLast(pisah[0], Integer.parseInt(pisah[1]));
                // System.out.println(input);
            }
        }
        daftar.bubbleSort();
        daftar.print();
    }
}
