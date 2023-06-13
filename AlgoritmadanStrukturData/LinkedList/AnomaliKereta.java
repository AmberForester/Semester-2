package LinkedList;

import java.util.*;

class Gerbong {
  int penumpang;
  int dewasa;
  int anak;
  Gerbong next;

  Gerbong(int dewasa, int anak) {
    this.penumpang = dewasa + anak;
    this.dewasa = dewasa;
    this.anak = anak;      
  }
}

class LinkedList {
  Gerbong head;
  Gerbong tail;

    void addLast(int dewasa, int anak) {
        Gerbong gerbongBaru = new Gerbong(dewasa,anak);
        if(head == null){
            head = tail = gerbongBaru;
        }
        else{
            tail.next = gerbongBaru;
            tail = gerbongBaru; 
            
        }      
    }

    void reverse(){
        Gerbong temp = head;
        Gerbong current = null;
        Gerbong prev = null;
        
        while(temp != null){
            current = temp;
            temp = temp.next;
            
            current.next = prev;
            prev = current;
            head = current;
            
        }
    }
  
    void deleteNode(int data){
        Gerbong temp = head;
            if(head!=null&&tail!=null){
            while(temp!=null){
                if(temp.next.penumpang==data){
                    temp.next = temp.next.next;
                    if(temp.next==null)
                        tail = temp;
                        break;
                }
                else if(temp.penumpang==data&&temp==head){
                    if(head.next == null) {
                        head = tail = null;
                        return;
                    }
                    head = head.next;
                    break;
                }
                temp = temp.next;
            }
        }       
    }
    void printList(){
        Gerbong temp = head;
        while(temp != null){
            System.out.print("[" + temp.dewasa + ", " + temp.anak + "]");
            if(temp.next != null){
                System.out.print("-");
                
            }
         temp = temp.next;   
        }
        
    }
}

public class AnomaliKereta {

  public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      LinkedList coba = new LinkedList();
      int totalGerbong = sc.nextInt();
      for(int i = 0; i < totalGerbong; i++){
        coba.addLast(sc.nextInt(), sc.nextInt());
      }
      
      int data = sc.nextInt();
      coba.deleteNode(data);
      coba.reverse();
      coba.printList();
          
  }
}

