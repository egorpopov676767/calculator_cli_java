import org.example.Main;
import org.example.commands.CommandsList;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void test1() {
        assertEquals(8, CommandsList.tryExecute(new String[]{"add","1","5","2"}).get().intValue());
    }

}
