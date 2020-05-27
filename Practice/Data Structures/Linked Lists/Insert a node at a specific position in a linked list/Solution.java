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

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
         SinglyLinkedListNode p,t;
         p=head;
        SinglyLinkedListNode newNode=new SinglyLinkedListNode(data);
/*YOU CAN UNCOMMENT ALL THE BELOW COMMENTED LINE FOR BETTER CODING PRACTICE*/
        // if(head==null &&position==0)
        // head=newNode;
        // else
        //  if(head==null &&position!=0)
        // head=null;
        // else 
        // if(position==0)
        // {
        //      newNode.next=p;
        //     head=newNode;
        // }
        // else
        // {
            int count=0;
            while(p.next!=null){
                count++;
                if(count==position)
                    break;
                p=p.next;
            }
            t=p.next;
            p.next=newNode;
            newNode.next=t;
        // }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);