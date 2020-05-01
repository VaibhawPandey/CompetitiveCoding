package main.java.Leetcode.Chal30days.Week2;

public class MiddleLL {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};
        ListNode currNode = null, lastNode = null, head = null;
        for (int i = 0; i < arr.length; i++) {
             if (currNode != null)
                 lastNode = currNode;

             currNode = new ListNode(arr[i]);
             currNode.next = null;

             if (lastNode == null){
                 head = currNode;
             } else {
                 lastNode.next = currNode;
             }
        }
        ListNode output = middleNode(head);
        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }

    }
    public static ListNode middleNode(ListNode head) {

        ListNode fast = head, slow = head;
        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
