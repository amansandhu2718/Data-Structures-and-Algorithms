public int climbStairs(int n) {
    // Create a memo array to store results for each step
    // We use n + 1 so the index matches the step number
    int[] memo = new int[n + 1];
    return climb(n, 0, memo);
}

public int climb(int dst, int src, int[] memo) {
    if (src > dst) {
        return 0;
    }
    if (dst == src) {
        return 1;
    }

    // If we already calculated this step, just return it!
    if (memo[src] != 0) {
        return memo[src];
    }

    int count = 0;
    for (int i = 1; i <= 2; i++) {
        count = count + climb(dst, src + i, memo);
    }

    // Save the result in the memo before returning
    memo[src] = count;
    return count;
}

class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}