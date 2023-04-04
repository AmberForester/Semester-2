package quiz1;

public class Stack {
    Node top;

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
    }

    void pop(){
        if(isEmpty()){
            System.out.println("Stack Kosong");
        }
        else{
            Node nodePop = top;
            top = top.pointer;
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
        Node temp = new Node();
        temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.pointer;
        }
    }
}
