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

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
    if (headA == null && headB == null) return null;
    else if (headA == null) return headB;
    else if (headB == null) return headA;
    SinglyLinkedListNode s=null;

    if(headA!=null && headB!=null)
    {
        if(headA.data<headB.data){
            s=headA;
            headA=headA.next;
        }
        else{
            s=headB;
            headB=headB.next;
        }
    }
    SinglyLinkedListNode newHead=s;
    while(headA!=null && headB!=null)
    {
        if(headA.data<headB.data){
            s.next=headA;
            s=headA;
            headA=headA.next;
        }
        else{
            s.next=headB;
            s=headB;
            headB=headB.next;
        }
    }
    if(headA==null)s.next=headB;
    if(headB==null)s.next=headA;
    return newHead;
    }

    private static final Scanner scanner = new Scanner(System.in);