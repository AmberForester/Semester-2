package quiz1;

class Queue {
    Node depan;
    Node belakang;
    int size;

    boolean isEmpty(){
        return depan == null;
    }

    public void enqueue(int data){
        Node nodeBaru = new Node(data);
        if(isEmpty()){
            depan = belakang = nodeBaru;
        }
        else{
            belakang.pointer = nodeBaru;
            belakang = nodeBaru;
        }
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            return 0;
        }
        else{
            int data = depan.data;
            depan = depan.pointer;
            size--;
            return data;
            
        }
    }

    public void printQueue(){
        Node temp = depan;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.pointer;
        }
        System.out.println();
    }
}
// class coba{
//     public static void main(String[] args) {
//         Queue coba = new Queue();
//         coba.enqueue(1);
//         coba.enqueue(3);
//         coba.dequeue();
//         coba.printQueue();
//     }
// }

