package ca.jrvs.apps.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;

public class LambdaStreamExcImp implements LambdaStreamExc{
    @Override
    public Stream<String> createStrStream(String ... strings) {
        return Arrays.stream(strings);
    }

    @Override
    public Stream<String> toUpperCase(String ... strings) {
        return createStrStream(strings)
                .map(String::toUpperCase);
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return stringStream.filter(element -> element.contains(pattern));
    }

    @Override
    public IntStream createIntStream(int[] arr) {
        return Arrays.stream(arr);
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        return intStream.boxed().collect(Collectors.toList());
    }

    @Override
    public IntStream createIntStream(int start, int end) {
        return IntStream.rangeClosed(start, end);
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return intStream.mapToDouble(element -> sqrt(element));
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        return intStream.filter(element -> element % 2 == 1);
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return message -> System.out.println(prefix + message + suffix);
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {
        Stream.of(messages).forEach(printer);
    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {
        getOdd(intStream).boxed().forEach(number -> printer.accept(number.toString()));
    }

    @Override
    public Stream<Integer> flatNestedIntFlatMapImp(Stream<List<Integer>> ints) {
        return ints
                .flatMap(List::stream)
                .map(i -> i * i);
    }

    @Override
    public Stream<Integer> flatNestedIntForEachImp(Stream<List<Integer>> ints) {
        List<Integer> result = new ArrayList<>();
        ints.forEach(list -> list.forEach(i -> result.add(i * i)));
        
        return result.stream();
    }
}
