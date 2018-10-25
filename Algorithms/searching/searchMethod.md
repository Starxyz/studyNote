### 1、binarySearch

![binarySearch](../../pic/binary-and-linear-search-animations.gif)

```c++
int binarySearch(int arr[], int n, int target)
{
    int l = 0;
    int r = n - 1;
    while (l <= r)
    {
        int m = l + (r - l) / 2;
        if (arr[m] == target)
            return m;
        if (target < arr[m])
            r = m - 1;//arr[l...m-1]
        else 
            l = m + 1;//arr[m+1...r]
    }
    return -1;//target not found!
}
```

```c++
int binarySearch(int arr[], int n, int target)
{
    int l = 0;
    int r = n;
    while (l < r)
    {
        int m = l + (r - l) / 2;
        if (arr[m] == target)
            return m;
        if (target < arr[m])
            r = m ;//arr[l...m)
        else 
            l = m + 1;//arr[m+1...r)
    }
    return -1;//target not found!
}
```

