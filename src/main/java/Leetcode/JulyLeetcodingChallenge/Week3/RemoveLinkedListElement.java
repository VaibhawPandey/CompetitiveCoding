package main.java.Leetcode.JulyLeetcodingChallenge.Week3;

public class RemoveLinkedListElement {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(1);

        new RemoveLinkedListElement().removeElements(root, 1);

    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; next = null; }
    }

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return head;

        ListNode currNode = head, prev = head;

        while(currNode != null) {

            if (currNode.val == val) {

                while (currNode.next != null && currNode.next.val == val) {
                    currNode = currNode.next;
                }

                if (currNode.next == null) {
                    prev.next = null;
                    break;
                }
                prev.next = currNode.next;
                currNode = currNode.next;
            } else {
                prev = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }
}
