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

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode t=head1;
        SinglyLinkedListNode f=head2;
        int count=0;
        int diff=0;
        int count2=0;
        while(t!=null)
        {
            count++;
            t=t.next;
        }
        while(f!=null)
        {
            count2++;
            f=f.next;
        }

    
        diff=count2-count;
        if(count>count2){
            SinglyLinkedListNode temp=head1;
            head1=head2;
            head2=temp;
            diff=count-count2;
        }
        for(int i=0;i<diff;i++)
        {
            head2 =head2.next;
        }
         while(head1 != null && head2 != null) {
        if(head1== head2) {
            return head1.data;
        }
        head1 = head1.next;
        head2 = head2.next;
    }
    return 0;   
          

    }

    private static final Scanner scanner = new Scanner(System.in);