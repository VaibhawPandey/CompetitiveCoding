package main.java.Leetcode.WeeklyContest.WeeklyContest192;

import java.util.List;

public class BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        browserHistory.visit("linkedIn.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    class TreeNode {

        String str;
        TreeNode child;
        TreeNode parent;

        TreeNode(String str) {
            this.str = str;
            this.child = null;
            this.parent = null;
        }
    }

    TreeNode currNode;
    public BrowserHistory(String homepage) {
        currNode = new TreeNode(homepage);
    }

    public void visit(String url) {
        currNode.child = new TreeNode(url);
        currNode.child.parent = currNode;
        currNode = currNode.child;
    }

    public String back(int steps) {

        int count = steps;
        while (count > 0 && currNode.parent != null) {
            currNode = currNode.parent;
            count--;
        }

        return currNode.str;
    }

    public String forward(int steps) {

        int count = steps;
        while (count > 0 && currNode.child != null) {
            currNode = currNode.child;
            count--;
        }

        return currNode.str;
    }
}
