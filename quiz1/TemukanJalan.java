package quiz1;

public class TemukanJalan {
    int[][] graf;
    int awal;
    int akhir;
    boolean[] lewat;
    Queue[] arrayQueue;
    Stack tumpukan = new Stack();

    public TemukanJalan(int[][] graf, int awal, int akhir) {
        this.graf = graf;
        this.awal = awal;
        this.akhir = akhir;
    }

    void jalanTersedia(){
        this.arrayQueue = new Queue[graf.length];
        for(int i = 0; i < graf.length; i++){
            arrayQueue[i] = new Queue();
            for(int j = 0; j < graf.length; j++){
                if(graf[i][j] == 1){     
                    arrayQueue[i].enqueue(j);                    
                }
            } 
            arrayQueue[i].printQueue();
        }
    }

    boolean belumLewat(int data){
        int[] temp = tumpukan.getStack();
        for (int i : temp) {
            if(i == data && lewat[data]){
                return false;
            }
        }
        return true;
    }
        
    void cari(){
        this.lewat = new boolean[graf.length];
        tumpukan.push(awal);
        lewat[awal] = true;
        for (int i = 0; i < arrayQueue.length; i++) {
            if(graf[awal][i] == 1 && belumLewat(i)){
                arrayQueue[awal].enqueue(i);
            }
        }
        while(tumpukan.peek() != akhir){    
            int sekarang = tumpukan.peek();
            lewat[sekarang] = true;
            if(!arrayQueue[sekarang].isEmpty()){
                int lanjut = arrayQueue[sekarang].dequeue();
                if(!lewat[lanjut]){
                    lewat[lanjut] = true;
                    tumpukan.push(lanjut);
                    for (int i = 0; i < arrayQueue.length; i++) {
                        if(graf[lanjut][i] == 1 && belumLewat(i)){
                            arrayQueue[lanjut].enqueue(i);
                        }
                    }
                }
            }
            else{
                tumpukan.pop();
            }    
        }
    }
}




