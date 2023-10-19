import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.java.basic.lesson30.ArrayChecker;

import java.util.stream.Stream;

public class ArrayCheckerTest {

    private static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, true),
                Arguments.of(new int[]{1, 1}, false),
                Arguments.of(new int[]{1, 2, 3}, false),
                Arguments.of(new int[]{1, 2, 2, 1}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void addTest(int[] array, boolean result) {
        Assertions.assertEquals(result, ArrayChecker.existOnlyNumberOneAndTwo(array));
    }
}
