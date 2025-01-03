import org.example.Main;
import org.example.commands.ExceptionResult;
import org.example.commands.NumberResult;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import static org.example.commands.CommandExecutor.tryExecute;

public class CalculatorTests {

    /**
     * Исполняет команду и сверяет результат
     */
    public void assertExecutionResult(BigDecimal expected, String command) {
        var commandResult = tryExecute(command.split("\\s+"));
        assertTrue(commandResult instanceof NumberResult);
        assertEquals(
                expected,
                ((NumberResult) commandResult).getResult());
    }

    public void assertExecutionResult(int expected, String command) {
        assertExecutionResult(new BigDecimal(expected), command);
    }

    public void assertExecutionResult(String expected, String command) {
        assertExecutionResult(new BigDecimal(expected), command);
    }

    public void assertException(String command) {
        var commandResult = tryExecute(command.split("\\s+"));
        assertTrue(commandResult instanceof ExceptionResult);
    }

    @Test
    public void addTest() {
        assertExecutionResult(4, "add 1 5 -2");
    }

    @Test
    public void subTest() {
        assertExecutionResult("18.1", "sub 99 6 -5 79.9");
    }

    @Test
    public void mulTest() {
        assertExecutionResult(
                "-346354142471624248012203204.85970181892785952555658011985986399520",
                "mul 1436264.685865 -5214.85688 46242734758738838.928235235283568863496999996");
    }

    @Test
    public void divTest() {
        assertExecutionResult("-165443.818709563", "div 67898788 33 21984.235 -0.0005657");
    }

    @Test
    public void sqrtTest() {
        assertExecutionResult("7.53525049", "sqrt 56.78");
        assertException("sqrt -2");
    }

    @Test
    public void powTest() {
        assertExecutionResult("6.249163873572453E+41", "pow 3 87.6");
        assertException("pow -89.9 1.3");
        assertException("pow 0 -1");
    }

    @Test
    public void wrongArgs() {
        assertException("sub");
        assertException("sub 90 7 8.9 b d");
        assertException("sqrt 45 67");
        assertException("pow 7.9");
        assertException("pow 7.9 12.3 5");
    }

    @Test
    public void wrongCommand() {
        assertException("asdf");
    }

    @Test
    public void inputOutputTest() {
        Main.inputStream = new ByteArrayInputStream("add 3 6 7 \n div 99898.7 778786665.55 \n".getBytes());
        var output = new ByteArrayOutputStream();
        Main.outputStream = new PrintStream(output);
        Main.main(new String[0]);
        assertEquals("16\r\n0.000128275\r\n", output.toString());
    }

}
