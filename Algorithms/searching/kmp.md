```c++
void getNextArr(string match, int next[])
{
    int n = match.length();
    if (n == 1)
    {
        next[0] = -1;
        return;
    }    
    next[0] = -1;
    next[1] = 0;
    int cn = 0;
    int pos = 2;
    while (pos < n)
    {
        if (match[pos-1] == match[cn])
            next[pos++] = ++cn;
        else if (cn > 0)
            cn = next[cn];
        else
            next[pos++] = 0;
    }
    
}
```

```c++
int kmp(string text, string match)
{
    int n = text.length();
    int m = match.length();
    int next[m];
    getNextArr(match, next);
   
    int mi = 0;
    int si = 0;
    while (si < n && mi < m)
    {
        if (text[si] == match[mi])
        {
            si++;
            mi++;
        }
        else if (next[mi] == -1)
            si++;
        else
            mi = next[mi];
    }
    return mi == m ?  si - mi : -1;
}
```

