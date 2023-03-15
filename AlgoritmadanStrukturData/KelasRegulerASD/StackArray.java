
public class StackArray {
    public int top;
    public int[] tumpukan;
    public int arraySize;
    
    public StackArray(int arraySize){
        this.arraySize = arraySize;
        tumpukan = new int[arraySize];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1; 
        // if(top == -1) {
        //     return true;
        // } 
        // else{
        //     return false;
        // }  
    }

    public boolean isFull(){
        if(top == this.arraySize-1) {
            return true;
        } 
        else{
            return false;
        }
        // return top == this.arraySize-1; 
    }

    public void push(int value){
        if(!isFull()){
            top++;
            tumpukan[top] = value;
        }
        else{
            System.out.println("Stack Penuh");
        }
    }

    public void printStack(){
        for(int i = top; i >= 0; i--){
            System.out.println(tumpukan[i]);
        }
    }

    public int pop(){
        int temp = -1;
        if(!isEmpty()){
            temp = tumpukan[top];
            top--;
        }
        else{
            System.out.println("Stack is empty");
        }
        return temp;
    }
}

class RunStackArray{
    public static void main(String[] args) {
        StackArray tumpukanArray = new StackArray(5);
        tumpukanArray.push(100);
        tumpukanArray.push(200);
        tumpukanArray.push(300);
        int ambil = tumpukanArray.pop();
        System.out.println("Terambil: " + ambil);
        tumpukanArray.printStack();

    }
}


