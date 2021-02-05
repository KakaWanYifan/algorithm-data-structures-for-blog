package ch08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TraverseBinaryTree_Layer {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    /**
     * 层序遍历
     * @param root 根节点
     * @return
     */
    public static ArrayList<Integer> layer(Node root){
        ArrayList<Integer> rnt = new ArrayList<>();
        if (null == root){
            return rnt;
        }
        // 队列
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            rnt.add(node.value);
            if (null != node.left){
                queue.offer(node.left);
            }
            if (null != node.right){
                queue.offer(node.right);   
            }
        }
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

        System.out.println(layer(root));

    }
}
