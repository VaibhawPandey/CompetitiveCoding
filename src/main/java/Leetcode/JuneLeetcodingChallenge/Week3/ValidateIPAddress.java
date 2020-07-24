package main.java.Leetcode.JuneLeetcodingChallenge.Week3;

public class ValidateIPAddress {

    public static void main(String[] args) {
        System.out.println(new ValidateIPAddress().validIPAddress("1.0.1."));
    }

    public String validIPAddress(String IP) {

        if (IP.chars().filter(c -> c == '.').count() == 3) {

            String ip[] = IP.split("\\.", -1);

            for (int i = 0; i < ip.length; i++) {
                if (ip[i].chars().allMatch(Character:: isDigit)) {
                    if(ip[i].length() == 0 || ip[i].length() > 3) return "Neither";
                    if (ip[i].charAt(0) == '0' && ip[i].length() != 1)
                        return "Neither";
                    int digit = Integer.parseInt(ip[i]);
                    if (digit < 0 || digit > 255)
                        return "Neither";
                } else
                    return "Neither";
            }
            return "IPv4";

        } else if (IP.chars().filter(c -> c == ':').count() == 7) {

            String ip[] = IP.split("[:]", -1);
            for (int i = 0; i < ip.length; i++) {
                if (ip[i].length() > 4 || ip[i].length() == 0 || !ip[i].matches("-?[0-9a-fA-F]+"))
                    return "Neither";
            }

            return "IPv6";
        } else
            return "Neither";
    }
}
