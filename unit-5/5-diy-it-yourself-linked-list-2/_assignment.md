# Linked Lists Better

> You'll want to begin this assignment by copying your solution from DIY It Yourself - Linked List #1.

There are some additions/adjustments that you'll be making to the code from that solution.

## Generic-ify It

I want you to make both the Linked List and Node classes able to store any reference type of data, rather than just int values.

## `insertAfter()`

I want you to implement the insertAfter method that we discussed during class today.

## `get()`

I want you to update the get method to return the Node object at the requested index, rather than its data.

If the requested index is out of bounds, null should be returned.

## `insert(index, value)`

I want you to add a method that will allow the user to insert an element at a requested index. If the requested index is out of bounds, nothing should be added.

HINT: I recommend using the get and insertAfter methods to implement this!

Example Main code

```java
MySLinkedList<Integer> myList = new MySLinkedList<Integer>();

myList.append(1);

myList.append(2);

myList.append(3);

myList.printList();

myList.prepend(100);

myList.insert(0, 15);

myList.insert(10, 9);

myList.insert(5, 8);

myList.insert(2, 6);

myList.printList();

System.out.println(myList.get(4));
```

should output

```
1 2 3

That is an invalid index!

15 100 6 1 2 3 8

2
```
