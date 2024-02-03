QUESTION:

242. Valid Anagram
Easy
Topics
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


ANSWER:

import java.util.*;
class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!charFrequency.containsKey(ch) || charFrequency.get(ch) == 0) {
                return false;
            }
            charFrequency.put(ch, charFrequency.get(ch) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "anagram", t1 = "nagaram";
        System.out.println(solution.isAnagram(s1, t1)); 

        String s2 = "rat", t2 = "car";
        System.out.println(solution.isAnagram(s2, t2));
    }
}