import java.util.*;

public class MyBinaryTree {
    private Node root;

    private class Node {
        private int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node="+value;
        }
    }   

    public void insert(int value) {
        var node = new Node(value);

        if(root == null) {
            root = node;
            return;
        }

        var currNode = root;
        while(true) {
            if(value < currNode.value) {
                if(currNode.left == null) {
                    currNode.left  = node;
                    break;
                }
                currNode = currNode.left;
            } else {
                if(currNode.right == null) {
                    currNode.right = node;
                    break;
                }
                currNode = currNode.right;
            }
        }
    }   // end-insert

    public void find(int value) {
        var currNode = root;
        int parent = -1;
        while(true) {
            if(currNode.value == value) {
                System.out.println("Node:"+value+" parent:"+parent+" left:"+currNode.left+" right:"+currNode.right);
                break;
            } else if(value < currNode.value) {
                if(currNode.left == null) {
                    System.out.println("Node with value:"+value+" does not exist...");
                    break;
                }
                parent = currNode.value;
                currNode = currNode.left;
            } else {
                if(currNode.right == null) {
                    System.out.println("Node with value:"+value+" does not exist...");
                    break;
                }
                parent = currNode.value;
                currNode = currNode.right;
            }
        }   // end-while
    }   // end-find

    public void traverseLevelOrder() {
        traverseLevelOrder(root);
    }

    private void traverseLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node temp = q.remove();

            System.out.println(temp);

            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }

    public void traverseReverseLevelOrder() {
        traverseReverseLevelOrder(root);
    }

    private void traverseReverseLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node temp = q.remove();

            System.out.println(temp);

            if(temp.right!=null)
                q.add(temp.right);
            if(temp.left!=null)
                q.add(temp.left);
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root==null) 
            return;

        System.out.println(root);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if(root==null) 
            return;

        traverseInOrder(root.left);
        System.out.println(root);
        traverseInOrder(root.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if(root==null) 
            return;

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root==null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}   // end-class