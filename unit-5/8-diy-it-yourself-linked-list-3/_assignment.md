Using your code from the previous lab as a starting point, you'll be adding the following methods to your `MySLinkedList` class:
`get(T value)`

This method should get a generic value as a parameter and return the `Node` object that has that value. If the value is not present in the Linked List, "That value was not found!" should be printed and null should be returned.
`indexOf(T value)`

This method should get a generic value as a parameter and return the index of the Node object that has that value. If the value is not present in the Linked List, "That value was not found!" should be printed and -1 should be returned.
removeAfter(Node<T> before)

This method should take a Node object as a parameter and remove the element that comes after it. The Node that is removed should be returned.
remove(int index)

This method should get an index as a parameter and remove the Node object at that index. If the index is out of bounds, nothing should be removed. The Node that is removed should be returned. If nothing is removed, null should be returned.
remove(T value)

This method should get a generic value as a parameter and remove the Node object that has that value. If the value is not present in the Linked List, nothing should be removed. The Node that is removed should be returned. If nothing is removed, null should be returned.
Example Code:

MySLinkedList<Integer> myList = new MySLinkedList<Integer>();

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

Node<Integer> n = myList.get(Integer.valueOf(1));

System.out.println(myList.removeAfter(n));

myList.printList();

System.out.println(myList.get(Integer.valueOf(123)));

System.out.println(myList.indexOf(Integer.valueOf(123)));

would output

15 100 6 1 2 3 8

100

15 6 1 2 3 8

2

15 6 1 3 8

1

3

15 6 1 8

That value was not found!

null

That value was not found!

-1
