
#include <stdio.h>

int Linear(int data[], int size, int value)
{

  for (int i = 0; i < size; i++)
  {
    if (data[i] == value)
      return i;
  }
  return -1;
}

int main()
{
  int data[] = {6, 1, 4, 3, 8};
  int size = 5;
  int value = 8;
  int result = Linear(data, size, value);

  if (result == -1)
  {
    printf("\nData not found");
  }
  else
  {
    printf("\nData found at index: %d\n", result);
  }
}