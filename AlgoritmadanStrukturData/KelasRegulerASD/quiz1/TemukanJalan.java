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
        // arrayQueue[awal] = new Queue();
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

    void cari(){
        // Node pertama = new Node(awal);
        this.lewat = new boolean[graf.length];
        tumpukan.push(awal);
        lewat[awal] = true;  
        //int i = 0;
        while(tumpukan.top.data != akhir){
            
            int sekarang = tumpukan.peek();
            tumpukan.push(sekarang);
            lewat[sekarang] = true;
           
        //  i++;
        }
        // if(tumpukan.top.data != akhir){
        //     for(int i = 0; i < graf.length; i++){
        //         int sekarang = arrayQueue[i].dequeue();
        //         tumpukan.push(sekarang);
        //         if()
        //         // if(tumpukan.top.data == akhir){
        //         //     break;
        //         // }
        //     }
        // }
        // Node tujuan = new Node(akhir);
        tumpukan.push(akhir);
    }
}




