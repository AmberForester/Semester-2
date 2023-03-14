

public class RunDouble {
    public static void main(String[] args) {
        DoubleLinkedList barisan = new DoubleLinkedList();

        NodeDouble node1 = new NodeDouble();
        node1.data = 5;
        barisan.addFirst(node1);

        NodeDouble node2 = new NodeDouble();
        node2.data = 10;
        barisan.addFirst(node2);

        barisan.print();
    }
    
}
