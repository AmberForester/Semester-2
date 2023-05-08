package PemrogramanBerorientasiObjek.KelasRegulerPBO;

import java.util.*;
public class PriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        q.add("Hadi");
        q.add("Putra");
        q.add("Farel");
        q.add("Gustav");

        System.out.println("head: " + q.element());
        System.out.println("head: " + q.peek());
        System.out.println();
        System.out.println("iterating the queue elements: ");

        Iterator itr = q.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        q.remove();
        q.poll();

        System.out.println();
        System.out.println("After removing two elements: ");
        Iterator itr2 = q.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
        q.add("Javed");
        q.add("Ervan");

        System.out.println();
        Iterator itr3 = q.iterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }

    }
}
