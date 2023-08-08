package ca.jrvs.apps.practice;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class LSEITest {

    private List<String> stringList = Arrays.asList("Linkin Park", "Metallica", "Foo Fighters", "Dream Theater");
    private List<String> uppercaseList = Arrays.asList("LINKIN PARK", "METALLICA", "FOO FIGHTERS", "DREAM THEATER");
    private Stream<String> stringStream = stringList.stream();
    private List<List<Integer>> integerLists = Arrays.asList(
            Arrays.asList(2, 4, 6, 8, 10),
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(4, 9, 16, 25, 36),
            Arrays.asList(2, 3, 4, 5, 6)
    );
    private int[] integerArray = {2, 4, 6, 8, 10};
    private Stream<Integer> integerStream = integerLists.get(0).stream();

    LambdaStreamExcImp lse = new LambdaStreamExcImp();

    @Test
    public void testCreateStrStream() {
        Stream<String> resultStream = lse.createStrStream(stringList.toArray(new String[0]));

        String[] resultArray = resultStream.toArray(String[]::new);

        assertArrayEquals(stringList.toArray(), resultArray);
    }

    @Test
    public void testToUpperCase() {
        Stream<String> resultStream = lse.toUpperCase(stringList.toArray(new String[0]));

        String[] resultArray = resultStream.toArray(String[]::new);

        assertArrayEquals(uppercaseList.toArray(), resultArray);
    }

    @Test
    public void testFilter() {
        Stream<String> resultStream = lse.filter(stringList.stream(), "Foo Fighters");

        String result = resultStream.findFirst().orElse(null);

        assertEquals(stringList.get(2), result);
    }

    @Test
    public void testCreateIntStream() {
        IntStream resultStream = lse.createIntStream(integerArray);

        List<Integer> resultList = resultStream.boxed().collect(Collectors.toList());

        assertEquals(integerLists.get(0), resultList);
    }

    @Test
    public void testToListGeneric() {
        List<String> resultList = lse.toList(stringStream);

        assertEquals(stringList, resultList);
    }

    @Test
    public void testToListInteger() {
        List<Integer> resultList = lse.toList(integerStream);

        assertEquals(integerLists.get(0), resultList);
    }

    @Test
    public void testCreateIntStreamRange() {
        IntStream resultStream = lse.createIntStream(1, 5);

        assertEquals(integerLists.get(1), lse.toList(resultStream));
    }

    @Test
    public void testSquareRootIntStream() {
        int[] intArray = integerLists
                .get(2).stream()
                .mapToInt(Integer::intValue)
                .toArray();

        DoubleStream resultStream = lse.squareRootIntStream(lse.createIntStream(intArray));

        assertEquals(integerLists.get(3), resultStream.mapToInt(number -> (int) number).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testGetOdd() {
        int[] expectedAnswer = {1,3,5,7,9};
        IntStream intStream = lse.createIntStream(0,10);
        IntStream resultStream = lse.getOdd(intStream);

        assertArrayEquals(expectedAnswer, resultStream.toArray());
    }

    @Test
    public void testGetLambdaPrinter() {
        String prefix = "start: ";
        String suffix = " END";

        ByteArrayOutputStream outputStream;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Consumer<String> lambdaPrinter = lse.getLambdaPrinter(prefix, suffix);

        lambdaPrinter.accept("Hello World");
        System.setOut(System.out);

        String capturedOutput = outputStream.toString();
        String expectedOutput = "start: Hello World END";

        assertEquals(expectedOutput, capturedOutput.trim());

    }

    @Test
    public void testPrintMessages() {
        String prefix = "start: ";
        String suffix = " END";

        ByteArrayOutputStream outputStream;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Consumer<String> lambdaPrinter = lse.getLambdaPrinter(prefix, suffix);

        lse.printMessages(stringList.toArray(new String[0]), lambdaPrinter);

        System.setOut(System.out);

        String capturedOutput = outputStream.toString().trim();
        String[] lines = capturedOutput.split(System.lineSeparator());
        List<String> capturedOutputList = new ArrayList<>();
        for (String line : lines) {
            capturedOutputList.add(line);
        }

        List<String> expectedOutput = new ArrayList<>();
        for (String line : stringList) {
            expectedOutput.add(prefix + line + suffix);
        }

        assertEquals(expectedOutput, capturedOutputList);
    }

    @Test
    public void testPrintOdd() {
        int[] expectedValues = {1,3,5,7,9};
        String prefix = "Number: ";
        String suffix = " !";

        Consumer<String> lambdaPrinter = lse.getLambdaPrinter(prefix, suffix);

        ByteArrayOutputStream outputStream;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lse.printOdd(lse.createIntStream(0,10), lambdaPrinter);

        System.setOut(System.out);

        String capturedOutput = outputStream.toString().trim();
        String[] lines = capturedOutput.split(System.lineSeparator());
        List<String> capturedOutputList = new ArrayList<>();
        for (String line : lines) {
            capturedOutputList.add(line);
        }

        List<String> expectedOutput = new ArrayList<>();
        for (Integer line : expectedValues) {
            expectedOutput.add(prefix + line + suffix);
        }

        assertEquals(expectedOutput, capturedOutputList);
    }

    @Test
    public void testFLatNestIntFlatMapImp() {

        List<List<Integer>> listNumbers = new ArrayList<>();
        List<Integer> expectedResult = Arrays.asList(4, 9, 16, 25, 36, 49, 64, 81, 100);

        listNumbers.add(Arrays.asList(2, 3, 4, 5, 6));
        listNumbers.add(Arrays.asList(7, 8, 9, 10));

        Stream<Integer> resultStream = lse.flatNestedIntFlatMapImp(listNumbers.stream());

        assertEquals(expectedResult, resultStream.collect(Collectors.toList()));
    }
}
