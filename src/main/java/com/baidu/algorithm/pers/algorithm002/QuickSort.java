package com.baidu.algorithm.pers.algorithm002;


import java.util.Arrays;

/**
 * 快速排序
 *
 * @author mrLIu
 */
public class QuickSort {

    /**
     * 快速排序:
     * <p>
     * 选第一个数作为“枢轴”，
     * 将枢轴与序列另一端的数比较，枢轴大于它，就换位，小于就再和另一端的倒数第二个数比较
     * 第一次换位完了后依旧和另一边的比，但判断标准得颠倒，变成“如果枢轴小于它，就换位”
     * 一轮比完了，枢轴就到了中间，左边比它小，右边比它大。
     * 之后枢轴两边的序列继续进行快排。
     *
     * @param paramQuickSort 传入的数组
     * @param left           左起点
     * @param right          右终点
     *                       <p>
     *                       <p>
     *                       递归形式的分治排序算法
     */
    private static void quickSort(int[] paramQuickSort, int left, int right) {

        if (paramQuickSort.length > 0) {
            if (left < right) {
                // 一次划分
                int mid = partion(paramQuickSort, left, right);

                //对低字段表进行递归排序
                quickSort(paramQuickSort, left, mid - 1);

                //对高字段表进行递归排序
                quickSort(paramQuickSort, mid + 1, right);
            }
        }
    }

    /**
     * 分区方法
     *
     * @param a     数组
     * @param left  左起点
     * @param right 右终点
     * @return
     */
    private static int partion(int[] a, int left, int right) {
        // 轴值，默认选取数组的第一个数字
        while (left < right) {


            while (left < right && a[left] <= a[right]) {
                right--;
            }


            //比中轴小的记录移到低端
            if (left < right) {
                swap(a, left, right);
            }


            while (left < right && a[left] <= a[right]) {

                // 数组移位操作
                left++;
            }


            // 比中轴大的记录移到高端
            if (left < right) {
                swap(a, left, right);
            }
        }
        return left;
    }


    private static void swap(int[] paramQuickSort, int left, int right) {

        // 数组的第一个作为中轴
        int tmp = paramQuickSort[left];

        //与中轴比较后
        paramQuickSort[left] = paramQuickSort[right];

        //中轴记录到尾
        paramQuickSort[right] = tmp;

    }

    /**
     * 把整个序列看做一个数组，把第零个位置看做中轴，
     * 和最后一个比，如果比它小交换，比它大不做任何处理；交换了以后再和小的那端比，
     * 比它小不交换，比他大交换。+
     * 这样循环往复，一趟排序完成，左边就是比中轴小的，
     * 右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] paramQuickSort = {1, 6, 9, 2, 3, 1, 5, 4};
        quickSort(paramQuickSort, paramQuickSort[0], paramQuickSort.length - 1);

        System.out.println("交换排序-快速排序：");
        System.out.println(Arrays.toString(paramQuickSort));
    }

}
