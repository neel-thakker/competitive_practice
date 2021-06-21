public class ExTreeTraversal {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(14);
        tree.insert(24);
        tree.insert(26);

        System.out.println("\nHeight of the tree:- " + tree.height());

        System.out.println("\nLevelOrder Traversal:");
        tree.traverseLevelOrder();

        System.out.println("\nReverseLevelOrder Traversal:");
        tree.traverseReverseLevelOrder();

        System.out.println("\nPreOrder Traversal:");
        tree.traversePreOrder();

        System.out.println("\nInOrder Traversal:");
        tree.traverseInOrder();

        System.out.println("\nPostOrder Traversal:");
        tree.traversePostOrder();
    }
}
