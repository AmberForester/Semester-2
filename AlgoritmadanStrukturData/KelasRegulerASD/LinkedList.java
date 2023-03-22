public class LinkedList {
    NodeSingle kepala;
    NodeSingle ekor;
    int size;

    public LinkedList(){
        this.kepala = null;
        this.ekor = null;
    }

    public void add(int nilai){
        NodeSingle temp = new NodeSingle();
        temp.data = nilai;
        size++;
        addLast(temp);
    }

    public void addFirst(NodeSingle nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            nodeBaru.pointer = kepala;
            kepala = nodeBaru;
        }
        size++;
    }

    public void addLast (NodeSingle nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            ekor.pointer = nodeBaru;
            ekor = nodeBaru;
            ekor.pointer = null;
        }
        size++;
    }

    public void addAfter(int key, NodeSingle nodeBaru){
        NodeSingle temp = kepala;
        while (temp != null){
            if (key == temp.data){
                nodeBaru.pointer = temp.pointer;
                temp.pointer = nodeBaru;
                size++;
                break;
            }
            temp = temp.pointer;
        }
        size++;
    }

    public int get(int index){
        NodeSingle temp = kepala;
        if (index<size){
            for (int i = 0; i < index; i++) {
                temp = temp.pointer;
            }
            return temp.data;
        } else {
            return -1;
        }
        
        
    }

    public void print() {
        NodeSingle temp = kepala;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.pointer;

        }
    }

    public void deleteFirst(){
        if (kepala != null){
            kepala = kepala.pointer;
        }
        size--;
    }

    public void deleteLast(){
        if (kepala != null){
            NodeSingle temp = kepala;
            while(temp.pointer!=ekor){
                temp = temp.pointer;
            }
            ekor = temp;
            ekor.pointer = null;
        } else {
            kepala = ekor = null;
        }
        size--;
    }
}
