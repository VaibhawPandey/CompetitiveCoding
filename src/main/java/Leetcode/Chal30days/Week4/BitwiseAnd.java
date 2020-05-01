package main.java.Leetcode.Chal30days.Week4;

public class BitwiseAnd {

    public static void main(String[] args) {
        System.out.println(new BitwiseAnd().rangeBitwiseAnd(5, 7));
    }

   // Best Solution
    public int rangeBitwiseAnd(int m, int n) {

        while (n > m)
            n = n & n-1;

        return n;
    }

    // Alternative solution
//    public int rangeBitwiseAnd(int m, int n) {
//
//        int res = 0;
//        while (m > 0 && n > 0) {
//
//            int mMSB = getMSB(m);
//            int nMSB = getMSB(n);
//
//            if (mMSB != nMSB)
//                break;
//
//            int val = (1 << mMSB);
//            res += val;
//
//            m -= val;
//            n -= val;
//        }
//
//        return res;
//    }
//
//    private int getMSB(int n) {
//
//       int mSB = -1;
//       while (n > 0) {
//          n = n >> 1;
//          mSB++;
//       }
//
//       return mSB;
//    }
}
