import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void setupInitial(){
        System.out.println("Setting up a calculator for all tests");
    }

    @AfterAll
    public static void tearDownOnce(){
        System.out.println("Tearing down the calculator after the test once ****");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Setting up a new calculator to test");
        this.calculator = new Calculator();
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Tearing down the calculator after the test");
        this.calculator = null;
    }

    @Test
    public void testAdd() {
        int param1 = 2;
        int param2 = 4;
        int expected = 6;
        //Calculator calculator = new Calculator();
        int result = calculator.add(param1,param2);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "4, 5, 9",
            "3, 4, 7",
            "2, 4, 6",
            "50, -50, 0",
            "20, 5, 25",
            "120, 120, 240",
            "8, 3, 11",
            "-5, 2, -3",
            "10000, 9, 10009"
    })
    public void testAddParameterized(int a,int b,int expectedSum){
        //setup
        //validated
        //execute
        int result = calculator.add(a,b);
        assertEquals(expectedSum,result);
    }

    @Test
    public void testIsEven() {
        //setup
        //Calculator calculator = new Calculator();
        //initialize

        //execute
        assertTrue(calculator.isEven(2));
        assertFalse(calculator.isEven(3));

    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    public void testIsEvenParameterized(int number) {
        //setup
        //Calculator calculator = new Calculator();
        //initialize

        //execute
        assertTrue(calculator.isEven(number));
    }

    @Test
    public void testAddToArray() {
        //setup
        //Calculator calculator = new Calculator();
        int[] array = {1,2,3};
        int numToAdd = 2;
        //initialize
        //execute
        int[] result = calculator.addToArray(array,numToAdd);
        assertNotNull(result);
        assertArrayEquals(new int[] {3,4,5}, array);
        System.out.println(array);
    }

    @Test
    public void testdivide() {
        //setup
        int dividend = 2;
        int divisor = 2;
        double expected = 1;
        //initialize
        //execute
        double result = calculator.divide(dividend,divisor);
        assertEquals(expected,result);
    }

    @Test
    public void testDivideAssumption(){
        //setup
        int divisor;
        //initialize
        divisor = 0;
        //execute
        //Assume that divisor is not zero
        Assumptions.assumeTrue(divisor != 0);
        double result = calculator.divide(10,divisor);
        assertEquals(10,result);
    }

    @Test()
    public void testdivideOnException() {
        //setup
        int dividend = 2;
        int divisor = 0;
        double expected = 1;
        //initialize
        //execute
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            calculator.divide(dividend,divisor);
        });
    }

    @Test
    public void testMock(){
        //setting up a mock
         List mockList = mock(List.class);
         //stubbing the mock
        when(mockList.size()).thenReturn(10);
        when(mockList.get(anyInt())).thenReturn("element");
        when(mockList.get(1)).thenReturn("elementOne");
        doThrow(new RuntimeException()).when(mockList).clear();
        when((mockList.get(2))).thenThrow(new IndexOutOfBoundsException());
        //verify the mock
        mockList.add("one");
        verify(mockList).add("one");
        assertEquals(10,mockList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> mockList.get(2));

        //verify that the size method was calle exactly once
        verify(mockList,times(1)).size();
         //Execute
        System.out.println(mockList.size());
        System.out.println(mockList.get(0));
        System.out.println(mockList.get(1));
        //System.out.println(mockList.get(2));

    }

    @Nested
    class AdvancedFeatures{
        @BeforeEach
        void setUp(){
            System.out.println("some advanced setup");
        }

        @Test
        public void testSquareRoot(){
            assertEquals(3,calculator.sqrt(9));
        }

        @Test
        public void testMemory() {
            calculator.add(2,3);
            //this should store 5 in memory
            assertEquals(5,calculator.recall());
        }
    }
}