QUESTION:

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


ANSWER:

import java.util.*;
class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int leftProd = 1;
        for (int i = 0; i < n; i++) {
            leftProduct[i] = leftProd;
            leftProd *= nums[i];
        }
        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProduct[i] = rightProd;
            rightProd *= nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        
    }
}