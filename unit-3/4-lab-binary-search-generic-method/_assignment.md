# 3.4 LAB: Binary search generic method

Implement the Searcher class's `binarySearch()` generic method in the Searcher.java file. Access Searcher.java by clicking on the orange arrow next to BinarySearch.java at the top of the coding window. The method performs a binary search on the sorted array (first parameter) for the key (third parameter). `binarySearch()` returns the key's index if found, -1 if not found.

Compare an array element to the key using the compare() method of the comparer object passed as binarySearch()'s last parameter. comparer.compare(a, b) returns an integer:

- greater than 0 if a > b
- less than 0 if a < b
- equal to 0 if a == b

A few test cases exist in the main method to test `binarySearch()` with both string searches and integer searches. Clicking "Run program" will display test case results, each starting with "PASS" or "FAIL". Ensure that all tests are passing before submitting code.

Each test in the main method only checks that `binarySearch()` returns the correct result, but does not check the number of comparisons performed. The unit tests in the submit mode check both `binarySearch()`'s return value and the number of comparisons performed.
