package main.java.Leetcode.JulyLeetcodingChallenge.Week2;

import java.util.Scanner;
import java.util.Stack;

public class FlattenNode {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.prev = root;
        root.next.next = new Node(3);
        root.next.next.prev = root.next;
        root.next.next.child = new Node(4);
        root.next.next.child.next = new Node(5);
        root.next.next.child.next.prev = root.next.next.child;
        root.next.next.next = new Node(6);
        root.next.next.next.prev = root.next.next;

        new FlattenNode().flatten(root);
    }

//    public Node flatten(Node head) {
//
//        if (head == null)
//            return head;
//
//        Node newHead = null;
//        Stack<Node> stack = new Stack<>();
//        stack.add(head);
//
//        while (!stack.isEmpty()) {
//
//            Node tempNode = stack.pop();
//
//            if (tempNode.next != null)
//                stack.push(tempNode.next);
//
//            if (tempNode.child != null)
//                stack.push(tempNode.child);
//
//
//            if (newHead == null) {
//                newHead = tempNode;
//                newHead.next = null;
//                newHead.child = null;
//                head = newHead;
//            }
//            else {
//                newHead.next = tempNode;
//                tempNode.prev = newHead;
//                newHead = tempNode;
//                newHead.next = null;
//                newHead.child = null;
//            }
//        }
//
//        return head;
//    }

    // Alternative
    public Node flatten(Node head) {

        if (head == null) return head;
        flattenTree(head);
        return head;
    }

    private Node flattenTree(Node head) {
        Node curr = head, prev = null;

        while (curr != null) {
            if (curr.child != null) {
                curr.child.prev = curr;
                Node tail = flattenTree(curr.child);
                tail.next = curr.next;
                if (curr.next != null)
                curr.next.prev = tail;
                curr.next = curr.child;
                curr.child = null;
            }

            prev = curr;
            curr = prev.next;
        }

        return prev;
    }
}
