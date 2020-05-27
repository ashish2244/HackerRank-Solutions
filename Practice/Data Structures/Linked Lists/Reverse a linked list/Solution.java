import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

/* One way ______
SinglyLinkedListNode prev=null;
        SinglyLinkedListNode curr=head;
        SinglyLinkedListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;*/
// same as above but more lines of codes
        if(head.next.next==null)
        {
            SinglyLinkedListNode p=head;
            p.next=null;
            head=head.next;
            head.next=p; 
            return head; 
        }
        else if(head.next==null)
        return head;
        else{
            SinglyLinkedListNode prev,curr,next;
            prev=head;
            curr=head.next;
            next=head.next.next;
            prev.next=null;
            while(next!=null)
            {
                curr.next=prev;
                prev=curr;
                curr=next;
                next=next.next;

            }
            curr.next=prev;
             head=curr;
        }
        
        return head;



    }

    private static final Scanner scanner = new Scanner(System.in);