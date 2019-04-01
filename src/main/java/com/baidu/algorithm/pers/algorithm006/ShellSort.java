package com.baidu.algorithm.pers.algorithm006;


import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author mrLiu
 */
public class ShellSort {


    /**
     * 希尔排序的原理:
     * 根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，
     * 可以说希尔排序是加强版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，
     * 第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     */
    public static void shellSort(int[] data, int mid) {
        int j = 0;
        int temp = 0;

        // 数组长度的一半
        int incrementNum = data.length / 2;

        //每次将步长缩短为原来的一半
        for (int increment = incrementNum; increment > 0; increment /= 2) {


            for (int i = increment; i < data.length; i++) {

                temp = data[i];

                for (j = i; j >= increment; j -= increment) {

                    if (mid == 1) {
                        if (change(data, j, temp > data[j - increment], data[j - increment])) {
                            break;
                        }
                    } else {
                          if (change(data, j, temp < data[j - increment], data[j - increment])) {
                            break;
                        }

////如想从小到大排只需修改这里
//                        if (temp < data[j - increment]) {
//                            data[j] = data[j - increment];
//                        } else {
//                            break;
//                        }
                    }
                }
                data[j] = temp;
            }

        }
    }

    private static boolean change(int[] data, int j, boolean b, int datum) {
        //如想从小到大排只需修改这里
        if (b) {
            data[j] = datum;
        } else {
            return true;
        }
        return false;
    }


    private static boolean smallToBig(int[] data, int j, boolean b, int datum) {
        //如想从小到大排只需修改这里
        if (b) {
            data[j] = datum;
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 9, 1, 3, 4};
        shellSort(numbers, 2);

        System.out.println("插入排序-希尔排序：");
        System.out.println(Arrays.toString(numbers));
    }

}
