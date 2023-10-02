import java.io.*;
import java.util.*;
class BuyStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int startIndex = 0;
        int i = 0;
        int cost = 0, maxCost = 0;
        while (i < n - 1) {
            while (i < n - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            for (int j = startIndex; j < i; j++) {
                maxCost += prices[i] - prices[j];
            }
            if (i < n - 1) {
                i++;
                startIndex = i;
            }
        }
        return maxCost;
    }
    // Driver Code
    public static void main(String[] args) {
        // stock prices on consecutive days
        int prices[] = {5, 2};
        System.out.print(maxProfit(prices));

    }
}