#include <stdio.h>

int binary(int data[], int size, int value)
{
    int l = 0;
    int h = size - 1;

    while (l <= h)
    {
        int mid = l + (h - l) / 2;

        if (data[mid] == value)
            return mid;

        if (data[mid] < value)
            l = mid + 1;
        else
            h = mid - 1;
    }

    return -1;
}

int main()
{
    int data[] = {6, 7, 9, 10, 15};
    int size = 5;     
    int value = 7;

    int result = binary(data, size, value);

    (result == -1)
        ? printf("Element is not present in array")
        : printf("\nElement is present at index %d\n\n", result);

    return 0;
}
