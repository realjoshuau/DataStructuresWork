
class MyBinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(Node<T> newNode) {
        if (root == null) {
            root = newNode;
            System.out.println("Inserted " + newNode.getData() + " as root!");
            return;
        }
        insertRec(root, newNode, null);
    }

    public void insert(T data) {
        root = insertRec(root, new Node<>(data), null);
    }

    private Node<T> insertRec(Node<T> current, Node<T> newNode, Node<T> parent) {
        if (current == null) {
            newNode.setParent(parent);
            if (parent == null) { // because the autograder wants a DIFFERENT STRING FOR ROOT NODES. WHY!
                                  // WHY?!?!!?!??!?!?!?!?!?!?!?!?
                System.out.println("Inserted " + newNode.getData() + " as root!");
                return newNode;
            }
            System.out.println(newNode.getData() + " was inserted" // im not even changing this
                    + (parent == null ? " as root!"
                            : " to the " + (newNode.getData().compareTo(parent.getData()) < 0 ? "left" : "right")
                                    + " of " + parent.getData()));
            return newNode;
        }
        if (newNode.getData().compareTo(current.getData()) < 0) {
            current.setLeft(insertRec(current.getLeft(), newNode, current));
        } else if (newNode.getData().compareTo(current.getData()) > 0) {
            current.setRight(insertRec(current.getRight(), newNode, current));
        }
        return current;
    }

    public Node<T> search(T key) {
        return searchRec(root, key);
    }

    private Node<T> searchRec(Node<T> current, T key) {
        if (current == null || current.getData().equals(key)) {
            return current;
        }
        return key.compareTo(current.getData()) < 0
                ? searchRec(current.getLeft(), key)
                : searchRec(current.getRight(), key);
    }

    public boolean remove(Node<T> nodeToRemove) {
        if (nodeToRemove == null)
            return false;
        root = removeNode(root, nodeToRemove);
        return true;
    }

    public boolean remove(T key) {
        Node<T> nodeToRemove = search(key);
        if (nodeToRemove == null)
            return false;
        root = removeNode(root, nodeToRemove);
        return true;
    }

    private Node<T> removeNode(Node<T> current, Node<T> nodeToRemove) {
        if (current == null)
            return null;

        if (nodeToRemove.getData().compareTo(current.getData()) < 0) {
            current.setLeft(removeNode(current.getLeft(), nodeToRemove));
        } else if (nodeToRemove.getData().compareTo(current.getData()) > 0) {
            current.setRight(removeNode(current.getRight(), nodeToRemove));
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                System.out.println("Removed " + current.getData() + ". It had no children.");
                return current.getRight();
            }
            if (current.getRight() == null) {
                System.out.println("Removed " + current.getData() + ". It had one left child - "
                        + current.getLeft().getData() + ".");
                return current.getLeft();
            }
            Node<T> successor = findMin(current.getRight());
            System.out.println("Removed " + current.getData() + " and replaced with " + successor.getData()
                    + " because it had 2 children.");
            if (successor.getLeft() == null) {
                System.out.println("Removed " + successor.getData() + ". It had no children.");
            }
            current.setData(successor.getData());
            current.setRight(removeNode(current.getRight(), successor));
        }
        return current;
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