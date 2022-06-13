import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.fail;
/**
 * @version (20220613)
 *  注意）このテストコードは Observationクラスにフィールド waitHour と getReactionTime()が定義されるまでエラーとなる
 */
public class ObservationTest {

    @Test
    public void testWaitHour()
    {
        // action
        Observation o = new Observation();
        // assertion
        assertEquals(0, o.waitHour, "ObservationクラスのフィールドwaitHourの初期値が不正です!");
        // action
        o.waitHour = 95;
        // assertion
        assertEquals(95, o.waitHour,"ObservationクラスのフィールドwaitHourの宣言が不正かもしれません!");
    }

    @Test
    public void testGetReactionTime()
    {
        // action
        Observation o = new Observation();
        o.waitHour = 31;
        Date now = new Date(1625192525000L);

        // assertion
        assertEquals("7/3 18時22分05秒", o.getReactionTime(now),"反応完了の時刻表示が不正です!");
 
        // action
        o.waitHour = 100;
        now = new Date(1625192525000L);

        // assertion
        assertEquals("7/6 15時22分05秒", o.getReactionTime(now),"反応完了の時刻表示が不正です!");
    }
    
    @Test
    public void testGetReactionTimeFormat()
    {
        // action
        Observation o = new Observation();
        o.waitHour = 0;
        Date myTime = new Date(1625260088000L);

        String outStr =  o.getReactionTime(myTime);
        String numStrs[] =  outStr.replaceAll("[^\\d]"," ").split(" ");
        String unit[] = {"月", "日", "時", "分", "秒"};
        try {
            for(int i=2; i<5; i++) {
                if (numStrs[i].length() != 2) fail( "was: <" + outStr + "> " + unit[i]+"は2ケタ表示になっていません!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("月、日、時、分、秒のどれかが不足しているもしくは、月が文字表示かもしれません!");
        }
        
        Date yourTime = new Date(1625212525000L);
        String outStr2 =  o.getReactionTime(yourTime);
        // assertion
        try {
            assertEquals("7/2 16時55分25秒", outStr2,"Formatの指定が不正かもしれません!");
        } catch (Error e) {
            if ("7/2 04時55分25秒".equals( outStr2 )) 
                fail("expected: <7/2 16時55分25秒> but was: <7/2 04時55分25秒> Formatの時刻を表す文字がHHではありません!");
            else
                throw e;
        }
    }
}
