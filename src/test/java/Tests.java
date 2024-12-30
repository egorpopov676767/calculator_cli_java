import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import static org.example.commands.CommandExecutor.tryExecute;

public class Tests {

    public void assertCommandResult(BigDecimal expected, String command) {
        assertEquals(
                expected,
                tryExecute(command.split("\\s+")).get());
    }

    public void assertCommandResult(int expected, String command) {
        assertCommandResult(new BigDecimal(expected), command);
    }

    public void assertCommandResult(String expected, String command) {
        assertCommandResult(new BigDecimal(expected), command);
    }

    @Test
    public void addTest() {
        assertCommandResult(4, "add 1 5 -2");
    }

    @Test
    public void subTest() {
        assertCommandResult("18.1", "sub 99 6 -5 79.9");
    }

    @Test
    public void mulTest() {
        assertCommandResult(
                "-346354142471624248012203204.85970181892785952555658011985986399520",
                "mul 1436264.685865 -5214.85688 46242734758738838.928235235283568863496999996");
    }

    @Test
    public void divTest() {
        assertCommandResult("-165443.818709563", "div 67898788 33 21984.235 -0.0005657");
    }

    @Test
    public void inputOutputTest() {
        Main.inputStream =new ByteArrayInputStream("add 3 6 7 \n div 99898.7 778786665.55 \n".getBytes());
        var output =new  ByteArrayOutputStream();
        Main.outputStream =new PrintStream(output) ;
        Main.main(new String[0]);
        assertEquals("16\r\n0.000128275\r\n", output.toString());
    }

}
