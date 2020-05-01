package main.java.Leetcode.WeeklyContest.WeeklyContest185;

public class NumberofFrog {

    public static void main(String[] args) {

        String croakOfFrogs = "croackroak";
        System.out.println(new NumberofFrog().minNumberOfFrogs(croakOfFrogs));
    }
    public int minNumberOfFrogs(String croakOfFrogs) {

        int res = 0, op = 0, dp[] = new int[5];
        for (int i = 0; i < croakOfFrogs.length(); i++) {

            if (croakOfFrogs.charAt(i) == 'c') {
                op++;
                dp[0]++;
            } else if (croakOfFrogs.charAt(i) == 'r') {
                if (dp[1] >= dp[0]) return -1;
                dp[1]++;
            } else if (croakOfFrogs.charAt(i) == 'o') {
                if (dp[2] >= dp[1]) return -1;
                dp[2]++;
            } else if (croakOfFrogs.charAt(i) == 'a') {
                if (dp[3] >= dp[2]) return -1;
                dp[3]++;
            } else if (croakOfFrogs.charAt(i) == 'k') {
                if (dp[4] >= dp[3]) return -1;
                op--;
                dp[4]++;
            } else return -1;
            res = Math.max(res,op);
        }

        for (int i = 1; i < 5; i++)
            if (dp[i] != dp[0])
                return -1;


        return res;
    }
}
