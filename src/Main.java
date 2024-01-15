public class Main {
    public static void main(String[] args) {

        var tree = new Tree(10);
        tree.insert(5);
        tree.insert(13);
        tree.insert(3);
        tree.insert(8);
        tree.insert(11);
        tree.insert(15);
        tree.insert(6);
        tree.insert(9);
        tree.insert(12);
        tree.insert(7);

        tree.deleteNode(tree.root);
        System.out.println(tree.toString());


    }
}