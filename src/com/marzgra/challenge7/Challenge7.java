package com.marzgra.challenge7;

public class Challenge7 {
    /*
    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
    You can assume that the messages are decodable. For example, '001' is not allowed.
     */

    // recursive solution O(n^2)
    public static int countNumberForDecodedMessages(char[] data) {
        return calculateWays(data, data.length);
    }

    private static int calculateWays(char[] data, int numberOfLetters) {
        if (numberOfLetters == 0) return 1;
        int statingPoint = data.length - numberOfLetters;
        if (data[statingPoint] == '0') return 0;

        int result = calculateWays(data, numberOfLetters - 1);

        if (numberOfLetters >= 2 && data[statingPoint] == '1' ||
                data[statingPoint] == '2' && data[statingPoint + 1] <= '6') {
            result += calculateWays(data, numberOfLetters - 2);
        }
        return result;
    }

    public static void main(String[] args) {
        char[] data1 = {'1', '1', '1'}; // 3
        char[] data2 = {'1', '2', '3', '4'}; //3
        char[] data3 = {'1', '2'}; // 2
        char[] data4 = {'0', '2'}; // 0
        char[] data5 = {'2'}; // 1
        char[] data6 = {}; // 0

//        System.out.println(countNumberForDecodedMessages(data1));
//        System.out.println(countNumberForDecodedMessages(data2));
        System.out.println(countNumberForDecodedMessages(data3));
//        System.out.println(countNumberForDecodedMessages(data4));
//        System.out.println(countNumberForDecodedMessages(data5));
//        System.out.println(countNumberForDecodedMessages(data6));

        assert countNumberForDecodedMessages(data1) == 3;
        assert countNumberForDecodedMessages(data2) == 3;
        assert countNumberForDecodedMessages(data3) == 2;
        assert countNumberForDecodedMessages(data4) == 0;
        assert countNumberForDecodedMessages(data5) == 0;
        assert countNumberForDecodedMessages(data6) == 0;
    }
}
