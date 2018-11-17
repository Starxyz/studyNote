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

![selectionSort](../../pic/Selection-Sort-Animation.gif)

```c++
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

```c++
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

**Optimized Implementation:**
[The above function always runs O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.](https://www.geeksforgeeks.org/bubble-sort/)

```c++
void bubbleSort(int arr[], int size)
{
    int i, j;
    bool swapped;
    for (i = size - 1; i > 0; i--)
    {
    	swapped = false;
        for (j = 0; j < i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j+1]);
                swapped = true;
            }            
        }
        //if no elements were swapped by inner loop, then break
        if (!swapped)
            break;
    }
}
```

### 3、insertionSort

Insertion sort is simple to implement and a stable sorting algorithm. During the process of sorting, it creates a sorted subsequence. 

![insertionSort](../../pic/Insertion-sort-example.gif)

```c++
void insertSort(int arr[], int n)
{   
    for (i = 1; i <= n; i++)
    {
        int temp = arr[i];
        int j;
        for (j = i; j > 0 && temp < arr[j-1]; j--)
        	arr[j] = arr[j-1];        
    	arr[j] = temp;
    }    
}
```

__application__: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

__Optimized__ : use binary search to find the proper location to insert.

### 4、mergeSort

Merge sort uses the **divide and conquer** philosophy. 

1. Divide the unsorted list into *n* sublists, each containing 1 element (a list of 1 element is considered sorted).

2. Repeatedly [merge](https://en.wikipedia.org/wiki/Merge_algorithm) sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.

   ![mergeSort](../../pic/Merge-sort-example-300px.gif)


```c++
void mergeSort(int arr[], int l, int r) {
    if (l < r)   {
        int m = l+(r-l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
}
/* use two pointer for sorting */
void merge(int arr[], int l, int m, int r)
{
     vector<int> nums(r-l+1);
     int left = l;
     int right = m + 1;
     int i;
     for (i = 0; left <= m && right <= r; i++)
         nums[i] = arr[left] < arr[right] ? arr[left++] : arr[right++];
    
     while (left <= m)
         nums[i++] = arr[left++];
     while (right <= r)
         nums[i++] = arr[right++];
     for (i = 0; i < nums.size(); i++)
         arr[l++] = nums[i];
}
```

**Auxiliary Space:** O(n)

### 5、quickSort

QuickSort is a __Divide and Conquer__ algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

![quickSort](../../pic/Quicksort-example.gif)



![quickSort1](../../pic/Sorting_quicksort_anim.gif)



```c++
int partition(int arr[], int l, int r) {
    int key = arr[l];
    int j = l;// arr[l+1,...j] < key, arr[j+1,...i] > v
    for (int i = l+1; i <= r; i++) {
        if (arr[i] < key)
            swap(arr[++j], arr[i]);//i is the current position
    }
    swap(arr[l], arr[j]);
    return j;
}

void quickSort(int arr[], int l, int r) {
    if (l >= r)
        return;
    int posi = partition(arr, l, r);
    quickSort(arr, l, posi-1);
    quickSort(arr, posi+1, r);
}

void quickSort(int arr[], int n){
    quickSort(arr, 0, n-1);
}
```

comparing to merge sort, quick sort doesn't require any extra storage. 

There are some ways to improved quick sort, such as 3 way quick sort, etc.

### 6、heapSort

![quickSort1](../../pic/Heapsort-example.gif)

1. maintaining the max-heap property in a tree where both sub-trees are max-heaps, we need to run heapify on the root element repeatedly until it is larger than its children or it becomes a leaf node.

   ```c++
   void heapify(int arr[], int n, int i)  {
         int largest = i;
         int l = 2*i + 1;
         int r = 2*i + 2;
         
         if (l < n && arr[l] > arr[largest])
           largest = l;
           
         if (r < n && arr[r] > arr[largest])
           largest = r;
           
         if (i != largest) {
             swap(arr[i], arr[largest]);
             heapify(arr, n, largest);
         }
   }
   ```

2. building a max-heap from any tree. 

   ```c++
   
   void buildHeap(int arr[], int n)  { 
       for (int i = n/2 - 1; i >= 0; i--)//all nodes after i is leaf, they don't need to heapify
           heapify(arr, n, i);
   }
   ```

3. heapSort

- Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.

- Remove the root element and put at the end of the array (nth position) Put the last item of the tree (heap) at the vacant place.

- Reduce the size of the heap by 1 and heapify the root element again so that we have highest element at root.

- The process is repeated until all the items of the list is sorted.

```c++
void heapSort(int arr[], int n)
{
    buildHeap(arr, n);
    for (int i=n-1; i>=0; i--)
    {
        swap(arr[0], arr[i]);
        heapify(arr, i, 0);
    }
}
```



