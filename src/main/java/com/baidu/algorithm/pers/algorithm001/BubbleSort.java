package com.baidu.algorithm.pers.algorithm001;

import java.util.Arrays;

/**
 * @author mrLiu
 */
public class BubbleSort {

    private static int[] arr = {6, 3, 8, 2, 9, 1};


    /**
     * 冒泡排序:数组从小到大排列
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    private static void bubbleSortSmall(int[] numbers) {

        int temp;

        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - 1 - i; j++) {

                //交换两数位置
                if (numbers[j] > numbers[j + 1]) {

                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;

                }
            }
        }

    }


    /**
     * 数组从大到小排列
     *
     * @param numbers 传入数
     */
    private static void bubbleSortBig(int[] numbers) {

        int temp;

        int size = numbers.length;

        for (int i = 1; i <= size - 1; i++) {

            for (int j = 1; j <= size - i; j++) {

                //交换两数位置
                if (numbers[j] > numbers[j - 1]) {

                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

    }

    /**
     * 测试
     *
     * @param arr 传入数组
     */
    private static void testSmall(int[] arr) {

        bubbleSortSmall(arr);

        System.out.println("交换排序-输出冒泡排序从小到大结果:");

        System.out.println(Arrays.toString(arr));

//        for (int i : arr) {
//            System.out.print("" + i + " ");
//        }
    }

    /**
     * 测试
     *
     * @param arr 传入数组
     */
    private static void testBig(int[] arr) {

        bubbleSortBig(arr);

        System.out.println("交换排序-输出冒泡排序从大到小结果:");

        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("" + arr[i] + " ");
//        }
    }

    /**
     * 测试方法
     *
     * @param args 传入参数
     */
    public static void main(String[] args) {
        testSmall(arr);
        System.out.println();
        testBig(arr);
    }


}
