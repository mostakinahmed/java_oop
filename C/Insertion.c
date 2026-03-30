#include <stdio.h>

void insertionSort(int data[], int size)
{
    for (int i = 1; i < size; ++i)
    {
        int key = data[i];
        int j = i - 1;

        while (j >= 0 && data[j] > key)
        {
            data[j + 1] = data[j];
            j = j - 1;
        }
        data[j + 1] = key;
    }
}

int main()
{
    int data[] = {1, 5,8, 13, 9, 15};
    int size = 6;  

    insertionSort(data, size);

    for (int i = 0; i < size; ++i)
        printf("%d ", data[i]);

    printf("\n");

    return 0;
}
