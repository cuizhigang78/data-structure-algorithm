package data_structure.No5_tree;

/**
 * create by 携山超 on 2020/6/27
 * 为什么需要树这种数据结构
 *
 *  1. 数组存储方式的分析
 *      优点：通过下标访问元素，速度快。对于有序数据，使用二分查找可以提高检索效率；
 *      缺点：如果要检索某个具体的值，或者插入值，则效率较低。
 *  2. 链表存储方式的分析
 *      优点：增删节点的效率高
 *      缺点：进行检索时，必须从头节点开始遍历，效率低
 *  3. 树存储方式的分析
 *      优点：能提高数据存储，读取的效率，如二叉排序树（Binary Sort Tree），既可以保证数据检索速度，
 *      也可以保证数据的插入，删除，修改的速度。
 */
public interface Tree {
}
