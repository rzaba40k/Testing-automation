import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void isAddWorking() {
        Assertions.assertEquals(10, Calculator.add(4, 6));
        Assertions.assertFalse(Calculator.add(4, 6) != 10);
    }
    @Test
    @Disabled("Wlaczyc do zestawu po zafixowaniu")
    void isSubtractWorking(){
        Assertions.assertEquals(4,Calculator.subtract(8,4));
        Assertions.assertEquals(2, Calculator.subtract(4, 2));
    }
    @Test
    void isMultiplyWorking(){
        Assertions.assertEquals(12,Calculator.multiply(4,3));
        Assertions.assertEquals(9, Calculator.multiply(3, 3));
    }
}
