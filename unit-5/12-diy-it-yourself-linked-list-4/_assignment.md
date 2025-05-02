Using your code from the previous lab as a starting point, you'll be changing your MySLinkedList class into the MyDLinkedList class!

Your Node class should be updated to have a reference to the previous Node in the Linked List. A getter and setter method should be implemented to allow other classes to access and update this variable.

Your append, prepend, and insertAfter methods should all be updated to account for the new previous connection in each Node.

Replace your removeAfter method with a remove method that takes a Node object as a parameter, removing the requested node. You should have a total of 3 remove methods - one takes an index, one takes a value, the third takes a Node.

Implement a printListBackwards() method that prints the contents of the list in reverse order.

Example Code:

```java

MyDLinkedList<Integer> myList = new MyDLinkedList<Integer>();

myList.append(1);

myList.append(2);

myList.append(3);

myList.prepend(100);

myList.insert(0, 15);

myList.insert(5, 8);

myList.insert(2, 6);

myList.printList();

System.out.println(myList.remove(Integer.valueOf(100)));

myList.printList();

System.out.println(myList.remove(3));

myList.printList();

System.out.println(myList.indexOf(6));

Node<Integer> n = myList.get(Integer.valueOf(3));

n = myList.remove(n);

System.out.println(n);

System.out.println("Removed's previous: " + n.getPrevious());

System.out.println("Removed's next: " +n.getNext());

myList.printList();

System.out.println(myList.get(Integer.valueOf(123)));

System.out.println(myList.indexOf(Integer.valueOf(123)));

myList.printListBackwards();
```

should output:

```
15 100 6 1 2 3 8 

100

15 6 1 2 3 8 

2

15 6 1 3 8 

1

3

Removed's previous: null

Removed's next: null

15 6 1 8 

That value was not found!

null

That value was not found!

-1
```