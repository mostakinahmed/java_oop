#include <stdio.h>

int main()
{
    int n, i, j;
    float w[20], p[20], r[20], cap, temp, profit = 0;

  
    printf("Enter number of items: ");
    scanf("%d", &n);

    printf("Enter weight and profit:\n");
    for (i = 0; i < n; i++)
    {
        scanf("%f %f", &w[i], &p[i]);
        r[i] = p[i] / w[i]; // ratio
    }

    printf("Enter capacity: ");
    scanf("%f", &cap);


    for (i = 0; i < n - 1; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (r[i] < r[j])
            {
                // swap ratio
                temp = r[i];
                r[i] = r[j];
                r[j] = temp;
                // swap weight
                temp = w[i];
                w[i] = w[j];
                w[j] = temp;
                // swap profit
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
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