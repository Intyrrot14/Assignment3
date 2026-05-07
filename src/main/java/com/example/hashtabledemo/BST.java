import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST<K extends Comparable<K>, V>
        implements Iterable<BST<K, V>.Entry> {

    private Node root;
    private int size;

    // Node class
    private class Node {

        private K key;
        private V val;

        private Node left;
        private Node right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Class for iteration output
    public class Entry {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // SIZE
    public int size() {
        return size;
    }

    // PUT
    public void put(K key, V val) {

        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node current = root;

        while (true) {

            int cmp = key.compareTo(current.key);

            // LEFT
            if (cmp < 0) {

                if (current.left == null) {
                    current.left = new Node(key, val);
                    size++;
                    return;
                }

                current = current.left;
            }

            // RIGHT
            else if (cmp > 0) {

                if (current.right == null) {
                    current.right = new Node(key, val);
                    size++;
                    return;
                }

                current = current.right;
            }

            // UPDATE EXISTING KEY
            else {
                current.val = val;
                return;
            }
        }
    }

    // GET
    public V get(K key) {

        Node current = root;

        while (current != null) {

            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            }

            else if (cmp > 0) {
                current = current.right;
            }

            else {
                return current.val;
            }
        }

        return null;
    }

    // DELETE
    public void delete(K key) {

        root = delete(root, key);
    }

    // Recursive delete helper
    private Node delete(Node node, K key) {

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        }

        else if (cmp > 0) {
            node.right = delete(node.right, key);
        }

        else {

            size--;

            // NO CHILD
            if (node.left == null && node.right == null) {
                return null;
            }

            // ONE CHILD
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // TWO CHILDREN
            Node min = findMin(node.right);

            node.key = min.key;
            node.val = min.val;

            node.right = delete(node.right, min.key);
        }

        return node;
    }

    // Find minimum node
    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // ITERATOR (IN-ORDER)
    @Override
    public Iterator<Entry> iterator() {

        List<Entry> list = new ArrayList<>();

        inOrder(root, list);

        return list.iterator();
    }

    // In-order traversal
    private void inOrder(Node node, List<Entry> list) {

        if (node == null) {
            return;
        }

        inOrder(node.left, list);

        list.add(new Entry(node.key, node.val));

        inOrder(node.right, list);
    }
}