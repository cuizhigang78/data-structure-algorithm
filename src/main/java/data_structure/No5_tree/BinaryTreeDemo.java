package data_structure.No5_tree;

/**
 * create by 携山超 on 2020/6/27
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node3.left = node5;

        binaryTree.root = root;

        System.out.println("前序遍历");
        binaryTree.preOrder();  // 1, 2, 3, 5, 4

        System.out.println("中序遍历");
        binaryTree.midOrder();  // 2, 1, 5, 3, 4

        System.out.println("后序遍历");
        binaryTree.postOrder();  // 2, 5, 4, 3, 1

        HeroNode rtVal;

        System.out.println("前序查找");
        rtVal = binaryTree.preOrderSearch(6);
        System.out.println(rtVal);

        System.out.println("中序查找");
        rtVal = binaryTree.midOrderSearch(6);
        System.out.println(rtVal);

        System.out.println("后序查找");
        rtVal = binaryTree.postOrderSearch(6);
        System.out.println(rtVal);

        System.out.println("删除3号");
        binaryTree.delNode(3);
        binaryTree.preOrder();
    }
}
