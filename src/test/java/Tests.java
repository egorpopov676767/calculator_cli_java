import org.example.Main;
import org.example.commands.CommandResult;
import org.example.commands.CommandsList;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Tests {

    public void assertCommandResult(BigDecimal expected, String command) {
        assertEquals(
                expected,
                CommandsList.tryExecute(command.split("\\s+")).get());
    }

    public void assertCommandResult(int expected, String command) {
        assertCommandResult(BigDecimal.valueOf(expected), command);
    }

    @Test
    public void test1() {
        assertCommandResult(8, "add 1 5 2");
    }

}
