package com.orderpipeline.practice;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {-5,-2,-9};
        int max = nums[0];

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            // if n is bigger than max, update max
        }

        System.out.println("Largest: " + max);
    }
}