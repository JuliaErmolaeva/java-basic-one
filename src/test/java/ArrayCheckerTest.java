import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.otus.java.basic.lesson30.ArrayChecker;

import java.util.Arrays;

public class ArrayCheckerTest {
    private ArrayChecker arrayChecker;

    @BeforeEach
    public void prepare() {
        arrayChecker = new ArrayChecker();
    }

    @CsvSource({
            "'[1, 2]', true",
            "'[1, 1]', false",
            "'[1, 2, 3]', false",
            "'[1, 2, 2, 1]', true"
    })

    @ParameterizedTest
    public void addTest(String arrayStr, boolean result) {
        String[] splitString = arrayStr.replace("[", "").replace("]", "")
                .split(",");
        var array = Arrays.asList(splitString)
                .stream()
                .mapToInt(c -> Integer.parseInt(c.toString().trim()))
                .toArray();

        Assertions.assertEquals(result, arrayChecker.existOnlyNumberOneAndTwo(array));
    }
}
