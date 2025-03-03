import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    
}

public class Traversals {

    private static void inOrder(Node root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }
    private static void preOrder(Node root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    private static void postOrder(Node root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }
    private static void levelOrder(Node root) {
        if(root==null){
            return;
        }

        Queue<Node> queue=new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()){
            Node tmp=queue.poll();
            System.out.print(tmp.data+" ");

            if(tmp.left!=null){
                queue.add(tmp.left);
            }

            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder Traversal:");
        inOrder(root);
        System.out.println("\nPre-order Traversal:");
        preOrder(root);
        System.out.println("\nPost-order Traversal:");
        postOrder(root);
        System.out.println("\nLevel-order Traversal:");
        levelOrder(root);

    }

    
}
