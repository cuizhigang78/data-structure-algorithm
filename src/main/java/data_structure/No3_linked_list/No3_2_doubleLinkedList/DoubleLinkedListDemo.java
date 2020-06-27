package data_structure.No3_linked_list.No3_2_doubleLinkedList;

// 双向链表
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(new HeroNode(1, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(3, "吴用", "智多星"));
        list.addByOrder(new HeroNode(5, "关胜", "大刀"));
        list.addByOrder(new HeroNode(2, "卢俊义", "玉麒麟"));
        list.addByOrder(new HeroNode(4, "公孙胜", "入云龙"));
        list.addByOrder(new HeroNode(6, "林冲", "豹子头"));
        list.list();
    }
}

