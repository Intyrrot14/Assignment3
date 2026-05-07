public class MyHashTable<K, V> {

    // Node for linked list
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11; // default bucket count
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Put key-value pair
    public void put(K key, V value) {

        int bucketIndex = hash(key);

        HashNode<K, V> head = chainArray[bucketIndex];

        // Update existing key
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Add new node
        size++;

        head = chainArray[bucketIndex];

        HashNode<K, V> newNode = new HashNode<>(key, value);

        newNode.next = head;

        chainArray[bucketIndex] = newNode;
    }

    // Get value by key
    public V get(K key) {

        int bucketIndex = hash(key);

        HashNode<K, V> head = chainArray[bucketIndex];

        while (head != null) {

            if (head.key.equals(key)) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    // Remove key
    public V remove(K key) {

        int bucketIndex = hash(key);

        HashNode<K, V> head = chainArray[bucketIndex];
        HashNode<K, V> prev = null;

        while (head != null) {

            if (head.key.equals(key)) {

                break;
            }

            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            chainArray[bucketIndex] = head.next;
        }

        return head.value;
    }

    // Check if value exists
    public boolean contains(V value) {

        for (int i = 0; i < M; i++) {

            HashNode<K, V> head = chainArray[i];

            while (head != null) {

                if (head.value.equals(value)) {
                    return true;
                }

                head = head.next;
            }
        }

        return false;
    }

    // Get key by value
    public K getKey(V value) {

        for (int i = 0; i < M; i++) {

            HashNode<K, V> head = chainArray[i];

            while (head != null) {

                if (head.value.equals(value)) {
                    return head.key;
                }

                head = head.next;
            }
        }

        return null;
    }

    // Print bucket sizes
    public void printBucketSizes() {

        for (int i = 0; i < M; i++) {

            int count = 0;

            HashNode<K, V> head = chainArray[i];

            while (head != null) {
                count++;
                head = head.next;
            }

            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }

    public int size() {
        return size;
    }
}