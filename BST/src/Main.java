public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        bst.put(5, "Value 3");
        bst.put(2, "Value 5");
        bst.put(7, "Value 8");
        bst.put(1, "Value 2");
        bst.put(4, "Value 1");
        bst.put(6, "Value 4");
        bst.put(9, "Value 7");

        System.out.println("Value for key 2: " + bst.get(4));

        bst.delete(4);

        System.out.println("Size of the tree: " + bst.size());

        System.out.println("Height of the tree: " + bst.height()); // Defence 5 test

        System.out.println("Keys in ascending order:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
    }
}
