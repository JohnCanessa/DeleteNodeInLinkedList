import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInLinkedList {


    /*
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            return "" + this.val;
        }
    }


    /**
     * Delete this node from a singly-linked list.
     * 
     * Execution: O(n) - Space: O(1)
     * 
     * 41 / 41 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 38.3 MB
     */
    static public void deleteNode0(ListNode node) {
        
        // **** initialization ****
        ListNode p = node;

        // **** traverse the linked list - O(n) ****
        while (p != null) {

            // **** copy value from next node ****
            p.val = p.next.val;

            // **** terminate linked list ****
            if (p.next.next == null) p.next = null;

            // **** move to next node ****
            p = p.next;
        }
    }





    /**
     * Delete this node from a singly-linked list.
     * 
     * Execution: O(1) - Space: O(1)
     * 
     */
    static public void deleteNode(ListNode node) {

        // **** copy value from next node ****
        node.val = node.next.val;

        // **** remove the next node in the linked list ****
        node.next = node.next.next;
    }





    /**
     * Test scaffold.
     * !!! NOT PART OF THE SOLUTION !!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read node values ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read value for node to be deleted ****
        int v = Integer.parseInt(br.readLine().trim());

        // **** ****
        br.close();

        // ???? ????
        System.out.println("main <<<    arr: " + Arrays.toString(arr));
        System.out.println("main <<<      v: " + v);

        // **** ****
        ListNode head = null;
        ListNode tail = null;
        ListNode node = null;

        // **** populate linked list ****
        for (int val : arr) {

            // **** create new node ****
            ListNode n = new ListNode(val);

            // **** add node to linked list ****
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }

            // **** remember this node ****
            if (val == v) node = n;
        }

        // ???? ????
        System.out.print("main <<<   head: ");
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val);
            if (p.next != null) System.out.print("->");
        }
        System.out.println();
        System.out.println("main <<<   node: " + node.val);

        // **** call the function of interest ****
        deleteNode(node);

        // **** display output ****
        System.out.print("main <<< output: ");
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val);
            if (p.next != null) System.out.print("->");
        }
        System.out.println();  
    }

}