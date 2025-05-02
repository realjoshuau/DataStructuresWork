public class MySLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MySLinkedList() {
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

    public Node<T> removeAfter(Node<T> before) {
        Node<T> remNode;
        if (before == null) { // removing head
            remNode = head;
            head = remNode.getNext();
            size--;
        } else { // removing middle / tail
            remNode = before.getNext();
            before.setNext(remNode.getNext());
            size--;
        }
        if (remNode.getNext() == null)
            tail = before; // rem. tail
        else
            remNode.setNext(null);
        // size--;
        return remNode;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("That is an invalid index!");
            return null;
        }
        if (index == 0) {
            return removeAfter(null);
        } else {
            return removeAfter(get(index - 1));
        }
    }

    public Node<T> remove(T value) {
        Node<T> current = this.head;
        Node<T> before = null;
        while (current != null) {
            if (current.getData().equals(value)) {
                if (before == null) {
                    return removeAfter(null);
                } else {
                    return removeAfter(before);
                }
            }
            before = current;
            current = current.getNext();
        }
        return null;
    }

    public void insertAfter(Node<T> before, T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (before == null) {
            newNode.setNext(head);
            head = newNode;
        } else if (before == tail) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setNext(before.getNext());
            before.setNext(newNode);
        }
        size++;
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
            insertAfter(get(index - 1), value);
        }
    }
}