import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    public void testUsingMock() {
        //setup
        ICalculator mockCalculator = mock(BasicCalculator.class);
        //stub the mock
        when(mockCalculator.subtract(5,5)).thenReturn(10);
        //execute
        int result = mockCalculator.subtract(5,5);
        Assertions.assertEquals(10,result);
        //Assertions.assertEquals(0,result);
    }
    @Test
    public void testUsingSpy() {
        //setup
        BasicCalculator basicCalculator = new BasicCalculator();
        //spy the basicCalculator
        BasicCalculator spyCalculator = spy(basicCalculator);

        //you can optionally override behaviour
        doReturn(10).when(spyCalculator).subtract(5,5);

        //Execute
        int result = spyCalculator.subtract(5,5);
        Assertions.assertEquals(10,result);
        int anotherResult = spyCalculator.subtract(10,5);
        Assertions.assertEquals(5,anotherResult);
    }

    @Test
    public void testAdvancecalc() throws Exception{

    }
}
