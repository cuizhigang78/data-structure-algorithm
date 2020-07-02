package data_structure.No5_tree;

/**
 * 二叉树
 *
 * 1. 每个节点最多只能有两个子节点的树，称为二叉树
 * 2. 二叉树的子节点分为左节点和右节点
 * 3. 如果二叉树的所有叶子节点都在最后一层，并且节点总数=2^n-1，n为层数，则称为满二叉树
 * 4. 如果二叉树的所有叶子节点都在最后一层或者倒数第二层，而且最后一层的叶子节点在左边连续，
 *     倒数第二层的叶子节点在右边连续，称为完全二叉树。
 *
 * 二叉树的遍历
 *
 * 1. 前序遍历：先输出父节点，再遍历左子树和右子树
 * 2. 中序遍历：先遍历左子树，再输出父节点，再遍历右子树
 * 3. 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 *
 * 输出父节点的顺序，决定了是前序遍历，中序遍历还是后序遍历
 *
 */
public class BinaryTree {

    public HeroNode root;

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    /**
     * 前序查找
     */
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    /**
     * 中序查找
     */
    public HeroNode midOrderSearch(int no) {
        if (this.root != null) {
            return this.root.midOrderSearch(no);
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    /**
     * 后序查找
     */
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }

    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.no == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            throw new RuntimeException("二叉树为空！");
        }
    }
}

