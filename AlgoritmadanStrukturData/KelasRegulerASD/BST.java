public class BST {
    NodeBST root;

    void insert(NodeBST nodeBaru){
        if(root == null){
            root = nodeBaru;
        }
        else{
            NodeBST temp = root;
            NodeBST temp2 = temp;
            while(temp != null){
                if(nodeBaru.data <= temp.data){
                    temp = temp.kiri;
                }
                else{
                    temp = temp.kanan;
                }
            }
            if(nodeBaru.data <= temp2.data){
                temp2.kiri = nodeBaru;
                nodeBaru.parent = temp2;
            }
            else{
                temp2.kanan = nodeBaru;
                nodeBaru.parent = temp2;
            }
        }
    }

    void search(NodeBST root, int key){
        NodeBST temp = root;
        while(temp != null){
            if(key == temp.data){
                System.out.println("ketemu");
                break;
            }
            else{
                if(key <= temp.data){
                    temp = temp.kiri;
                }
                else{
                    temp = temp.kanan;
                }
            }
            if(temp == null){
                System.out.println("tidak ketemu");
            }
        }
    }

    void inorder(NodeBST node){
        if(node != null){
            inorder(node.kiri);
            System.out.println(node.data + " ");
            inorder(node.kanan);
        }
    }
}

class Run{
    public static void main(String[] args) {
        BST tree = new BST();

        NodeBST n1 = new NodeBST(40);
        NodeBST n2 = new NodeBST(20);
        NodeBST n3 = new NodeBST(60);
        NodeBST n4 = new NodeBST(30);
        NodeBST n5 = new NodeBST(70);

        tree.insert(n1);
        tree.insert(n2);
        tree.insert(n3);
        tree.insert(n4);
        tree.insert(n5);
        tree.inorder(tree.root);
        tree.search(tree.root, 20);
    }
}
