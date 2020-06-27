package data_structure.No3_linked_list.No3_3_circleSingleLinkedList;

/**
 * Joseph问题
 * 设编号为1，2，...，n的n个人围坐一圈，约定编号为k（1 <= k <= n）的人从1开始报数，数到m的那个人出列，
 * 它的下一位再重新报数，数到m的那个人又出列，依此类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *
 * 举例，有5人，从第1人开始，数2下，则出队序列为 2 -> 4 -> 1 -> 5 -> 3
 *
 * 分析思路：
 * 1. 创建一个辅助指针helper，事先应该指向环形链表的最后一个节点（即helper.next=first），
 * 报数前，先让first和helper移动k-1次
 * 2. 报数时，让first和helper同时移动m-1次
 * 3. 这里就可以将first指向的节点出圈
 *     first = first.next
 *     helper.next = first
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(100);
        list.show();
        list.count(10, 10, 100);
    }
}
