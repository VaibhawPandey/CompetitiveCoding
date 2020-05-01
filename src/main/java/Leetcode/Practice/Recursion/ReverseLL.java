package main.java.Leetcode.Practice.Recursion;

public class ReverseLL {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        int arr[] = {};
        ListNode lastNode = null , currNode = null, head = null;
        for (int i = 0; i < arr.length; i++) {
            if (currNode != null)
                lastNode = currNode;
            currNode = new ListNode(arr[i]);
            currNode.next = null;
            if( lastNode != null)
                lastNode.next = currNode;
            else
                head = currNode;
        }
        ListNode revHead = reverseList(head);
        while (revHead != null) {
            System.out.print(revHead.val + "-->");
            revHead = revHead.next;
        }
    }
    static ListNode resHead = null, recLastNode = null, recCurrNode = null;
    public static ListNode reverseList(ListNode head) {


       reverseListRec(head);
       return resHead;
    }

    private static void reverseListRec(ListNode head) {

        if (head == null)
            return;

        reverseListRec(head.next);
        if (recCurrNode != null)
            recLastNode = recCurrNode;

        recCurrNode = new ListNode(head.val);
        recCurrNode.next = null;
        if (recLastNode == null)
            resHead = recCurrNode;
        else recLastNode.next = recCurrNode;
    }
}
