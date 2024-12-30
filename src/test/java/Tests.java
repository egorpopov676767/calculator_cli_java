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

public class Tests {

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
    public void noValues() {
        assertException("sub");
    }

    @Test
    public void wrongValues() {
        assertException("sub 90 7 8.9 b d");
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
