public class BSTtest {

    public static void BSTtest(String[] args) {

        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Five");
        tree.put(2, "Two");
        tree.put(8, "Eight");
        tree.put(1, "One");
        tree.put(3, "Three");

        System.out.println("Size: " + tree.size());

        System.out.println(tree.get(3));

        // In-order traversal
        for (var elem : tree) {

            System.out.println(
                    "key is "
                            + elem.getKey()
                            + " and value is "
                            + elem.getValue()
            );
        }
    }
}