package com.ag.heaps;

import com.ag.heaps.MergeSortedLists.ListNode;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Objects.isNull;

public class MergeSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfll = sc.nextInt();
        int[] lls = new int[noOfll];
        for (int i = 0; i < noOfll; i++) {
            lls[i] = sc.nextInt();
        }

        ArrayList<ListNode> A = new ArrayList<>();
        for (int llSize : lls) {
            ListNode head = null, curr = null;
            for (int j = 0; j < llSize; j++) {
                int num = sc.nextInt();
                ListNode node = new ListNode(num);
                if (isNull(head)) {
                    head = node;
                    curr = node;
                }else{
                    curr.next = node;
                    curr = curr.next;
                }

            }
            A.add(head);
        }

        MergeSortedLists mergell = new MergeSortedLists();
        mergell.mergeKLists(A);
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        pq.addAll(a);

        ListNode head = null, curr = null;
        while(!pq.isEmpty()){
            ListNode node =pq.poll();
            if(isNull(head)){
                head = node;
                curr = node;
            }else{
                curr.next = node;
                curr = curr.next;
            }
            if(!isNull(node.next)){
                pq.offer(node.next);
            }
        }

        return head;
    }
}
