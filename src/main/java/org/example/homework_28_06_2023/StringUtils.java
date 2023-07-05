package org.example.homework_28_06_2023;

import java.util.Arrays;

public class StringUtils {

    /**
     * Реверсирует строку.
     *
     * @param input исходная строка
     * @return реверсированная строка
     */
    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    /**
     * Проверяет, является ли строка палиндромом.
     *
     * @param input исходная строка
     * @return true, если строка является палиндромом, иначе false
     */
    public static boolean isPalindrome(String input) {
        String reversed = reverse(input);
        return input.equalsIgnoreCase(reversed);
    }

    /**
     * Подсчитывает количество вхождений символа в строку.
     *
     * @param input  исходная строка
     * @param target символ, количество которого нужно подсчитать
     * @return количество вхождений символа в строку
     */
    public static int countOccurrences(String input, char target) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * Удаляет повторяющиеся символы из строки.
     *
     * @param input исходная строка
     * @return строка без повторяющихся символов
     */
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (result.indexOf(String.valueOf(currentChar)) == -1) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    /**
     * Разделяет строку на подстроки по указанному разделителю.
     *
     * @param input     исходная строка
     * @param delimiter разделитель
     * @return массив подстрок
     */
    public static String[] splitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    /**
     * Проверяет, являются ли две строки анаграммами.
     *
     * @param input1 первая строка
     * @param input2 вторая строка
     * @return true, если строки являются анаграммами, иначе false
     */
    public static boolean isAnagram(String input1, String input2) {
        String sortedInput1 = sortString(input1);
        String sortedInput2 = sortString(input2);
        return sortedInput1.equalsIgnoreCase(sortedInput2);
    }

    /**
     * Вспомогательный метод для сортировки символов в строке.
     *
     * @param input исходная строка
     * @return отсортированная строка
     */
    private static String sortString(String input) {
        char[] chars = input.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
