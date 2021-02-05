package ch08;

import java.util.ArrayList;

public class TraverseBinaryTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    /**
     * 先序优先遍历
     * @param root 根节点
     * @return
     */
    public static ArrayList<Integer> pre(Node root){
        ArrayList<Integer> rnt = new ArrayList<>();
        if (root == null){
            return rnt;
        }
        rnt.add(root.value);
        rnt.addAll(pre(root.left));
        rnt.addAll(pre(root.right));
        return rnt;
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

    /**
     * 后序优先遍历
     * @param root 根节点
     * @return
     */
    public static ArrayList<Integer> pos(Node root){
        ArrayList<Integer> rnt = new ArrayList<>();
        if (root == null){
            return rnt;
        }
        rnt.addAll(pos(root.left));
        rnt.addAll(pos(root.right));
        rnt.add(root.value);
        return rnt;
    }


    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);

        System.out.println("pre:");
        System.out.println(pre(root));
        System.out.println("mid:");
        System.out.println(mid(root));
        System.out.println("pos:");
        System.out.println(pos(root));
    }

}
