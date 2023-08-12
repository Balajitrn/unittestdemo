import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorDynamicTest {

    private final Calculator calculator = new Calculator();

    @TestFactory
    public Stream<DynamicTest> dynamicTestsForAddition(){
        // list the input and the expected outpout
        List<Arguments> testCasesList =
                Arrays.asList(
                        Arguments.of(1, 2, 3),
                        Arguments.of(5, 5, 10),
                        Arguments.of(-3, 3, 0)
                );

        // Return a stream of Dynamic Tests
        return testCasesList.stream()
                .map(testCases -> DynamicTest.dynamicTest(
                        "Additiona test for "+ testCases.get()[0] + " + " + testCases.get()[1],
                        () -> {
                            int a = (int) testCases.get()[0];
                            int b = (int) testCases.get()[1];
                            int expected = (int) testCases.get()[2];
                            Assertions.assertEquals(expected,calculator.add(a,b));
                        }));
    }

    @ParameterizedTest
    @MethodSource("additionProvider")
    public void testAddParameterized(int a, int b, int expected){
        Assertions.assertEquals(expected,calculator.add(a,b));
    }

    public static Stream<Arguments> additionProvider(){
        return  Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(5,5,10),
                Arguments.of(-3,3,0)
        );
    }
}
