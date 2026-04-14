#include <stdio.h>

int main()
{
    int n, amount;

    printf("Enter number of coins: ");
    scanf("%d", &n);

    int coins[n], count[n];

    printf("Enter coin denominations:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &coins[i]);
        count[i] = 0;
    }

    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (coins[i] < coins[j])
            {
                int t = coins[i];
                coins[i] = coins[j];
                coins[j] = t;
            }

    printf("Enter amount: ");
    scanf("%d", &amount);


    for (int i = 0; i < n; i++)
    {
        count[i] = amount / coins[i];
        amount %= coins[i];
    }

    if (amount != 0)
        printf("Exact change not possible\n");
    else
    {
        printf("Coins used:\n");
        for (int i = 0; i < n; i++)
            if (count[i] > 0)
                printf("%d coin(s) of %d\n", count[i], coins[i]);
    }

    return 0;
}