package data_structure.No5_tree;

import lombok.Data;
import lombok.ToString;

/**
 * create by 携山超 on 2020/6/27
 */
@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; // 默认null
    private HeroNode right; // 默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        // 先输出父点
        System.out.println(this);
        // 递归向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        HeroNode rtVal = null;
        // 先比较父点
        if (this.no == no) {
            return this;
        }
        // 递归向左子树遍历
        if (this.left != null) {
            rtVal = this.left.preOrderSearch(no);
        }
        // 如果找到，直接返回
        if (rtVal != null) {
            return rtVal;
        }
        // 递归向右子树遍历
        if (this.right != null) {
            rtVal = this.right.preOrderSearch(no);
        }
        return rtVal;
    }

    // 中序遍历
    public void midOrder() {
        // 递归向左子树遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        // 先输出父点
        System.out.println(this);
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 中序查找
    public HeroNode midOrderSearch(int no) {
        HeroNode rtVal = null;
        // 递归向左子树遍历
        if (this.left != null) {
            rtVal = this.left.midOrderSearch(no);
        }
        // 如果找到，直接返回
        if (rtVal != null) {
            return rtVal;
        }
        // 比较父节点
        if (this.no == no) {
            return this;
        }
        // 递归向右子树遍历
        if (this.right != null) {
            rtVal = this.right.midOrderSearch(no);
        }
        return rtVal;
    }

    // 后序遍历
    public void postOrder() {
        // 递归向左子树遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 先输出父点
        System.out.println(this);
    }

    // 后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode rtVal = null;
        // 递归向左子树遍历
        if (this.left != null) {
            rtVal = this.left.postOrderSearch(no);
        }
        // 如果找到，直接返回
        if (rtVal != null) {
            return rtVal;
        }
        // 递归向右子树遍历
        if (this.right != null) {
            rtVal = this.right.postOrderSearch(no);
        }
        if (rtVal != null) {
            return rtVal;
        }
        // 最后比较父节点
        if (this.no == no) {
            return this;
        } else {
            return null;
        }
    }

    public void delNode(int no) {
        if (this.left != null) {
            if (this.left.no == no) {
                this.left = null;
                return;
            } else {
                this.left.delNode(no);
            }
        }
        if (this.right != null) {
            if (this.right.no == no) {
                this.right = null;
                return;
            } else {
                this.right.delNode(no);
            }
        }
    }
}
