package assignment_02_07;

import java.util.HashMap;
import java.util.Map;

public class Tuesday extends Day{
    @Override
    public Map<Integer, String> getDay() {
        Map<Integer, String> tuesdaySchedule = new HashMap<>();
        tuesdaySchedule.put(1, Day.computerScience);
        tuesdaySchedule.put(2, Day.art);
        return tuesdaySchedule;
    }
}
