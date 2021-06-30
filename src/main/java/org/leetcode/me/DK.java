package org.leetcode.me;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 查询数组中第K大的数字
 */
public class DK {
    private static volatile DK dk;
    private static final Object object = new Object();

    private DK(){}

    public static DK getInstance(){
        if(null == dk){
            synchronized (object){
                if(null == dk){
                    dk = new DK();
                }
            }
        }
        return dk;
    }


    public int getNoK(int[] arr,int k){
        int[] ks = new int[k];
        //把前k个复制出来一个新数组
        System.arraycopy(arr,0,ks,0,k);
        //对ks排序
        Arrays.sort(ks);
        List<Integer> list = new LinkedList<>();
        for (int value : ks) {
            list.add(value);
        }

        for (int i = k; i < arr.length; i++) {
            int a = arr[i];
            if ( a >= list.get(k - 1)){
                list.remove(0);
                list.add(a);
            } else if(a > list.get(0) && a < list.get(k - 1)) {
                for (int j = 0; j < k; j++){
                    if(list.get(j) < a && list.get(j + 1) >= a){
                        list.remove(0);
                        list.add(j,a);
                        break;
                    }
                }
            }
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8};
        int noK = DK.getInstance().getNoK(arr, 2);
        System.out.println(noK);
    }


}
