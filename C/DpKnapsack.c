#include <stdio.h>

// Function to find the maximum of two integers
int max(int a, int b) { 
    return (a > b) ? a : b; 
}

// Returns the maximum value that can be put in a knapsack of capacity W
int knapsack(int W, int wt[], int val[], int n) {
    int i, w;
    int K[n + 1][W + 1];

    // Build table K[][] in bottom-up manner
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= W; w++) {
            if (i == 0 || w == 0) {
                K[i][w] = 0; // Base case: no items or no capacity
            } else if (wt[i - 1] <= w) {
                // Max of (including the item) or (excluding the item)
                K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
            } else {
                // Item is heavier than current capacity, skip it
                K[i][w] = K[i - 1][w];
            }
        }
    }

    return K[n][W]; // The bottom-right cell contains the answer
}

int main() {
    int val[] = {60, 100, 120}; // Values of items
    int wt[] = {10, 20, 30};    // Weights of items
    int W = 50;                 // Knapsack capacity
    int n = sizeof(val) / sizeof(val[0]);

    printf("\n\nMaximum Value in Knapsack = %d\n", knapsack(W, wt, val, n));
    
    return 0;
}