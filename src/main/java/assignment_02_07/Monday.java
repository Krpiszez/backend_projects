package assignment_02_07;

import java.util.HashMap;
import java.util.Map;

public class Monday extends Day{
    @Override
    public Map<Integer, String> getDay() {
        Map<Integer, String> mondaySchedule = new HashMap<>();
        mondaySchedule.put(1, Day.math);
        mondaySchedule.put(2, Day.art);
        mondaySchedule.put(3, Day.science);
        return mondaySchedule;
    }
}
