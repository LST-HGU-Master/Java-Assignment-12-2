import java.util.Date;

public class ProgC2 {

    public static void main(String[] args) {
        Observation o = new Observation();
        o.waitHour = 31;
        Date now = new Date();
        System.out.println(o.getReactionTime(now));
    }

}

