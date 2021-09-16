package com.ag.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has
 * a certain amount of money stashed, the only constraint stopping you from robbing each
 * of them is that adjacent houses have security systems connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the
 * maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    private int[] robbedMoneyTill;
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        //expected: 4
        System.out.println("first case:"+robber.rob(new int[]{1,2,3,1}));

        //expected: 12
        System.out.println("second case:"+robber.rob(new int[]{2,7,9,3,1}));


    }

    //          1  3  5  7  8 10 15 15 18 19 23 23
    // nums = [ 1, 3, 4, 4, 3, 3, 7, 2, 3, 4, 5, 1 ]
    public int rob(int[] moneyInHouse){

        if(moneyInHouse.length ==0) return 0;
        if(moneyInHouse.length == 1) return moneyInHouse[0];
        robbedMoneyTill = new int[moneyInHouse.length];

        robbedMoneyTill[0] = moneyInHouse[0];
        robbedMoneyTill[1] = Math.max(moneyInHouse[1],robbedMoneyTill[0]);
        for (int i = 2; i < moneyInHouse.length; i++) {
            robbedMoneyTill[i] = Math.max(moneyInHouse[i]+ robbedMoneyTill[i-2], robbedMoneyTill[i-1]);
        }

        return robbedMoneyTill[moneyInHouse.length - 1];
    }

}
