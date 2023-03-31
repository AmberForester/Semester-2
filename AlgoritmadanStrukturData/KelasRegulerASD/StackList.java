
class NodeStack{
    String data;
    NodeStack under;

    public NodeStack(String data) {
        this.data = null;
    }
}

public class StackList {
    NodeStack top;
    int size;

    boolean isEmpty(){
    return top == null;
    }

    void makeEmpty(){
        top = null;
    }

    void push(String dataBaru){
        NodeStack nodeBaru = new NodeStack(dataBaru);
        if(isEmpty()){
            top = nodeBaru;
            size++;
        }
        else{
            nodeBaru = top.under;
            top = nodeBaru;
        }
    }

    String peek(){
        return (isEmpty())? "Stack Kosong" : top.data;
    }

    String pop(){
        if(isEmpty()){
            return "Stack Kosong";
        }
        else{
            String data = top.data;
            top = top.under;
            size--;
            return data;
        }
    }
}
