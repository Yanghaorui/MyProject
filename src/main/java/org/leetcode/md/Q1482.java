package org.leetcode.md;

/**
 * 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 *
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 *
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k <= bloomDay.length){
            int low = bloomDay[0],high = bloomDay[0];
            for (int j : bloomDay) {
                low = Math.min(low, j);
                high = Math.max(high, j);
            }
            if(m * k == bloomDay.length){
                return high;
            }
            while(low < high){
                int days = (low + high) >> 1;
                if(isOk(bloomDay,m,k,days)){
                    high = days;
                } else {
                    low = days + 1;
                }
            }

            return low;
        }
        return -1;
    }

    private boolean isOk(int[] bloomDay, int m, int k, int day){
        int f = 0,b = 0;
        for (int j : bloomDay) {
            if (j <= day) {
                f++;
                if (f == k) {
                    f = 0;
                    b++;
                    if (b == m) {
                        return true;
                    }
                }
            } else {
                f = 0;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Q1482 q = new Q1482();
        System.out.println(q.minDays(new int[]{1,10,3,10,2},3,1));
    }
}
