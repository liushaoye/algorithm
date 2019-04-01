package com.baidu.algorithm.pers.algorithm003;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author mrLiu
 */
public class SelectionSort {


    /**
     * 选择排序算法:
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers 排序的数组
     */
    public static void selectSort(int[] numbers) {
        //数组长度
        int size = numbers.length;

        //中间变量
        int temp = 0;

        for (int i = 0; i < size; i++) {
            //待确定的位置
            int k = i;
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }

    public static void main(String[] args) {

        int[] numbers = {6, 2, 8, 5, 324, 23423, 56, 2, 87, 3, 42, 436};
        selectSort(numbers);

        System.out.println("选择排序-直接选择排序：");
        System.out.println(Arrays.toString(numbers));

    }

}
