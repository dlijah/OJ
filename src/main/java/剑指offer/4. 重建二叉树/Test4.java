package 剑指offer.重建二叉树;

import java.util.Arrays;

public class Test4 {
    /*
    题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建出下图所示的二叉树并输出它的头结点。
     */

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /*
    这里采用递归方式进行求解：
      首先根据先序遍历的int数组首位得到根节点，再根据根节点在中序遍历的int数组的位置得到左子树和右子树，
      对左子树和右子树递归重建二叉树
     */
    public static BinaryTreeNode buildTree(int[] preorder , int[] inorder){
        if(preorder==null||preorder.length==0){
            return null;
        }
        int rootvalue = preorder[0];
        BinaryTreeNode root = new BinaryTreeNode();
        root.value=rootvalue;
        //左子树长度
        int n = -1;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i]==rootvalue){
                n=i;break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder , 1, n+1) , Arrays.copyOfRange(inorder , 0 , n));
        root.right = buildTree(Arrays.copyOfRange(preorder , n+1 , preorder.length) , Arrays.copyOfRange(inorder , n+1 , inorder.length));
        return root;
    }


    //辅助方法，中序遍历打印二叉树。
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }


    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        buildTree(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();
    }
}
