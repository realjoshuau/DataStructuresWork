public class MyDLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyDLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void append(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.setPrevious(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    public void printList() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.getData() + "");
            current = current.getNext();
            System.out.print(" ");
        }
        System.out.println();
    }

    public Node<T>[] getListAll() {
        Node<T> current = this.head;
        Node<T>[] list = new Node[this.size];
        int i = 0;
        while (current != null) {
            list[i] = current;
            current = current.getNext();
            i++;
        }
        return list;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("That is an invalid index!");
            return null;
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public Node<T> get(T value) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("That value was not found!");
        return null;
    }

    public int indexOf(T value) {
        Node<T> current = this.head;
        int i = 0;
        while (current != null) {
            if (current.getData().equals(value)) {
                return i;
            }
            current = current.getNext();
            i++;
        }
        System.out.println("That value was not found!");
        return -1;
    }

    // public Node<T> remove(Node<T> reqNode) {
    // if (reqNode == null) {
    // System.out.println("That is an invalid node!");
    // return null;
    // }
    // if (reqNode == this.head) {
    // this.head.setPrevious(null);
    // this.head = reqNode.getNext();
    // return reqNode;
    // } else if (reqNode == this.tail) {
    // this.tail = reqNode.getPrevious();
    // this.tail.setNext(null);
    // return reqNode;
    // } else {
    // reqNode.getPrevious().setNext(reqNode.getNext());
    // reqNode.getNext().setPrevious(reqNode.getPrevious());
    // return reqNode;
    // }
    // }

    public Node<T> remove(Node<T> reqNode) {
        if (reqNode == null) {
            System.out.println("That is an invalid node!");
            return null;
        }
        if (reqNode == this.head) {
            this.head = reqNode.getNext();
            if (this.head != null) {
                this.head.setPrevious(null);
            } else {
                this.tail = null; // List is now empty
            }
        } else if (reqNode == this.tail) {
            this.tail = reqNode.getPrevious();
            if (this.tail != null) {
                this.tail.setNext(null);
            } else {
                this.head = null; // List is now empty
            }
        } else {
            reqNode.getPrevious().setNext(reqNode.getNext());
            reqNode.getNext().setPrevious(reqNode.getPrevious());
        }

        // Disconnect the node to ensure it's fully removed from the list
        reqNode.setNext(null);
        reqNode.setPrevious(null);
        this.size--;

        return reqNode;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("That is an invalid index!");
            return null;
        }
        if (index == 0) {
            return remove(0);
        } else {
            return remove(get(index));
        }
    }

    public Node<T> remove(T value) {
        Node<T> current = this.head;
        Node<T> before = null;
        while (current != null) {
            if (current.getData().equals(value)) {
                if (before == null) {
                    return remove(0);
                } else {
                    return remove(current);
                }
            }
            before = current;
            current = current.getNext();
        }
        return null;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("That is an invalid index!");
            return;
        }
        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node<T> newNode = new Node<T>(value);
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.setNext(newNode);
            newNode.getNext().setPrevious(newNode);
            this.size++;
        }
    }

    public void printListBackwards() {
        Node<T> current = this.tail;
        while (current != null) {
            System.out.print(current.getData() + "");
            current = current.getPrevious();
            System.out.print(" ");
        }
        System.out.println();
    }
}