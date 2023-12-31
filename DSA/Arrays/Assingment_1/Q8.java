/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

**Example 1:**
Input: nums = [1,2,2,4]
Output: [2,3]

 */

public class Q8 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 1, 2, 2, 4 };
        int[] res = sol.findMismatched(arr);
        System.out.print("[ ");
        for (int i : res) {
            System.out.print(i + ",");
        }
        System.out.print(" ]");
    }
}

class Solution {
    public int[] findMismatched(int[] nums) {
        int N = nums.length, sum = N * (N + 1) / 2;
        int[] ans = new int[2];
        boolean[] seen = new boolean[N + 1];
        for (int num : nums) {
            sum -= num;
            if (seen[num])
                ans[0] = num;
            seen[num] = true;
        }
        ans[1] = sum + ans[0];
        return ans;
    }
}