Write a method countWords that takes as a parameter a String. This String will contain a sequence of words separated by spaces with no punctuation. Your method should count the number of times each of these words appears in the String and return another String with that information in the format "<word> <count>\n". Each word's count should appear on its own line in the return value such that when the return is printed the counts are each on separate lines. The values should be sequenced in the same order they were found in the original String. Words capitalized differently should still be counted as the same as one another.

Example:

If `myString = "The red brick the the brick was red"`, `System.out.println(wordCounts(myString))` would look like this:

```
the 3
red 2
brick 2
was 1
```
