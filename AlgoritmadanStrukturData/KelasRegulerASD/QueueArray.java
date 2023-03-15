
public class QueueArray{
    int front;
    int rear;
    int[] antrean;
    int arraySize;

    public QueueArray(int arraySize){
        this.arraySize = arraySize;
        antrean = new int[arraySize];
        front = 0;
        rear = -1;
    }

    public boolean isFull(){
        return rear == arraySize-1;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public void enqueue(int value){
        if(!isFull()){
            rear++;
            antrean[rear] = value;
        }
        else{
            System.out.println("Antrean Penuh");
        }
    }

    public int dequeue(){
        
        if(!isEmpty()){
            int temp = antrean[front];
            for(int i = 0; i <= rear-1; i++){
                antrean[i] = antrean[i+1];
            }
            rear--;
            return temp;
        }
        else{
            System.out.println("Amtrean Kosong");
            return -1;
        }        
        
    }
    
    public void printQueue(){
        for(int i = 0; i <= rear; i++){
            System.out.print(antrean[i] + " ");
        }
    }
}

class RunQueueArray{
    public static void main(String[] args) {
        QueueArray ant = new QueueArray(5);
        ant.enqueue(1);
        ant.enqueue(2);
        ant.enqueue(3);
        ant.enqueue(4);
        ant.dequeue();
        ant.printQueue();
    }
}
