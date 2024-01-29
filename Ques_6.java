import java.util.Scanner;

public class Ques_6 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.data>data){
            root.left=insert(root.left, data);
        }
        else{
            root.right=insert(root.right, data);
        }
        return root;
    }
    public static int lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return -1;
        }

        // If both nodes are smaller, search in the left subtree
        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both nodes are greater, search in the right subtree
        else if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If one node is smaller and the other is greater, or one of them is equal to the root
        else {
            return root.data; // This is the LCA
        }
    }
    public static void main(String[] args) {
        Node root=null;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            root=insert(root, sc.nextInt());
        }
        Node p=null;
        Node q=null;
        p=insert(p, sc.nextInt());
        q=insert(q, sc.nextInt());
        sc.close();
        System.out.println(lowestCommonAncestor(root, p, q));
    }
}
