In this assignment, you will be simulating a group of people competing in a footrace. You will need to implement at least 4 classes:

    Runner
    RunnerDistanceComparator
    Sorter
    Footrace

# Runner

The Runner class will represent a single runner in the footrace. Each runner should have a name (initialized by parameter to constructor) and distance run (initialized at 0). There should be getter methods for all instance variables. The Runner class should have a method run() that adds a random value between 1 and 5 to the runner's current distance. Lastly, the toString() method should return a string with a number of dashes equal to the Runner object's distance, followed by their name. For example:

A Runner with name Amelia and distance run 15 should have a toString that returns:

`---------------Amelia`
(15 dashes, then the name "Amelia")


# RunnerDistancRuneComparator

The RunnerDistanceComparator class should implement the Comparator interface. Its compare method should first compare the two Runner objects' distances. If the distances are the same, the Runner objects' names should be compared instead. The distances should be sorted from greatest to least, and the names should be sorted alphabetically.

# Sorter

The Sorter class has one method partially implemented for you:
`public static void sort(Runner[] runners, Comparator<Runner> comp)`.

Your job is to implement one of the fast sorting algorithms in a separate method within the Sorter class, then call it from the sort method. You must use the Comparator object passed as a parameter to compare the Runner objects.

**You may not just use Arrays.sort() to sort the Runner array.**

# Footrace

This class is where you will actually simulate the footrace. It will hold your main method.

You must have an array of at least 15 Runner objects with different names. Your simulation should have as many time steps are as necessary for one runner to reach a distance of 50. At each time step, each Runner should run(), your array should be sorted with the Sorter.sort() method, and you should display all of the runners' progress.

Once a runner has won the race, there should be a message congratulating them and stating how many time cycles it took for them to win.
