### 1、Selection Sort

```
arr[] = 12 10 16 11 9 7

// Find the minimum element in arr[0...5]
// and place it at beginning
7 10 16 11 9 12

// Find the minimum element in arr[1...5]
// and place it at beginning of arr[1...5]
7 9 16 11 10 12

// Find the minimum element in arr[2...5]
// and place it at beginning of arr[2...5]
7 9 10 11 16 12

// Find the minimum element in arr[3...5]
// and place it at beginning of arr[3...5]
7 9 10 11 16 12

// Find the minimum element in arr[4...5]
// and place it at beginning of arr[4...5]
7 9 10 11 12 16
```

![selectionSort](../../pic/Snipaste_2018-10-20_23-54-57.png)

```
void selectionSort(int arr[], int n){
    for(int i = 0 ; i < n ; i ++){
        // find the minimum element in [i, n)
        int minIndex = i;
        for( int j = i + 1 ; j < n ; j ++ )
            if( arr[j] < arr[minIndex] )
                minIndex = j;
                
        swap( arr[i] , arr[minIndex] );
    }
}
```

### 2、bubbleSort

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

![bubbleSort](../../pic/Bubble-sort-example-300px.gif)

```
void bubbleSort(int arr[], int size)
{
    int i, j;
    for (i = size - 1; i > 0; i--)
    {
        for (j = 0; j < i; j++)
        {
            if (arr[j] > arr[j + 1])
                swap(arr[j], arr[j+1]);
        }
    }
}

```

