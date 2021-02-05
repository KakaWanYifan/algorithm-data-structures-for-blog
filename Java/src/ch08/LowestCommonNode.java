package ch08;

public class LowestCommonNode {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    public static class Info{
        public Node ans;
        public boolean findA;
        public boolean findB;

        public Info(Node f,boolean a,boolean b){
            ans = f;
            findA = a;
            findB = b;
        }
    }

    public static Info process(Node x,Node a,Node b){
        if (null == x){
            return new Info(null,false,false);
        }

        Info leftInfo = process(x.left,a,b);
        Info rightInfo = process(x.right,a,b);

        boolean findA = (x == a || leftInfo.findA || rightInfo.findA);
        boolean findB = (x == b || leftInfo.findB || rightInfo.findB);

        Node ans = null;
        if (null != leftInfo.ans){
            ans = leftInfo.ans;
        }
        if (null != rightInfo.ans){
            ans = rightInfo.ans;
        }
        if (null == ans){
            if (findA && findB){
                ans = x;
            }
        }

        return new Info(ans,findA,findB);
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        Node a = new Node(5);
        Node b = new Node(1);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = a;
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.left.left = b;
        root.left.left.right = new Node(3);

        System.out.println(process(root,a,b).ans.value);
    }
}
