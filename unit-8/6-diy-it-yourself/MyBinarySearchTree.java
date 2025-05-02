public class MyBinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(Node<T> newNode) {
        if (root == null) {
            root = newNode;
            System.out.println("Inserted " + newNode.getData() + " as root!");
            return;
        }
        insertRec(root, newNode);
    }

    public void insert(T key) {
        Node<T> newNode = new Node<>(key);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted " + key + " as root!");
            return;
        }
        insertRec(root, newNode);
    }

    private void insertRec(Node<T> parent, Node<T> newNode) {
        if (newNode.getData().compareTo(parent.getData()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(newNode);
                System.out.println(newNode.getData() + " was inserted to the left of " + parent.getData());
            } else {
                insertRec(parent.getLeft(), newNode);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(newNode);
                System.out.println(newNode.getData() + " was inserted to the right of " + parent.getData());
            } else {
                insertRec(parent.getRight(), newNode);
            }
        }
    }

    public Node<T> search(T key) {
        return searchRec(root, key);
    }

    private Node<T> searchRec(Node<T> node, T key) {
        if (node == null || node.getData().equals(key))
            return node;
        return key.compareTo(node.getData()) < 0 ? searchRec(node.getLeft(), key) : searchRec(node.getRight(), key);
    }

    public boolean remove(T key) {
        Node<T> removedNode = search(key);
        if (removedNode == null) {
            System.out.println(key + " was not found!");
            return false;
        }
        root = removeRec(root, key);
        return true;
    }

    private Node<T> removeRec(Node<T> node, T key) {
        if (node == null)
            return null;
        if (key.compareTo(node.getData()) < 0) {
            node.setLeft(removeRec(node.getLeft(), key));
        } else if (key.compareTo(node.getData()) > 0) {
            node.setRight(removeRec(node.getRight(), key));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                System.out.println("Removed " + node.getData() + ". It had no children.");
                return null;
            }
            if (node.getLeft() == null) {
                System.out.println(
                        "Removed " + node.getData() + ". It had one right child - " + node.getRight().getData() + ".");
                return node.getRight();
            }
            if (node.getRight() == null) {
                System.out.println(
                        "Removed " + node.getData() + ". It had one left child - " + node.getLeft().getData() + ".");
                return node.getLeft();
            }
            Node<T> successor = findMin(node.getRight());
            System.out.println("Removed " + node.getData() + " and replaced with " + successor.getData()
                    + " because it had 2 children.");
            node.setData(successor.getData());
            node.setRight(removeRec(node.getRight(), successor.getData()));
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    public int calculateHeight(Node<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(calculateHeight(n.getLeft()), calculateHeight(n.getRight()));
    }

    public int treeHeight() {
        return calculateHeight(root);
    }

    public void inorderPrint(Node<T> n) {
        if (n != null) {
            inorderPrint(n.getLeft());
            System.out.print(n.getData() + " ");
            inorderPrint(n.getRight());
        }
    }

    public void treePrint() {
        inorderPrint(root);
        System.out.println();
    }
}
