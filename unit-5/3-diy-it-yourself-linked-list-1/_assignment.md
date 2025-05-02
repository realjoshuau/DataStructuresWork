Using what you've learned today, you're going to create your own Singly Linked List class called MySLinkedList.

Your list should hold `int` typed data and keep track of how many elements are present in the Linked List at any given time. There should be a method `size()` that returns this information. In addition to the `append`, `prepend`, and `printList` operations, your Linked List should also enable you to retrieve an element based on its index using a `get` method. If an out-of-bounds index is accessed in the get method, it should print "That is an invalid index!" and return -1.

For example:

```java
MySLinkedList myList = new MySLinkedList();

System.out.println(myList.size());

myList.append(19);

myList.prepend(4);

myList.printList();

System.out.println(myList.get(1));

System.out.println(myList.get(10));
```

would print out

```text
0

4 19

19

That is an invalid index!

-1
```
