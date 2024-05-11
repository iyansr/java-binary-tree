
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1000000, "CPU");
        tree.add(500000, "MotherBoard");
        tree.add(800000, "RAM");
        tree.add(300000, "HDD");
        tree.add(100000, "Keyboard");


        System.out.println("In-Order: ");
        tree.print();
        System.out.println();
        System.out.println();

        System.out.println("Pre order: ");
        tree.printPreOrder();
        System.out.println();
        System.out.println();

        System.out.println("Post order: ");
        tree.printPostOrder();
        System.out.println();
        System.out.println();

        System.out.println("Level Order: ");
        tree.printLevelOrder();
    }
}