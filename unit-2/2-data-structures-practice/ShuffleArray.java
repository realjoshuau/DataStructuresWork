/*
 * 
 * Write a Java method shuffleArray that accepts an array of String elements as a parameter
 * and returns a new array of those elements in a random order. 
 * The algorithm should repeatedly select and remove a remaining element 
 * from the original array and place that element at the end of the resulting array. 
 * This method will destroy the contents of the original array.
 */

import java.util.Random;

public class ShuffleArray {
    public static String[] shuffleArray(String[] arr) {
        String[] newStrArr = new String[arr.length];
        // Use this variable to generate random numbers.
        // rand.nextInt(<number>) will generate a random int between 0 and <number>.
        // """
        /// IMPORTANT: THE AUTOGRADER IS CHECKING AGAINST CODE WITH A SEED OF 100.
        // CHANGE THE
        // CONSTRUCTOR CALL TO Random(100) WHEN CHECKING AGAINST THE AUTOGRADER.
        // """
        Random rand = new Random(100);
        for (int i = 0; i < arr.length; i++) {
            int randIndex = rand.nextInt(arr.length);
            while (arr[randIndex] == null) {
                randIndex = rand.nextInt(arr.length);
            }
            newStrArr[arr.length - i - 1] = arr[randIndex];
            arr[randIndex] = null;
        }
        return newStrArr;
    }

    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] strArr = new String[10];
        for (int i = 0; i < 10; i++) {
            strArr[i] = "" + i;
        }
        printArr(strArr);
        String[] newStrArr = shuffleArray(strArr);
        printArr(strArr);
        printArr(newStrArr);
    }
}