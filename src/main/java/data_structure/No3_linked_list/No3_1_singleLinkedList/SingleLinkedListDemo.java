package data_structure.No3_linked_list.No3_1_singleLinkedList;


import java.util.Stack;

// 单向链表
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new HeroNode(1, "宋江", "及时雨"));
        list.add(new HeroNode(2, "卢俊义", "玉麒麟"));
        list.add(new HeroNode(3, "吴用", "智多星"));
        list.add(new HeroNode(4, "公孙胜", "入云龙"));
        list.add(new HeroNode(5, "关胜", "大刀"));
        list.list();
        /*list.update(new HeroNode(1, "小宋", "小及时雨"));
        list.update(new HeroNode(3, "小吴", "小智多星"));
        list.update(new HeroNode(5, "小关", "小大刀"));
        System.out.println("--- 修改  ---");
        list.list();*/

        list.delNodeete(1);
        list.delNodeete(3);
        list.delNodeete(5);
        System.out.println("--- 删除  ---");
        list.list();
    }

    /**
     * 面试题1：求链表中有效节点的个数
     *
     */
    public static int getLength(HeroNode head) {
        int length = 0;
        if (head.next == null) {
            return 0;
        }
        // temp直接指向head.next，则最后统计出来的结果不包括头节点
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 面试题2：查找单链表中的倒数第k个节点【新浪面试题】
     *
     * 链表长度为l，倒数第k个即正数第(l-k+1)个
     */
    public static HeroNode reciprocal(HeroNode head, int k) {
        // 空链表
        if (head.next == null) {
            throw new RuntimeException("");
        }
        // 获取列表长度
        int l = getLength(head);
        if (k > l) {
            throw new RuntimeException("k数值超过链表最大长度");
        }
        HeroNode temp = head.next;
        // 记录目前是第几个节点
        int index = 0;
        while (temp != null) {
            index++;
            if (index == (l - k + 1)) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 面试题3：单链表的反转【腾讯面试题】
     *
     * 1. 定义一个新节点reserveHead，作为一个新链表的头节点
     * 2. 遍历原来的链表，取出每个节点，插入到新链表的最前端（即每次都插到reserveHead后面）
     * 3. 原链表的head.next=reserveHead.next
     */
    public static void reverse(HeroNode head) {
        // 如果链表为空，或只有一个节点，那么无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reserveHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        while (cur != null) {
            HeroNode next = cur.next;
            cur.next = reserveHead.next;
            reserveHead.next = cur;
            cur = next;
        }
        head.next = reserveHead.next;
    }

    /**
     * 面试题4：从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack栈】
     *
     */
    public static void reversePrint(HeroNode head) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 面试题5：合并两个有序的单链表，合并之后的链表依然有序
     *
     * 合并两个有序链表a，b，创建一个新的链表c，逐个遍历a，b两个链表，将较小的加入到c中
     */
    public static void merge(HeroNode head1, HeroNode head2) {
        // 新链表的头节点
        HeroNode mergeHead = new HeroNode(0, "", "");
        // 遍历a，b两个链表
        HeroNode cur1;
        HeroNode cur2;

        if (getLength(head1) > getLength(head2)) {
            cur1 = head1.next;
            cur2 = head2.next;
        } else {
            cur1 = head2.next;
            cur2 = head1.next;
        }

        while (cur1 != null) {
            while (cur2 != null) {
                if (cur1.no < cur2.no) {
                    HeroNode next = cur1.next;
                    cur1.next = null;
                    getLastNode(mergeHead).next = cur1;
                    cur1 = next;
                    break;
                } else {
                    HeroNode next = cur2.next;
                    cur2.next = null;
                    getLastNode(mergeHead).next = cur2;
                    cur2 = next;
                }
            }
            if (cur2 == null) {
                getLastNode(mergeHead).next = cur1;
                break;
            }
        }



        HeroNode temp = mergeHead;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    // 获取尾节点
    public static HeroNode getLastNode(HeroNode head) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}

