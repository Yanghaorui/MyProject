package org.leetcode.md;

import java.util.Arrays;

public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int Max = 0;
        int[] length = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            int l = 1;
            int temp = nums[i];
            for(int j = 0; j < i;j++){
                if(temp > nums[j] && length[j] >= l){
                    l = length[j] + 1;
                }
            }
            length[i] = l;
            if(l > Max){
                Max = l;
            }
        }
        return Max;
    }


    public static void main(String[] args) {
        int i = new Q300().lengthOfLIS(new int[]{2, 5, 3, 4, 6, 7, 4, 9});
        System.out.println(i);
    }

}
