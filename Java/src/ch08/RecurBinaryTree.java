package ch08;

public class RecurBinaryTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    public static void recur(Node root){
        if (null == root){
            return;
        }
        System.out.print(root.value);
        recur(root.left);
        System.out.print(root.value);
        recur(root.right);
        System.out.print(root.value);

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

        recur(root);
    }

}
