import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {

    private static Node insert(Node root, int num) {
        if (root == null) {
            return new Node(num);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                System.out.println("Element added!");
                temp.left = new Node(num);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                System.out.println("Element added!");
                temp.right = new Node(num);
                break;
            } else {
                queue.add(temp.right);
            }

        }

        return root;
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static boolean search(Node root, int num) {
        if (root == null) {
            return false;
        }

        if (root.data == num) {
            return true;
        }

        boolean left = search(root.left, num);
        boolean right = search(root.right, num);

        return left || right;
    }

    private static int height(Node root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static Node delete(Node root, int num) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.data == num) {
                return null;
            } else{
                return root;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curr = null;
        Node keyNode = null;

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr.data == num) {
                keyNode = curr;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        if (keyNode != null) {
            keyNode.data = curr.data;

            System.out.println("Replaced Node with value: "+keyNode.data);
            deleteDeepest(root, curr);
        }
        return root;
    }

    private static void deleteDeepest(Node root, Node keyNode) {

        Queue<Node> queue=new LinkedList<>();

        queue.add(root);
        Node curr;
        while(!queue.isEmpty()){
            curr=queue.poll();
            if(curr==keyNode){
                //System.out.println("Deleted Node with data: "+curr.data);
                curr=null;
                keyNode=null;
                return;
            }

            if(curr.right!=null){
                if(curr.right==keyNode){
                   // System.out.println("Deleted Node with data: "+curr.right.data);
                    curr.right=null;
                    keyNode=null;
                    return;
                }

                queue.add(curr.right);
            }

            if(curr.left!=null){
                if(curr.left==keyNode){

                   // System.out.println("Deleted Node with data: "+curr.left.data);
                    curr.left=null;
                    keyNode=null;
                    return;
                }

                queue.add(curr.left);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);

        int choice = 0, num = 0;

        while (choice != 6) {
            System.out.println();
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add Node in the Tree:");
            System.out.println("2. Traverse Tree - Inorder:");
            System.out.println("3. Search element if exists:");
            System.out.println("4. Calculate Height:");
            System.out.println("5. Delete a node from a tree:");
            System.out.println("6. Exit:");
            System.out.println("Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    root = insert(root, num);
                    break;
                case 2:
                    System.out.println("Tree Elements:");
                    inOrder(root);
                    break;
                case 3:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    System.out.println("Is element exists? " + search(root, num));
                    break;
                case 4:
                    System.out.println("Height of a binary tree is: " + height(root));
                    break;
                case 5:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    root = delete(root, num);
                    break;
                case 6:
                    break;
            }
        }
    }

}
