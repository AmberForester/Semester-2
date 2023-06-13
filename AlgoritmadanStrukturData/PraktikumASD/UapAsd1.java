package PraktikumASD;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.swing.text.html.HTMLDocument.RunElement;

class Node {
    Node prev;
    Node next;
    String artist;
    String judul;

    Node(String artist, String judul) {
        this.artist = artist;
        this.judul = judul;
    }
}

class DoubleLinkedListScratch {
    Node kepala;
    Node ekor;
    Node state;

    int length = 0;

    boolean isEmpty() {
        return kepala == null || ekor == null;
    }

    void addSong(Node nodeBaru) {
        if(isEmpty()){
            kepala = ekor = state = nodeBaru;
        }
        else{
            ekor.next = nodeBaru;
            nodeBaru.prev = ekor;
            ekor = nodeBaru;
        }
        length++; 
    }

    void printPlaylist() {
        Node temp = kepala;
        while (temp != null) {
            System.out.println("Artist: " + temp.artist + " | Judul: " + temp.judul);
            temp = temp.next;
        }
    }

    void playPlaylist() {
        if(isEmpty()){
            System.out.println("No song to pick from waiting list!");
            return;
        } 
        System.out.println("Now Playing:\nArtist: " + state.artist + " | Judul: " + state.judul);
        
    }

    void printCurrentPlay() {
        if (this.state == null) {
            return;
        } else System.out.println("Now Playing:\nArtist: " + state.artist + " | Judul: " + state.judul);
    }

    void toNextSong() {
        if (this.state.next == null) {
            System.out.println("Cannot go to next song, no song specified in playlist!");
        }
        else{
            state = state.next;
            System.out.println("Now Playing:\nArtist: " + state.artist + " | Judul: " + state.judul);
        } 
    }

    void toPreviousSong() {
        if (this.state.prev == null) {
            System.out.println("Cannot go to preivous song, no song specified in playlist!");
        } 
        else{
            state = state.prev;
            System.out.println("Now Playing:\nArtist: " + state.artist + " | Judul: " + state.judul);
        }
    }
}

class QueueScratch {
    Node depan;
    Node belakang;
    int length = 0;

    boolean isEmpty(){
        return depan == null && belakang == null;
    }
    void addSong(Node nodeBaru) {
        if(isEmpty()){
            depan = belakang = nodeBaru;
        }
        else{
            belakang.next = nodeBaru;
            nodeBaru.prev = belakang;
            belakang = nodeBaru;
        }
        length++; 
    }

    Node deQueue() {
        if (length == 0) {
            System.out.println("No song to pick from waiting list!");
            return null;
        }
        else{
            depan = depan.next;
            length--;
            return depan;
        } 
    }

    void printWaitingList() {
        Node temp = depan;
        System.out.println("Waiting List:");
        for (int i = 0; i < length; i++) {
            System.out.println("Artist: " + temp.artist + " | Judul: " + temp.judul);
            temp = temp.next;
        }
    }
}

public class UapAsd1 {
    public static void main(String args[] ) throws Exception {
        DoubleLinkedListScratch playlist = new DoubleLinkedListScratch();
        QueueScratch waitingList = new QueueScratch();
        Scanner in = new Scanner(System.in);

        int totalActions = in.nextInt();
        in.nextLine();
        for (int action = 0; action < totalActions; action++) {
            String actionIndicator = in.nextLine();
            if (actionIndicator.equals("ADDSONG"))
                playlist.addSong(new Node(in.nextLine(), in.nextLine()));
            if (actionIndicator.equals("PLAYSONG"))
                playlist.playPlaylist();
            if (actionIndicator.equals("NEXTSONG"))
                playlist.toNextSong();
            if (actionIndicator.equals("PREVSONG"))
                playlist.toPreviousSong();
            if (actionIndicator.equals("PRINTSONG"))
                playlist.printCurrentPlay();
            if (actionIndicator.equals("PRINTPLAYLIST"))
                playlist.printPlaylist();
            if (actionIndicator.equals("ADDWAIT"))
                waitingList.addSong(new Node(in.nextLine(), in.nextLine()));
            if (actionIndicator.equals("ADDSONGWAIT"))
                playlist.addSong(waitingList.deQueue());
            if (actionIndicator.equals("PRINTWAIT"))
                waitingList.printWaitingList();
        }
    }
}



