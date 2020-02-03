package com.marzgra.challenge1;

public class Challenge1 {
    /*
    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    Bonus: Can you do this in one pass?
     */

    public static void main(String[] args) {
        int[] numbers = {10, 15, 3, 7};
        int sum = 10;
        System.out.println(doesAnyTwoNumbersSumUpTo(numbers, sum));
    }

    private static boolean doesAnyTwoNumbersSumUpTo(int[] numbers, int sum) {
        for(int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum) {
                    System.out.println(numbers[i] + " + " + numbers[j] + " = " + sum);
                    return true;
                }
            }
        }
        return false;
    }
}
