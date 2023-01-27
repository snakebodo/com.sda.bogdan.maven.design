import ex1.AClass;
import org.junit.jupiter.api.Assertions;
class AClassTest {

    @org.junit.jupiter.api.Test
    void incrementNr() {
        AClass obj = new AClass();
        int actualValue = obj.incrementNr(5);
        int expectedValue = 6;
        Assertions.assertEquals(expectedValue, actualValue);
    }
}