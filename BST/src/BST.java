import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null)
            return new Node(key, value);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;

        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node != null ? node.value : null;
    }

    private Node get(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node minNode = findMinNode(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = deleteMinNode(node.right);
            }
        }

        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private Node deleteMinNode(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMinNode(node.left);
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }

    private void inorderTraversal(Node node, List<K> keys) {
        if (node == null)
            return;

        inorderTraversal(node.left, keys);
        keys.add(node.key);
        inorderTraversal(node.right, keys);
    }

    public int height(){
        return height(root);
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.right), height(node.left));
    }
}
