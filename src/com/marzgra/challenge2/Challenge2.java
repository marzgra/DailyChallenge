package com.marzgra.challenge2;

import java.util.Arrays;

public class Challenge2 {

    /*
    Given an array of integers, return a new array such that each element at index i of the new array
    is the product of all the numbers in the original array except the one at i.
    For example, if our input was [1, 2, 3, 4, 5],
    the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     */

    public static void main(String[] args) {
        int[] numbers1 = {5, 10, 15, 20, 25};
        int[] numbers2 = {3, 2, 1};
        // with division
        System.out.println(Arrays.toString(productOfAllWithDivision(numbers1)));
        System.out.println(Arrays.toString(productOfAllWithDivision(numbers2)));

        // without division
        System.out.println(Arrays.toString(productOfAllWithoutDivision(numbers1)));
        System.out.println(Arrays.toString(productOfAllWithoutDivision(numbers2)));

    }

    private static int[] productOfAllWithDivision(int[] numbers) {
        if (numbers.length == 1) return numbers;
        int product = 1;

        for (int number : numbers) {
            product *= number;
        }

        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = product / numbers[i];
        }
        return result;
    }


    private static int[] productOfAllWithoutDivision(int[] numbers) {
        int n = numbers.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = numbers[i - 1] * left[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = numbers[i + 1] * right[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return result;

    }
}
