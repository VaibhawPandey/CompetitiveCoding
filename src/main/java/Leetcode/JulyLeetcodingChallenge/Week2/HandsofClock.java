package main.java.Leetcode.JulyLeetcodingChallenge.Week2;

public class HandsofClock {

    public static void main(String[] args) {

        System.out.println(new HandsofClock().angleClock(3, 15));
    }

    public double angleClock(int hour, int minutes) {


        double minutesAngle = (minutes % 60) * 6;
        double hoursAngle = ((double) minutes/2) + (hour % 12) * 30;

        double res = Math.abs (hoursAngle - minutesAngle);
        return res > 180 ? 360 - res: res;
    }
}
