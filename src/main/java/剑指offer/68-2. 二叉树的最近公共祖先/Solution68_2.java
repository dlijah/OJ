package 剑指offer.二叉树的最近公共祖先;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution68_2 {
    /*
    题目：
        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
        最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    示例 1:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出: 3
        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
    示例 2:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出: 5
        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
    说明:
        所有节点的值都是唯一的。
        p、q 为不同节点且均存在于给定的二叉树中。
     */
    /*
    思路：
        1. 递归调用方法，判断左子树和右子树种是否包含p或者q
        2. 方法判断该树中是否有p或者q，有的话返回根节点，否则返回null
        3. 如果左子树右子树都返回节点，则说明当前节点左子树右子树种分别有p和q，将该节点为结果返回回去。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static Stack<TreeNode> findNode(TreeNode root, TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                if(root.val==p.val) return stack;
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p.val == root.val || q.val == root.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right != null)return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.left.left=null;
        root.left.left.right=null;
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.left.right.left.left=null;
        root.left.right.left.right=null;
        root.right.left=null;
        root.right.right=null;
        Solution68_2 s = new Solution68_2();
        System.out.println(s.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1)).val);
        System.out.println(s.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(4)).val);
    }
}
