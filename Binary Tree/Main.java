public class Main {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println("Done");

        tree.find(8);
        tree.find(1);
        tree.find(3);
        tree.find(10);

        System.out.println("\nPreOrder Traversal:");
        tree.traversePreOrder();

        System.out.println("\nInOrder Traversal:");
        tree.traverseInOrder();

        System.out.println("\nPostOrder Traversal:");
        tree.traversePostOrder();
    }   //  end-main
}   // end-class
