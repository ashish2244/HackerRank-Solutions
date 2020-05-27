import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode t=head;
        DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
        /*INSERING AT Beg. if it is empty */
        if (head == null) {
        head = newNode;
        return head;
        }
       
        while(head.next!=null){
            if(newNode.data<=head.data){
                newNode.next=head;
                head.prev=newNode;
               
                return newNode;
            }
            if(newNode.data<=head.next.data){
                newNode.next=head.next;
                head.next.prev=newNode;
                head.next=newNode;
                newNode.prev=head;
                return t;
            }
            
            head=head.next;
        }
        /*INSERING AT END */
        head.next=newNode;
        newNode.prev=head;
        return t;


    }

    private static final Scanner scanner = new Scanner(System.in);