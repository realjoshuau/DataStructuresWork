You're gonna take your previous code as a starting point again!

Your MyDLinkedList and Node classes should be updated to ensure that their generic types implement the Comparable interface.

You should also make your Node class implement Comparable, so that its objects can be compared to other Node objects!

Implement the split() method outlined in the lecture slides today and use it to create the mergeSort and merge methods in the MyDLinkedList class!

Example main method:

```java
MyDLinkedList<String> listTwo = new MyDLinkedList<String>();

listTwo.append("f");

listTwo.append("i");

listTwo.append("c");

listTwo.append("e");

listTwo.append("b");

listTwo.append("a");

listTwo.append("g");

listTwo.append("d");

listTwo.append("h");

listTwo.printList();

listTwo.mergeSort();

listTwo.printList();
```

should output

```
f i c e b a g d h

a b c d e f g h i
```
