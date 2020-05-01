package main.java.Leetcode.Practice.Recursion.PrincipleofRecursion;


public class SwapNode {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        int arr[] = {1};
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
        ListNode revHead = swapPairs(head);
        while (revHead != null) {
            System.out.print(revHead.val + "-->");
            revHead = revHead.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {

        ListNode currNode = null, nextNode = null, resHead = null;
        boolean isHead = true;
        while (head != null || (head!=null && isHead)) {
            if (head.next == null){
                currNode = new ListNode(head.val);
                currNode.next = null;
                if(nextNode != null)
                nextNode.next = currNode;
                if (isHead)
                    resHead = currNode;
                break;
            }
            currNode = new ListNode(head.next.val);
            if(nextNode != null)
                nextNode.next = currNode;
            nextNode = new ListNode(head.val);
            nextNode.next = null;
            currNode.next = nextNode;
            if (isHead)
                resHead = currNode;
            isHead = false;
            head = head.next.next;
        }
        return resHead;
    }
}
