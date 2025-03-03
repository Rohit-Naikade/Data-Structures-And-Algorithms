import java.util.*;

class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    private static boolean search(Node root, int num) {

        if (root == null) {
            return false;
        }
        if (root.data == num) {
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (num < root.data) {
            left = search(root.left, num);
        } else {
            right = search(root.right, num);
        }

        return left || right;
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static Node insert(Node root, int num) {
        if (root == null) {
            return new Node(num);
        }

        if (root.data == num) {
            return root;
        }

        if (num <= root.data) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }

        return root;
    }

    private static Node delete(Node root, int num) {
        if (root == null) {
            return root;
        }

        if (root.data > num) {
            root.left = delete(root.left, num);
        } else if (root.data < num) {
            root.right = delete(root.right, num);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node succ = successor(root, root.data);
            root.data = succ.data;
            root.right = delete(root.right, succ.data);
        }

        return root;
    }

    private static Node successor(Node root, int data) {
        Node curr=root.right;

        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }

        return root;
    }

    private static int height(Node root) {
        if(root==null){
            return -1;
        }

        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node root = null;

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
