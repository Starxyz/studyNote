### new to me

*"\\\PL+"*  Essentially all "non-letters". *+* match one or more

```java
static <T> Stream<T> 
of(T... values)
    //产生一个元素为定值的流
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);
	output：song: gently, down, the, stream
        
empty()
    //产生一个不包含任何元素的流
    Stream<String> silence = Stream.empty();
    show("silence", silence);
    output：silence：
    
generate(Supplier<T> s)
    //产生一个无限流, 它的值通过反复调用函数s而构建
    Stream<String> echos=Stream.generate(()->"Echo");
	show("echos", echos);
	output：echos: Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, ...
        
iterate(T seed, UaryOperator<T> f)
    //产生一个无限流， 他的元素包含种子、在种子上调用f产生的值、在前一个元素上调用f产生的值，etc...
    Stream<BigInteger> integers=Stream.iterate(BigInteger.ONE, n->n.add(BigInteger.ONE));
    show("integers", integers);
	output：integers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...

```

