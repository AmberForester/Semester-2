package AlgoritmadanStrukturData.PraktikumASD;
import java.util.Scanner;

class NodeDLL2 {
    NodeDLL2 next;
    NodeDLL2 prev;
    String data;

    NodeDLL2() {
    }

    NodeDLL2(String newData) {
        this.next = next;
        this.prev = prev;
        this.data = newData;
    }
}

class DLL2 {
    NodeDLL2 kepala;
    NodeDLL2 ekor;
    int size;

    boolean isEmpty() {
        return kepala == null && ekor == null;
    }

    int getSize() {
        return size;
    }

    void addFirst(String newData) {
        NodeDLL2 nodeBaru = new NodeDLL2(newData);
        if(isEmpty()){
            kepala = ekor = nodeBaru;
        }
        else{
            nodeBaru.next = kepala;
            kepala.prev = nodeBaru;
            kepala = nodeBaru;
        }
        this.size++;
    }

    void addLast(String newData) {
        NodeDLL2 nodeBaru = new NodeDLL2(newData);
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

    void removeFirst() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(getSize() == 1){
            kepala = ekor = null;  
        }
        else{
            kepala = kepala.next;
            kepala.prev.next = null;
            kepala.prev = null;
        }
        size--;
    }

    void removeLast() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(getSize() == 1){
            kepala = ekor = null;  
        }
        else{
            ekor = ekor.prev;
            ekor.next.prev = null;
            ekor.next = null;
        }
        size--;
    }

    void addAtIndex(int targetIndex, String newData) {
        NodeDLL2 nodeBaru = new NodeDLL2(newData);
        NodeDLL2 temp = kepala;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(getSize() < targetIndex){
            System.out.println("Index tidak valid.");
        }
        else if(targetIndex == 0){
            this.addFirst(newData);
        }
        else if(targetIndex == getSize()){
            this.addLast(newData);
        }        
        else{
            for(int i = 0; i < targetIndex; i++){
                temp = temp.next;
            }
//             nodeBaru = temp.prev;
//             temp.prev.next = nodeBaru;
//             nodeBaru.next = temp;
//             temp.prev = nodeBaru;
            
            nodeBaru.next = temp;
            nodeBaru.prev = temp.prev;
            temp.prev.next = nodeBaru;
            temp.prev = nodeBaru;
            this.size++;
        }        
    }

    void removeTarget(String targetData) {
        NodeDLL2 temp = kepala;        
        while(temp != null && !temp.data.equalsIgnoreCase(targetData)){
            temp = temp.next;
        }
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else if(temp == kepala){
            this.removeFirst();
        }
        else if(temp == ekor){
            this.removeLast();
        }
        else{
            if(temp == null){
                System.out.println("Data tidak ada!");
            }
            else{
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                this.size--;
            }            
        }        
    }

    void printForward() {
       NodeDLL2 temp = new NodeDLL2();
        temp = kepala;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else{
            while(temp != null){
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println();
        } 
    }

    void printBackward() {
        NodeDLL2 temp = new NodeDLL2();
        temp = ekor;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }
        else{
            while(temp != null){
                System.out.print(temp.data + " <--> ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }
}

public class SalahKetik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DLL2 dll = new DLL2();

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toUpperCase().equals("ADD")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.addFirst(splitted[2]);
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.addLast(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("REMOVE")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.removeFirst();
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.removeLast();
                } else if (splitted[1].toUpperCase().equals("TARGET")) {
                    dll.removeTarget(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("INDEX")) {
                dll.addAtIndex(Integer.valueOf(splitted[1]), splitted[2]);
            } else if (splitted[0].toUpperCase().equals("PRINT")) {
                if (splitted[1].toUpperCase().equals("FWD")) {
                    dll.printForward();
                } else if (splitted[1].toUpperCase().equals("BWD")) {
                    dll.printBackward();
                }
            }
        }
    }
}
