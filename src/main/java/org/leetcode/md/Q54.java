package org.leetcode.md;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Q54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        int[][] index = new int[matrix.length][matrix[0].length];
        int k = Math.min(matrix.length, matrix[0].length);
        for (int l = 0; l < k ; l++) {
            int j = l, i = l;
            while (index[i][j] == 0 && j < matrix[0].length - 1 - l) {
                list.add(matrix[i][j]);
                index[i][j] = 1;
                j++;
            }
            while (index[i][matrix[0].length - 1 - l] == 0 && i < matrix.length - 1 - l) {
                list.add(matrix[i][matrix[0].length - 1 - l]);
                index[i][matrix[0].length - 1 - l] = 1;
                i++;
            }
            while (j > l && index[i][j] == 0) {
                list.add(matrix[i][j]);
                index[i][j] = 1;
                j--;
            }
            //j = 0
            while (i > l && index[i][j] == 0) {
                list.add(matrix[i][j]);
                index[i][j] = 1;
                i--;
            }
        }

        int i = matrix.length >> 1;
        int j = matrix[0].length >> 1;
        if(index[i][j] == 0){
            list.add(matrix[i][j]);
        }
        return list;
    }


    public static void main(String[] args) {
        List<Integer> integers = new Q54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(integers.toArray()));
    }

}
