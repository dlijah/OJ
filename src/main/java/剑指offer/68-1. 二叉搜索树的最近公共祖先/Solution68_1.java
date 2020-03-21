package 剑指offer.二叉搜索树的最近公共祖先;

import java.util.ArrayList;

public class Solution68_1 {
    /*
    题目：
        给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
        最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
    示例 1:
        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        输出: 6
        解释: 节点 2 和节点 8 的最近公共祖先是 6。
    示例 2:
        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        输出: 2
        解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
    说明:
        所有节点的值都是唯一的。
        p、q 为不同节点且均存在于给定的二叉搜索树中。
     */
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static ArrayList<Integer> findpath(TreeNode root, TreeNode node){
        ArrayList<Integer> result = new ArrayList<>();
        while(root!=null&&root.val!=node.val){
            result.add(root.val);
            if(root.val>node.val){
                root=root.left;
            }else {
                root=root.right;
            }
        }
        return result;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result=root ;
        while(root!=null) {
            if(root.val==p.val||root.val==q.val){
                result=root;break;
            }
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                result=root;break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.left.left=null;
        root.left.left.right=null;
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        root.left.right.left.left=null;
        root.left.right.left.right=null;
        root.right.left=null;
        root.right.right=null;
        System.out.println(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(8)).val);
        System.out.println(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(4)).val);
        System.out.println(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(8)).val);

    }
}
