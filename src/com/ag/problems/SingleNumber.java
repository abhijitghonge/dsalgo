package com.ag.problems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */
public class SingleNumber {

    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        SingleNumber problem = new SingleNumber();
        System.out.println(problem.singleNumber(new int[]{2,2,1}));
        System.out.println(problem.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(problem.singleNumber(new int[]{1}));

    }

    private  int singleNumber(int[] nums) {
        int odd = nums[0];
        //Since a^a = 0, so the duplicates will cancel them out
        //And only the single number will remain
        for(int i = 1; i < nums.length; i++){
            odd ^= nums[i];
        }
        return odd;

    }
}
