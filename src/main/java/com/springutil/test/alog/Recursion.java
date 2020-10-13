package com.springutil.test.alog;

import lombok.Data;

/**
 * https://blog.csdn.net/weixin_40375601/article/details/108850746
 *         1
 *       /   \
 *      2     3
 *    / \    / \
 *   4   5  6   7
 *      /
 *     8
 * 前序遍历：1-2-4-5-8-3-6-7 先根节点，再左子树，最后右子树
 * 中序遍历：4-2-8-5-1-6-3-7 先左子树，再根节点，最后右子树
 * 后序遍历：4-8-5-2-6-7-3-1 先左子树，再右子树，最后根节点
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年10月13日
 */
@Data
public class Recursion {
    int val;
    Recursion left;
    Recursion right;

    public void setAll(int val, Recursion left, Recursion right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preOrderTraverse(Recursion root) {
        if (root != null) {
            System.out.print(root.val + "-");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void inOrderTraverse(Recursion root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + "-");
            inOrderTraverse(root.right);
        }
    }

    public static void postOrderTraverse(Recursion root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + "-");
        }
    }

    public static void main(String[] args) {
        Recursion one = new Recursion();
        Recursion two = new Recursion();
        Recursion three = new Recursion();
        Recursion four = new Recursion();
        Recursion five = new Recursion();
        Recursion six = new Recursion();
        Recursion seven = new Recursion();
        Recursion eight = new Recursion();

        one.setAll(1, two, three);
        two.setAll(2, four, five);
        three.setAll(3, six, seven);
        four.setAll(4, null, null);
        five.setAll(5, eight, null);
        six.setAll(6, null, null);
        seven.setAll(7, null, null);
        eight.setAll(8, null, null);

        // preOrderTraverse(one);
        // inOrderTraverse(one);
        postOrderTraverse(one);
    }
}
