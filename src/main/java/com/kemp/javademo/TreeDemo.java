package com.kemp.javademo;
/**
 * 二叉树
 * 遍历
 * 前序遍历：root -> left -> right
 * 中序遍历：left -> root -> right
 * 后续遍历：left ->right -> root
 * 层序遍历：按照层次遍历
 */
public class TreeDemo {

    private int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private Node<Integer> root = createTree();

    public static void main(String[] args) {
        TreeDemo treeDemo = new TreeDemo();
        treeDemo.createTree();
        Utils.logln("前序遍历");
        treeDemo.preOrder(treeDemo.root);
        Utils.logln("");
        Utils.logln("中序遍历");
        treeDemo.inOrder(treeDemo.root);
        Utils.logln("");
        Utils.logln("后序遍历");
        treeDemo.endOrder(treeDemo.root);
    }

    private Node<Integer> createTree() {
        //第一层
        Node<Integer> root1 = new Node<>(nums[0]);
        //第二层
        Node<Integer> root21 = new Node<>(nums[1]);
        Node<Integer> root22 = new Node<>(nums[2]);
        root1.left = root21;
        root1.right = root22;
        //第三层
        Node<Integer> root31 = new Node<>(nums[3]);
        Node<Integer> root32 = new Node<>(nums[4]);
        Node<Integer> root33 = new Node<>(nums[5]);
        Node<Integer> root34 = new Node<>(nums[6]);
        root21.left = root31;
        root21.right = root32;
        root22.left = root33;
        root22.right = root34;
        //第四层
        Node<Integer> root41 = new Node<>(nums[7]);
        Node<Integer> root42 = new Node<>(nums[8]);
        Node<Integer> root43 = new Node<>(nums[9]);
        root31.left = root41;
        root31.right = root42;
        root32.left = root43;
        return root1;
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node<Integer> root){
        if (root != null){
            Utils.log(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    private void inOrder(Node<Integer> root){
        if (root != null){
            inOrder(root.left);
            Utils.log(root.value + " ");
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    private void endOrder(Node<Integer> root){
        if (root != null){
            endOrder(root.left);
            endOrder(root.right);
            Utils.log(root.value + " ");
        }
    }

    static class Node<V> {
        V value;
        Node<V> left;
        Node<V> right;

        Node(V data) {
            this.value = data;
        }
    }
}
