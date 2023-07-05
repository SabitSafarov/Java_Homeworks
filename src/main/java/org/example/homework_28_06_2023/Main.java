package org.example.homework_28_06_2023;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Примеры использования методов из класса StringUtils

        // Метод reverse
        String reversed = StringUtils.reverse("Hello, world!");
        System.out.println("Reversed string: " + reversed);

        // Метод isPalindrome
        boolean palindrome = StringUtils.isPalindrome("racecar");
        System.out.println("Is palindrome? " + palindrome);

        // Метод countOccurrences
        int occurrences = StringUtils.countOccurrences("abracadabra", 'a');
        System.out.println("Occurrences of 'a': " + occurrences);

        // Метод removeDuplicates
        String withoutDuplicates = StringUtils.removeDuplicates("Mississippi");
        System.out.println("String without duplicates: " + withoutDuplicates);

        // Метод splitByDelimiter
        String[] substrings = StringUtils.splitByDelimiter("Hello,world,Java", ",");
        System.out.println("Substrings: " + Arrays.toString(substrings));

        // Метод isAnagram
        boolean anagram = StringUtils.isAnagram("listen", "silent");
        System.out.println("Is anagram? " + anagram);
    }
}