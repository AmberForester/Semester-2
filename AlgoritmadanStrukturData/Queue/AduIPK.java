package Queue;
import java.util.Scanner;

class NodeAdu{
    String data;
    float nilai;
    NodeAdu next; 
    
    public NodeAdu(){}
    
    public NodeAdu(String dataBaru, float nilai){
        this.data = dataBaru;
        this.nilai = nilai;
        next = null;
    }
}

class Queue{
    NodeAdu depan;
    NodeAdu belakang;
    int size;
    
    boolean isEmpty(){
        return depan == null;
    }
    
    void enqueue(String dataBaru, float nilaiAkhir){
        NodeAdu nodeBaru = new NodeAdu(dataBaru, nilaiAkhir);
        NodeAdu temp = depan;
        if(isEmpty()){
            depan = belakang = nodeBaru;
        }
        else if(size == 1){
            if(temp.nilai < nodeBaru.nilai){
            nodeBaru.next = depan;
            depan = nodeBaru;
            }
            else if(temp.nilai > nodeBaru.nilai){
            belakang.next = nodeBaru;
            belakang = nodeBaru;
            }
            // else{
            // depan.next = nodeBaru;
            // belakang = nodeBaru; 
            // }
        }
        else{
            if(temp.nilai < nodeBaru.nilai){
                nodeBaru.next = depan;
                depan = nodeBaru;
            }
            else if(belakang.nilai > nodeBaru.nilai){
                belakang.next = nodeBaru;
                belakang = nodeBaru;
            }
            else{
                NodeAdu temp2 = depan;
                while(temp2.next != null && temp2.next.nilai >= nodeBaru.nilai){ 
                    temp2 = temp2.next;
                }        
                nodeBaru.next = temp2.next;
                temp2.next = nodeBaru;
            }
        }     
        size++;
    }
    
    void dequeue(){
        if(!isEmpty()){
            depan = depan.next;
            // Node temp = new Node();
            // temp = depan;
            // while(temp.pointer == belakang){
            //     temp = temp.pointer;
            // }
            // ekor = temp;
        }
        else if(size == 1){
            depan = belakang = null;
        }
        size--;
    }
    
    void printQueue(){
        NodeAdu temp = new NodeAdu();
        temp = depan;
        int i = 1;
        while(temp != null){
            System.out.println(i + ". " + temp.data + " (" + temp.nilai + ")");
            temp = temp.next;
            i++;
        }
    }
}

public class AduIPK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        int banyakList = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < banyakList; i++){
            String namaMhs = sc.next();
            float nilaiAwal = sc.nextFloat();
            int sertif = sc.nextInt();
            float nilaiAkhir = 0;
            if(sertif == 1){
                nilaiAkhir = nilaiAwal + (float)0.2;
            }
            else{
                nilaiAkhir = nilaiAwal;
            }           
            antrian.enqueue(namaMhs, nilaiAkhir);
        }
        antrian.printQueue();
   }
}

