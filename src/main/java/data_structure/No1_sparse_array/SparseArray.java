package data_structure.No1_sparse_array;

import java.util.Arrays;

/**
 * 稀疏数组
 *
 * 基本介绍
 * 当一个数组中大部分元素为0，或者为同一个值时，可以使用稀疏数组来保存该数组。
 *
 * 稀疏数组的处理方法：
 * 1. 记录数组一共有几行几列，有多少个不同的值
 * 2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 *
 * 原始二维数据 int[11][11]
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 1 0 0 0 0 0 0 0 0
 * 0 0 0 2 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0
 *
 * 稀疏数组 int[3][3]
 *   row col val
 *   11  11  2
 *   1   2   1
 *   2   3   2
 *
 * 二维数组转稀疏数组的思路：
 * 1. 遍历二维数组array，得到有效数据的个数sum；
 * 2. 根据sum创建稀疏数组sparseArray int[sum+1][3] (由稀疏数组性质，必为3列)
 * 3. 将二维数组的有效数据存入稀疏数组
 *
 * 稀疏数组转二维数组的思路：
 * 1. 读取二维数组sparseArray的第一行数据，创建二维数据array int[11][11]
 * 2. 再读取sparseArray后几行的数据，并赋值给array
 */
public class SparseArray {
    public static void main(String[] args) {
        // 1. 先创建一个二维数组int[11][11]
        int[][] array = new int[11][11];
        // 2. 初始化
        array[1][2] = 1;
        array[2][3] = 2;
        array[2][6] = 2;
        // 打印二维数组
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }

        //----- 二维数组转稀疏数组 -----
        // 3. 遍历二维数组array，得到有效数据的个数sum
        int sum = 0;
        for (int[] ints : array) {
            for (int i : ints) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        // 4. 根据sum创建稀疏数组sparseArray int[sum+1][3]
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0] = new int[] {array.length, array[0].length, sum};
        // 记录稀疏数组的行数，也即有效数据的个数+1
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[count] = new int[] {i, j, array[i][j]};
                    count++;
                }
            }
        }
        // 打印稀疏数组
        for (int[] ints : sparseArray) {
            System.out.println(Arrays.toString(ints));
        }

        //----- 稀疏数组转二维数组 -----
        // 5. 读取二维数组sparseArray的第一行数据，创建二维数据array int[11][11]
        int col = sparseArray[0][0];
        int row = sparseArray[0][1];
        int[][] newArray = new int[col][row];
        // 6. 再读取sparseArray后几行的数据，并赋值给array
        for (int i = 1; i < sparseArray.length; i++) {
            newArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 打印二维数组
        for (int[] ints : newArray) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
