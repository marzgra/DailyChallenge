package com.marzgra;

import java.util.Arrays;

public class Challenge4 {
    /*
    Given an array of integers, find the first missing positive integer in linear time and constant space.
    In other words, find the lowest positive integer that does not exist in the array.
    The array can contain duplicates and negative numbers as well.
    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
    You can modify the input array in-place.
     */


    public static void main(String[] args) {
        int[] numbers1 = {3, 4, -1, 1};
        int[] numbers2 = {1, 2, 0};
        int[] numbers3 = {2, 3, -7, 6, 8, 1, -10, 15}; //result = 4

        System.out.println(findSmallestMissingPositive(numbers1));
        System.out.println(findSmallestMissingPositive(numbers2));
        System.out.println(findSmallestMissingPositive(numbers3));

        System.out.println("-------------------------");

        System.out.println(findSmallestMissingPositiveInLinearTime(numbers1));
        System.out.println(findSmallestMissingPositiveInLinearTime(numbers2));
        System.out.println(findSmallestMissingPositiveInLinearTime(numbers3));
    }

    // due to usage of Arrays.sort complexity of this solution is O(n log n)
    private static int findSmallestMissingPositive(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > 0 && numbers[i] > 0 && (numbers[i] - numbers[i - 1] > 1))
                return numbers[i - 1] + 1;
        }
        return numbers[numbers.length - 1] + 1;
    }

    private static int findSmallestMissingPositiveInLinearTime(int[] numbers) {
        int numberOfNegatives = separateNegativeNumbers(numbers);
        int size = numbers.length;

        // loop starts on first positive number
        for (int i = numberOfNegatives; i < size; i++) {
            if (Math.abs(numbers[i]) - 1 < size - numberOfNegatives &&
                    numbers[numberOfNegatives + (Math.abs(numbers[i]) - 1)] > 0) {

                numbers[numberOfNegatives + (Math.abs(numbers[i]) - 1)] *= (-1);
            }
        }

        for (int i = numberOfNegatives; i < size; i++) {
            if (numbers[i] > 0)
                return i + 1 - numberOfNegatives;
        }

        return size + 1 - numberOfNegatives;

    }

    private static int separateNegativeNumbers(int[] numbers) {
        int numberOfNegativeNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= 0) {
                int temp = numbers[i];
                numbers[i] = numbers[numberOfNegativeNumbers];
                numbers[numberOfNegativeNumbers] = temp;
                numberOfNegativeNumbers++;
            }
        }
        return numberOfNegativeNumbers;
    }
}
