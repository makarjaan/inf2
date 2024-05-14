import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.inf304.JsonMain;

import java.io.FileNotFoundException;
import java.io.IOException;


public class JsonMainTest {
    @Test
    public void testCheckBrackets() throws Exception {
        Assert.assertEquals(1, JsonMain.checkBrackets("C:\\Java\\infSecond\\staples.json"));
    }

    @Test(expected = FileNotFoundException.class)
    public void testNotFoundException() throws IOException {
        JsonMain.checkBrackets("C:\\Java\\infSecond\\staples3.json");
    }

    @Test(expected = NullPointerException.class)
    public void testCheckNullPointerException() throws IOException {
        JsonMain.checkBrackets("");
    }

    @Test(expected = RuntimeException.class)
    public void testRuntimeException() throws IOException {
        JsonMain.checkBrackets("C:\\Java\\infSecond\\staples2.json");
    }
}
