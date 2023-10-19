import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.java.basic.lesson30.ArrayTrimmer;

public class ArrayTrimmerTest {

    @Test
    public void successTrimArrayTest() {
        int[] array = {1, 2, 5, 1, 3, 2, 6};
        int[] expected = {3, 2, 6};
        Assertions.assertArrayEquals(expected, ArrayTrimmer.trimArrayAfterLastNumberOne(array));
    }

    @Test
    public void failedArrayDoesNotExistNumberOneTest() {
        int[] array = {2, 3, 4, 5};
        Assertions.assertThrows(RuntimeException.class, () -> ArrayTrimmer.trimArrayAfterLastNumberOne(array));
    }
}
