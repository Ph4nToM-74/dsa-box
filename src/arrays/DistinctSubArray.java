package arrays;

import java.util.HashMap;
import java.util.Map;

// LeetCode Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Solution Link: https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Sliding Window with Set; Time Complexity: O(2 * N)
// Approach #3: Sliding Window with Map; Time Complexity: O(N)

public class DistinctSubArray {

    public int compute(String str) {

        Map<Character, Integer> window = new HashMap<>();

        int ans = 0, left = 0, right = 0;
        int size = str.length();

        if (size <= 1) return size;

        while (right < size) {

            char ch = str.charAt(right);
            int temp = window.getOrDefault(ch, -1);

            if (temp >= left) left = temp + 1;
            
            window.put(ch, right++);

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}