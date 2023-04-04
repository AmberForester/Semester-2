package quiz1;

public class Stack {
    Node top;
    int size;

    boolean isEmpty(){
        return top == null;
    }

    void push(int data){
        Node nodeBaru = new Node(data);
        if(isEmpty()){
            top = nodeBaru;
        }
        else{
            nodeBaru.pointer = top;
            top = nodeBaru;
        }
        size++;
    }

    void pop(){
        if(isEmpty()){
            System.out.println("Stack Kosong");
        }
        else{
            Node nodePop = top;
            top = top.pointer;
            size--;
        }
    }

    int peek(){
        if(isEmpty()){
            return 0;
        }
        else{
            return top.data;
        }
    }

    void PrintStack(){
        Node[] balik = new Node[size];
        Node temp = new Node();
        temp = top;
        int i = size-1;
        while(temp != null){
            balik[i] = temp;
            temp = temp.pointer;
            i--;
        }
        for (int j = 0; j < balik.length; j++) {
            if(j == balik.length-1){
                System.out.print(balik[j].data);
                
            }
            else{
                System.out.print(balik[j].data + " --> ");
            }
            
        }
        // while(temp != null){
        //     System.out.print(temp.data + " --> ");
        //     temp = temp.pointer;
        // }
    }

    int[] getStack(){
        int[] array = new int[size];
        int i = 0;
        Node temp = top;
        while(temp != null){
            array[i] = temp.data;
            temp = temp.pointer;
            i++;
        }
        return array;
    }
}
