package com.baidu.algorithm.pers.algorithm008;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 *
 * @author mrLiu
 */
public class BaseSort {

    /**
     * 用于大量数，很长的数进行排序时。
     * <p>
     * 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
     * <p>
     * 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
     *
     * @param a 传入数组
     */
    private static void baseSort(int[] a) {
        //首先确定排序的趟数;
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int time = 0;
        //判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }
        //建立10个队列;
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }
        //进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            //分配数组元素;
            for (int j = 0; j < a.length; j++) {
                //得到数字的第time+1位数;
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x, queue2);
            }

            //元素计数器;
            int count = 0;
            //收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }


    /**
     * 获取数组a中最大值
     * <p>
     * 参数说明：
     * a -- 数组
     * n -- 数组长度
     */
    private static int getMax(int[] a) {
        int max;

        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    /**
     * 对数组按照"某个位数"进行排序(桶排序)
     * <p>
     * 参数说明：
     * a -- 数组
     * exp -- 指数。对数组a按照该指数进行排序。
     * <p>
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     * (01) 当exp=1表示按照"个位"对数组a进行排序
     * (02) 当exp=10表示按照"十位"对数组a进行排序
     * (03) 当exp=100表示按照"百位"对数组a进行排序
     * ...
     */
    private static void countSort(int[] a, int exp) {
        // 存储"被排序数据"的临时数组
//        int output[a.length];


        // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];


        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i1 : a) {
            buckets[(i1 / exp) % 10]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }

        output = null;
        buckets = null;
    }

    /**
     * 基数排序
     * <p>
     * 参数说明：
     * a -- 数组
     */
    private static void radixSort(int[] a) {

        // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int exp;
        // 数组a中的最大值
        int max = getMax(a);

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max / exp > 0; exp *= 10)
            countSort(a, exp);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 6, 9, 2, 3, 1, 5, 4};
        baseSort(numbers);

        System.out.println("基数排序:");
        System.out.println(Arrays.toString(numbers));


        int[] a = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        // 基数排序
        radixSort(a);

        System.out.println("基数排序(推荐):");
        System.out.println(Arrays.toString(a));

    }
}
