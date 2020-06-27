package algorithm.No2_search.No2_3_insertion_search;

import java.util.ArrayList;
import java.util.List;

// 插值查找法
// 注意，使用前提是数组是有序的
// 对于数据量较大，分布较均匀的查找表来说，插值查找效率较高
public class InsertionSearch {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 199; i++) {
            array[i] = i;
        }
        int tarVal = 1;
        /*int index = search(array, 0, array.length - 1, tarVal);
        System.out.println(index);*/
        List<Integer> list = searchAll(array, 0, array.length - 1, tarVal);
        if (list.size() > 0) {
            System.out.println("找到了，下标：" + list.toString());
        } else {
            System.out.println("这个数不存在~~");
        }
    }

    /**
     * 要求返回所有与tarVal相同的数
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param tarVal
     * @return
     */
    public static List<Integer> searchAll(int[] array, int leftIndex, int rightIndex, int tarVal) {
        List<Integer> rtIndexList = new ArrayList<>();
        if (leftIndex > rightIndex) {
            return rtIndexList;
        }
        int midIndex = (leftIndex + rightIndex)  * (tarVal - array[leftIndex]) / (array[rightIndex] - array[leftIndex]);
        if (array[midIndex] > tarVal) {
            // 中间值比目标值大，左移
            return searchAll(array, leftIndex, midIndex - 1, tarVal);
        } else if (array[midIndex] < tarVal) {
            // 中间值比目标值小，右移
            return searchAll(array, midIndex + 1, rightIndex, tarVal);
        } else {
            // 在找到mid索引值时，不要立即返回，而是左右扫描，将满足条件的元素全部放到集合中返回
            // 1. 向左扫描
            int temp = midIndex - 1;
            while (temp >= 0 && array[temp] == array[midIndex]) {
                rtIndexList.add(temp);
                temp--;
            }
            // 2. 向右扫描
            temp = midIndex + 1;
            while (temp <= array.length - 1 && array[temp] == array[midIndex]) {
                rtIndexList.add(temp);
                temp++;
            }
            rtIndexList.add(midIndex);
            return rtIndexList;
        }
    }

    public static int search(int[] array, int leftIndex, int rightIndex, int tarVal) {
        int times = 0;
        System.out.println("执行了：" + ++times);
        if (leftIndex > rightIndex) {
            return -1;
        }
        // int midIndex = leftIndex + (rightIndex - leftIndex) * 1 / 2
        // int midIndex = leftIndex + (rightIndex - leftIndex) * (tarVal - array[leftIndex]) / (array[rightIndex] - array[leftIndex])
        int midIndex = (leftIndex + rightIndex)  * (tarVal - array[leftIndex]) / (array[rightIndex] - array[leftIndex]);
        if (array[midIndex] > tarVal) {
            // 中间值比目标值大，左移
            return search(array, leftIndex, midIndex - 1, tarVal);
        } else if (array[midIndex] < tarVal) {
            // 中间值比目标值小，右移
            return search(array, midIndex + 1, rightIndex, tarVal);
        } else {
            return midIndex;
        }
    }
}
