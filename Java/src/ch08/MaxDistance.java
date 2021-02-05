package ch08;

public class MaxDistance {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int d,int h){
            maxDistance = d;
            height = h;
        }
    }

    public static Info process(Node root){
        if (null == root){
            return new Info(0,0);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance,rightInfo.maxDistance),leftInfo.height + rightInfo.height);

        return new Info(maxDistance,height);
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

        System.out.println(process(root).maxDistance);
    }

}
