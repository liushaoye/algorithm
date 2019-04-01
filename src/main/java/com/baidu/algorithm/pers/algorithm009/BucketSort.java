package com.baidu.algorithm.pers.algorithm009;

import java.util.*;

/**
 * 桶排序
 *
 * @author mrLiu
 */
public class BucketSort {

    private static void doSort(int[] arr, int range) {

        // 构造辅助数组
        LinkedList[] aux = new LinkedList[range];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = new LinkedList<Integer>();
        }
        // 找打元素在桶中的位置，并将其添加
        for (int i1 : arr) {
            aux[i1].add(i1);
        }
        for (int i = 0, j = 0; i < aux.length && j < arr.length; i++) {

            for (Object v : aux[i]) {
                arr[j] = (int) v;
                j++;
            }
        }
    }

    private static int[] bucketSort(int[] nums, int maxNum) {
        int[] sorted = new int[maxNum + 1];

        for (int num : nums) {
            //把数据放到对应索引的位置
            sorted[num] = num;
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 6, 9, 9};

        int range = a.length;

        if (range / 10 == 0) {
            range = 10;
        } else if (range / 100 == 0) {
            range = 100;
        }
        doSort(a, range);

        System.out.println("桶排序");
        System.out.println(Arrays.toString(a));


        int[] x = {99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18};
        int[] sorted = bucketSort(x, 99);

        System.out.println("桶排序(方法二):");

        for (int i : sorted) {
            if (sorted[i] > 0) {
                System.out.print(sorted[i] + " ");
            }
        }
    }

}
