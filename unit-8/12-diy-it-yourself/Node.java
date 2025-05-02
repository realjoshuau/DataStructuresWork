public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left, right, parent;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getKey() {
        return this.getData();
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
        if (left != null)
            left.setParent(this);
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
        if (right != null)
            right.setParent(this);
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}