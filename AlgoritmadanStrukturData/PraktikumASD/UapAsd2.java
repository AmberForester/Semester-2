package PraktikumASD;
import java.util.*;

class Node {
    private String nama;
    private List<Edge> edges;
    private int jarak;
    private Node sebelum;

    public Node(String nama) {
        this.nama = nama;
        edges = new ArrayList<>();
        jarak = Integer.MAX_VALUE;
        sebelum = null;
    }

    public String getNama() {
        return nama;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Node tujuan, int weight) {
        Edge edge = new Edge(tujuan, weight);
        edges.add(edge);
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int distance) {
        this.jarak = distance;
    }

    public Node getSebelum() {
        return sebelum;
    }

    public void setSebelum(Node previous) {
        this.sebelum = previous;
    }
}

class Edge {
    private Node tujuan;
    private int weight;

    public Edge(Node tujuan, int weight) {
        this.tujuan = tujuan;
        this.weight = weight;
    }

    public Node getTujuan() {
        return tujuan;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph {
    private List<Node> nodes = new ArrayList<>();

    public void setKota(Node kota) {
        nodes.add(kota);
    }

    public Node getKota(String nama) {
        return nodes.get(nama.charAt(0) - 'A');
    }

    public void computeShortestPaths(Node source) {
        source.setJarak(0);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getJarak));
        pq.addAll(nodes);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Edge e : curr.getEdges()) {
                Node kedekatan = e.getTujuan();
                int jarakBaru = curr.getJarak() + e.getWeight();

                if (jarakBaru < kedekatan.getJarak()) {
                    pq.remove(kedekatan);
                    kedekatan.setJarak(jarakBaru);
                    kedekatan.setSebelum(curr);
                    pq.add(kedekatan);
                }
            }
        }
    }

    public List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        Node a = target;
        while (a != null) {
            path.add(0, a);
            a = a.getSebelum();
        }

        // for (Node node = target; node != null; node = node.getSebelum()) {
        //     path.add(0, node);
        // }
        return path;
    }
}

public class UapAsd2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Membuat node dari A hingga H
        for (int i = 0; i < 8; i++) {
            char name = (char) ('A' + i);
            Node newNode = new Node(String.valueOf(name));
            graph.setKota(newNode);
        }

        // Input nama destinasi dan banyak edge yang dibuat
        String destination = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();

        // Looping menginput edge
        for (int i = 0; i < n; i++) {
            String edgesInput = scanner.nextLine();
            String[] edges = edgesInput.split(" ");
            String namaAsal = edges[0];
            String namaTujuan = edges[1];
            int weight = Integer.parseInt(edges[2]);

            Node kotaAsal = graph.getKota(namaAsal);
            Node kotaTujuan = graph.getKota(namaTujuan);

            kotaAsal.addEdge(kotaTujuan, weight);
            kotaTujuan.addEdge(kotaAsal, weight);
        }

        // Mencari rute terdekat
        graph.computeShortestPaths(graph.getKota("A"));
        Node destinationNode = graph.getKota(destination);
        List<Node> path = graph.getShortestPathTo(destinationNode);

        // Mencetak rute dan jarak ke kota tujuan
        for (Node node : path) {
            System.out.print(node.getNama() + " ");
        }
        System.out.println();
        System.out.println(destinationNode.getJarak());
    }
}
