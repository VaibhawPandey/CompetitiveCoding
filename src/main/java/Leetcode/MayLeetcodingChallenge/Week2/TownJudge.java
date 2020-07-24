package main.java.Leetcode.MayLeetcodingChallenge.Week2;

public class TownJudge {
    public static void main(String[] args) {

        int n = 4;
        int trust[][] ={{1,2},{2,3}};

        System.out.println(new TownJudge().findJudge(n, trust));
    }
    public int findJudge(int N, int[][] trust) {

        int trustOn[] = new int[N+1];
        int trustedBy[] = new int[N+1];

        for (int i = 0; i < trust.length; i++) {
              trustOn[trust[i][0]]++;
              trustedBy[trust[i][1]]++;
        }

        for (int i = 1; i <= N; i++) {

            if (trustOn[i] == 0 && trustedBy[i] == N-1)
                return i;
        }

        return -1;
    }
}
