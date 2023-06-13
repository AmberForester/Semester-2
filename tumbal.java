
import java.util.Scanner;

import AlgoritmadanStrukturData.LinkedList.LinkedList;
public class tumbal {}

class Node {
	Node next;
    Node prev;
    String data1;
    int data2;
    
    public Node(String data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
    }
}

class LinkedList {
	Node head;
    Node tail;
    int size;
    int i = 1;
    
    boolean isEmpty(){
        return head == null && tail == null;
    }
    
    int getSize(){
        return size;
    }
    
    String getNum(){
        if (i != 10){
            String num = "0" + Integer.valueOf(i);
            i++;
            return num;
        }else if (i == 10){
            return "10";
        }
        return null;
    }
    
    void add(String data1, int data2){
        Node newNode = new Node(data1, data2);
        if (data2 == 0){
            return;
        }
        if (isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    void bSort() {
        if (size > 1) {
            boolean wasChanged;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.next;
                wasChanged = false;

                while (next != null) {
                    if (current.data2 < next.data2) { 
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.next;

                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next.next;

                            head = next;
                            next.next = current;
                            current.next = sig;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
        
    }

    
    void print(){
        Node temp = head;
        int i = 1;
        System.out.println("=========================================================================");
        System.out.println();
        System.out.println("                              RECEIPTIFY");
        System.out.println("                              This Month");
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println(" NO.  ITEM                                                  TIMES PLAYED");
        System.out.println("-------------------------------------------------------------------------");
        
        if (getSize() <= 10){
            for (int j = 0; j < 10-getSize(); j++){
                while (temp != null) {
                    System.out.printf(" %02d   %-63s %d\n", i, temp.data1, temp.data2);
                    temp = temp.next;
                    i++;
                }
                System.out.printf(" %02d   %-63s %s\n", i, "-", "-");
                i++;
            }
        }else{
            while (temp != null && i != 11) {
                    System.out.printf(" %02d   %-63s %d\n", i, temp.data1, temp.data2);
                    temp = temp.next;
                    i++;
                }
        }
        
    }
}



class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        LinkedList list = new LinkedList();
        
        int n = sc.nextInt();sc.nextLine();
        String command = ""; 
        
        String[] splitted = new String[2]; 
        for (int i = 0; i < n; i++){
            command = sc.nextLine();
            splitted = command.split(" -- ");
            String data1 =  splitted[0];
            int data2 = Integer.parseInt(splitted[1].trim());  
            list.add (data1, data2);
        }
        list.bSort();
        list.print();
    }
}
