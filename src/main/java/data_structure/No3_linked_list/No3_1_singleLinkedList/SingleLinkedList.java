package data_structure.No3_linked_list.No3_1_singleLinkedList;

public class SingleLinkedList {
    // 头节点，不存放具体数据，标志头部
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表，不考虑顺序
    // 1. 找到当前链表的最后节点
    // 2. 将最后节点的next指向新加入的节点
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        // next为null的节点就是链表尾部
        while (temp.next != null) {
            temp = temp.next;
        }
        // 此时temp即尾部结点
        temp.next = heroNode;
    }

    // 添加节点到单向链表，考虑顺序
    // 1. 找到新添加节点的位置，通过辅助变量（指针）temp
    // 2. 将新节点的next指向temp的next
    // 3. 将temp.next指向新的节点
    public void addByOrder(HeroNode heroNode) {
        // 辅助用的指针
        HeroNode temp = head;
        // 新节点是否已经存在的标志位，false表示不存在
        boolean flag = false;
        // next为null的节点就是链表尾部
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                // 从链表头开始遍历，当某一节点的下一个节点的no大于新节点的no
                // 说明新节点就应该插入在此节点之后
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明新节点已经存在于链表中了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断是否存在，若不存在，则插入链表中相应位置
        if (flag) {
            System.out.println("该节点的排名已存在" + "\t" + heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 通过no更新链表节点
    public void update(HeroNode newNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode temp = head;
        // 判断链表中是否有newNode的标志位，false表示没有
        boolean flag = false;
        while (temp != null) {
            // 遍历链表，找到与newNode的no相同的节点
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        } else {
            System.out.println("该节点不存在");
        }
    }

    // 删除节点
    public void delNodeete(int no) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode temp = head;
        // 判断链表中是否有newNode的标志位，false表示没有
        boolean flag = false;
        while (temp.next != null) {
            // 遍历链表，找到与newNode的no相同的节点的前一个节点
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            // 被删除节点已经没有引用指向，会被当作垃圾回收
        } else {
            System.out.println("该节点不存在");
        }
    }

    // 打印链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
