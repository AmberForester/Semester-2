package PraktikumASD;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class User {
    String namaPengguna;
    ArrayList<User> diikuti;
    ArrayList<User> pengikut;
    
    public User(){}
    
    public User(String namaPengguna) {
        this.namaPengguna = namaPengguna;
        this.diikuti = new ArrayList<>();
        this.pengikut = new ArrayList<>();
    }
}

class Graph {
    ArrayList<User> daftarPengguna = new ArrayList<>();
    int size = 0;
    
    public void addPengguna(String namaPengguna) {
        daftarPengguna.add(new User(namaPengguna));
    }

    public User getPengguna(String namaPengguna) {
        for (User user : daftarPengguna) {
            if (user.namaPengguna.equals(namaPengguna)) {
                return user;
            }
        }
        return null;
    }

    public void ikuti(String namaPengguna1, String namaPengguna2) {
        User pengguna1 = getPengguna(namaPengguna1);
        User pengguna2 = getPengguna(namaPengguna2);

        if (pengguna1 != null && pengguna2 != null) {
            if(!namaPengguna1.equalsIgnoreCase(namaPengguna2)){
                pengguna1.diikuti.add(pengguna2);
                pengguna2.pengikut.add(pengguna1);
            }
        } 
        else {
            System.out.println("User tidak ditemukan.");
        }
    }

    public void getConnections(String namaPengguna) {
        User user = getPengguna(namaPengguna);
        System.out.println(user.namaPengguna + "'s followings :");
        for (User u : daftarPengguna) {
            for(User p : user.diikuti){
                if(p.namaPengguna.equals(u.namaPengguna)){
                    System.out.println(" " + p.namaPengguna);
                }    
            }  
        }
        
        System.out.println(user.namaPengguna + "'s followers :");
        for (User u : daftarPengguna) {
            for(User p : user.pengikut){
                if(p.namaPengguna.equals(u.namaPengguna)){
                    System.out.println(" " + p.namaPengguna);
                }    
            }  
        }
    }
        


    public void getAllConnections() {
        for (User user : daftarPengguna) {
            // System.out.println(user.namaPengguna + "'s followings:");
            // for (User diikuti : user.diikuti) {
            //     System.out.println(" " + diikuti.namaPengguna);
            // }

            // System.out.println(user.namaPengguna + "'s followers:");
            // for (User pengikut : user.pengikut) {
            //     System.out.println(" " + pengikut.namaPengguna);
            // }
            //     System.out.println(user.namaPengguna + "'s followings :");
            // for(int i = user.diikuti.size()-1; i >= 0; i--){
            //     System.out.println(" " + user.diikuti.get(i).namaPengguna);
            // }
            // System.out.println(user.namaPengguna + "'s followers :");
            // for(int i = user.pengikut.size()-1; i >= 0; i--){
            //     System.out.println(" " + user.pengikut.get(i).namaPengguna);
            // }
            // System.out.println();
            getConnections(user.namaPengguna);
            System.out.println();

        }
    }
}

public class Filgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah = sc.nextInt();
        sc.nextLine(); // Read the newline character

        Graph graphGokil = new Graph();

        for (int i = 0; i < jumlah; i++) {
            String nama = sc.nextLine();
            graphGokil.addPengguna(nama);
        }

        int M = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < M; i++) {
            String perintah = sc.nextLine();
            String[] pisah = perintah.split(" ");
            
            switch(pisah[1]){
                case "follow":
                    graphGokil.ikuti(pisah[0], pisah[2]);
                    break;
                case "connections":
                    if (pisah[0].equals("all")) {
                    graphGokil.getAllConnections();
                    } 
                    else {
                    graphGokil.getConnections(pisah[0]);
                    }
            }
        }

        sc.close();
    }
}

