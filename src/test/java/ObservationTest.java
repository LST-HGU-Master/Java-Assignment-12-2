import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Date;

public class ObservationTest {

    @Test
    public void testWaitHour()
    {
        // action
        Observation o = new Observation();
        // assertion
        assertEquals(0, o.waitHour);
        // action
        o.waitHour = 95;
        // assertion
        assertEquals(95, o.waitHour);
    }

    @Test
    public void testGetReactionTime()
    {
        // action
        Observation o = new Observation();
        o.waitHour = 31;
        Date now = new Date(1625192525000L);

        // assertion
        assertEquals("7/3 18時22分05秒", o.getReactionTime(now));

        // action
        o.waitHour = 100;
        now = new Date(1625192525000L);

        // assertion
        assertEquals("7/6 15時22分05秒", o.getReactionTime(now));
    }
}
