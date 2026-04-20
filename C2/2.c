#include <stdio.h>

int main()
{
    int n, i, j;
    float w[20], p[20], r[20], cap, profit = 0;

    float right, tempWieght, keyProfit;

    printf("Enter number of items: ");
    scanf("%d", &n);

    printf("Enter weight:\n");
    for (i = 0; i < n; i++)
    {
        scanf("%f", &w[i]);
    }

    printf("Enter profit:\n");
    for (i = 0; i < n; i++)
    {
        scanf("%f", &p[i]);
    }

    for (i = 0; i < n; i++)
    {
        r[i] = p[i] / w[i];
    }

    printf("Enter capacity: ");
    scanf("%f", &cap);

    for (i = 1; i < n; i++)
    {
        right = r[i];
        tempWieght = w[i];
        keyProfit = p[i];
        j = i - 1;

        while (j >= 0 && r[j] < right)
        {
            r[j + 1] = r[j];
            w[j + 1] = w[j];
            p[j + 1] = p[j];
            j = j - 1;
        }

        r[j + 1] = right;
        w[j + 1] = tempWieght;
        p[j + 1] = keyProfit;
    }

    for (i = 0; i < n && cap > 0; i++)
    {
        if (w[i] <= cap)
        {
            profit += p[i];
            cap -= w[i];
        }
        else
        {
            profit += (p[i] / w[i]) * cap;
            break;
        }
    }

    printf("Maximum Profit = %.2f\n", profit);
    return 0;
}