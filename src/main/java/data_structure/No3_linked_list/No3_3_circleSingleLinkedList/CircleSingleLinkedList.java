package data_structure.No3_linked_list.No3_3_circleSingleLinkedList;

public class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Node first = null;

    /**
     * Joseph问题
     * @param k 编号为k（1 <= k <= n）的人从1开始报数
     * @param m 数到m的那个人出列
     * @param n n个人围坐一圈
     */
    public void count(int k, int m, int n) {
        if (first == null || m < 1 || k > n) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 辅助指针helper，环形链表的最后一个节点（即helper.next=first）
        Node helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }
        // 此时helper指向环形链表的最后一个节点
        //报数前，先让first和helper移动k-1次
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        // 循环报数，当圈内只剩一人时停止
        while (first.next != first) {
            // 报数时，让first和helper同时移动m-1次
            for (int i = 0; i < m - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // 此时将first指向的节点就是要出圈的节点
            System.out.println(first.no + "出圈");
            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no + "留到最后");
    }

    // 添加节点，构建成一个环形链表
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums不能小于1");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Node cur = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                cur = node;
                cur.next = first;
            } else {
                cur.next = node;
                cur = cur.next;
                cur.next = first;
            }
        }
    }

    // 打印环形链表
    public void show() {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        if (first.next == first) {
            System.out.println(first.no);
        }
        Node cur = first;
        while (true) {
            System.out.println(cur.no);
            cur = cur.next;
            if (cur == first) {
                break;
            }
        }
    }
}
