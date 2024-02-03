QUESTION:


3. Longest Substring Without Repeating Characters
Medium
Topics
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

ANSWER:
import java.util.HashMap;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0, right = 0;
        while (right < n) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
            }

            maxLength = Math.max(maxLength, right - left + 1);
            charIndexMap.put(currentChar, right);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Example usage:
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));  

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));  

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); 
    }
}
