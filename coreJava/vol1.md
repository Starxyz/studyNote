运算符*>>>*表示用0填充高位

*>>*或*<<*用符号位来填充

没有*<<<*运算符

构建字符串 StringBuilder， 采用字符串连接的方式比较低效，每次连接都会构建一个新的String 对象， 所以用StringBuilder来避免这个问题。

```java
StringBuilder builder = new StringBuilderO;
builder.append(ch); // appends a single character
bui1der.append(str); // appends a string

// get string
String completedString = builder.toStringO;
```

