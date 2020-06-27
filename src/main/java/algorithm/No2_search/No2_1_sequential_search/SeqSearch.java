package algorithm.No2_search.No2_1_sequential_search;

public class SeqSearch {
    public static void main(String[] args) {
        int array[] = new int[]{ 1, 9, 11, -1, 34, 89 };
        int rtVal = search(array, 0);
        if (rtVal != -1) {
            System.out.println("找到了，下标为：" + rtVal);
        } else {
            System.out.println("没有这个数~~");
        }
        System.out.println(3/2);
    }

    /**
     * 找到一个满足条件的值，返回数组的下标
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同的值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
