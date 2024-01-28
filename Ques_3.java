import java.util.ArrayList;
import java.util.Scanner;

public class Ques_3 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void postorderTraversal(Node root){
        if(root==null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static ArrayList<Integer> print2Leaf(Node root) {
        ArrayList<Integer> path = new ArrayList<>();
        print2Leaf(root, path);
        return path;
    }
    public static void print2Leaf(Node root, ArrayList<Integer> path){ //path traversal 
        if(root==null){
            return;
        }

        //leaf node
        if(root.left==null && root.right==null){
            path.add(root.data);
        }
        else{
            print2Leaf(root.left, path);
            print2Leaf(root.right, path);
        }
    }
    public static Node delete(Node root, int val){
        if(root.data>val){
            root.left=delete(root.left, val);
        }
        else if(root.data<val){
            root.right=delete(root.right, val);
        }
        else{
            //case 1
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            return root.right=delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root=null;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++){
            root=insert(root, sc.nextInt());
        }
        sc.close();
        ArrayList<Integer> leafNodes = print2Leaf(root);
        for(int i=0;i<leafNodes.size();i++){
            delete(root, leafNodes.get(i));
        }

        System.out.println("Postorder Traversal:");
        postorderTraversal(root);
    }
}
