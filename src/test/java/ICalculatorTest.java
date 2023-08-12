import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public interface ICalculatorTest<C extends ICalculator> {

    C getCalculator(); // this is a method declaration

    @Test
    default void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2,3));
    }

}


 class BasicCalculatorTest implements ICalculatorTest<BasicCalculator> {

    @Override
    public BasicCalculator getCalculator() {
        return new BasicCalculator();// this line is method implementation
    }
}

class AdvancedCalculatorTest implements ICalculatorTest<AdvancedCalculator> {

    @Override
    public AdvancedCalculator getCalculator() {
        return new AdvancedCalculator();
    }
}
