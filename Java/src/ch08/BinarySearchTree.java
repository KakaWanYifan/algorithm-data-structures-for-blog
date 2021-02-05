package ch08;

import java.util.ArrayList;

public class BinarySearchTree {

    /**
     * 节点
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        /**
         * 构造方法
         * @param v 节点的值
         */
        public Node(int v) {
            value = v;
        }
    }

    /**
     * 插入方法
     * @param tree
     * @param data
     * @return
     */
    public static Node insert(Node tree,int data) {
        // 如果是空
        if (tree == null) {
            tree = new Node(data);
            return tree;
        }
        // 当前操作的节点
        Node curr = tree;
        while (curr != null) {
            if (data > curr.value) {
                if (null == curr.right) {
                    curr.right = new Node(data);
                    break;
                } else {
                    curr = curr.right;
                }
            } else {
                if (null == curr.left) {
                    curr.left = new Node(data);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return tree;
    }

    /**
     * 查找
     * @param tree
     * @param data
     * @return
     */
    public static Boolean find(Node tree,int data){
        Node curr = tree;
        while (curr != null){
            if (data < curr.value){
                curr = curr.left;
            }else if(data > curr.value){
                curr = curr.right;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除
     * @param tree
     * @param data
     * @return
     */
    public static Node delete(Node tree,int data){
        Node curr = tree;
        Node currFather = null;
        while (null != curr){
            if (curr.value == data){
                break;
            }
            currFather = curr;
            if (curr.value > data){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        if (curr == null){
            return tree;
        }

        if (null == curr.left || null == curr.right){
            // 如果左子树是null或者右子树是null，说明是叶子节点或者只有左子树或者右子树
            Node child = null;
            if (null != curr.left){
                child = curr.left;
            }else if (null != curr.right){
                child = curr.right;
            }else{
                child = null;
            }

            if (currFather == null){
                tree = child;
            }else if (currFather.left == curr){
                currFather.left = child;
            }else {
                currFather.right = child;
            }
        }else{
            // 如果既有左子树，还有右子树
            Node min = curr.right;
            Node minFather = null;
            while (null != min.left){
                minFather = min;
                min = min.left;
            }
            curr.value = min.value;
            if (minFather.left == min){
                minFather.left = null;
            }else {
                minFather.right = null;
            }
        }
        return tree;
    }

    public static ArrayList<Integer> findInterval(Node root, int min, int max){
        ArrayList<Integer> rnt = new ArrayList<>();
        if (null == root){
            return rnt;
        }
        if (root.value >= min && root.value <= max){
            rnt.add(root.value);
        }
        // 如果大于min，递归左节点
        if (root.value > min){
            rnt.addAll(findInterval(root.left,min,max));
        }
        // 如果小于max，递归右节点
        if (root.value < max){
            rnt.addAll(findInterval(root.right,min,max));
        }
        return rnt;
    }

    public static Integer findMax(Node tree){
        Integer max = null;
        Node curr = tree;
        while (null != curr){
            max = curr.value;
            curr = curr.right;
        }
        return max;
    }

    public static Integer findMin(Node tree){
        Integer min = null;
        Node curr = tree;
        while (null != curr){
            min = curr.value;
            curr = curr.left;
        }
        return min;
    }

    /**
     * 中序优先遍历
     * @param root 根节点
     * @return
     */
    public static ArrayList<Integer> mid(Node root){
        ArrayList<Integer> rnt = new ArrayList<>();
        if (root == null){
            return rnt;
        }
        rnt.addAll(mid(root.left));
        rnt.add(root.value);
        rnt.addAll(mid(root.right));
        return rnt;
    }

    public static void main(String[] args) {
        Node tree = null;
        tree = insert(tree,0);
        tree = insert(tree,1);
        tree = insert(tree,2);
        tree = insert(tree,3);
        tree = insert(tree,4);
        tree = insert(tree,5);
        tree = insert(tree,6);
        tree = insert(tree,7);
        tree = insert(tree,8);
        tree = insert(tree,9);
        System.out.println(tree.value);
        System.out.println(mid(tree));
        System.out.println(find(tree,10));
        System.out.println(find(tree,1));
        tree = delete(tree,10);
        tree = delete(tree,1);
        System.out.println(find(tree,10));
        System.out.println(find(tree,1));
        System.out.println(findInterval(tree,3,6));
        tree = delete(tree,5);
        System.out.println(findInterval(tree,3,6));
        System.out.println(findMax(tree));
        System.out.println(findMin(tree));
        tree = delete(tree,0);
        tree = delete(tree,9);
        System.out.println(findMax(tree));
        System.out.println(findMin(tree));
    }
}
