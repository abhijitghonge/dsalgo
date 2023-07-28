package com.ag.strings;

public class BinaryAddition {
    public static void main(String[] args) {
        String A = "1010110111001101101000";
        String B = "1000011011000000111100110";

        BinaryAddition addition = new BinaryAddition();

        System.out.println(addition.addBinary(A, B));
    }

    public String addBinary(String A, String B) {
        int carry = 0;

        int l = A.length()-1 ;
        int r = B.length()-1;

        StringBuilder result = new StringBuilder();
        while(l>=0 || r>=0 || carry ==1){
            //System.out.printf("l:%d, r:%d %n", l,r);
            int lbit = 0;
            int rbit = 0;
            if(l>=0){
                lbit = A.charAt(l) -'0';
            }
            if(r>=0){
                rbit = B.charAt(r) - '0';
            }
            int sum = lbit + rbit + carry;
            switch (sum) {
                case 0:
                    result.append('0');
                    carry = 0;
                    break;
                case 1:
                    result.append('1');
                    carry = 0;
                    break;
                case 2:
                    result.append('0');
                    carry = 1;
                    break;
                case 3:
                    result.append('1');
                    carry = 1;

            }
            l--; r--;
        }

        return result.reverse().toString();

    }
}
