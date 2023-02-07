package assignment_02_07;

import java.util.HashMap;
import java.util.Map;

public class Wednesday extends Day{

    @Override
    public Map<Integer, String> getDay() {
        Map<Integer, String> wednesdaySchedule = new HashMap<>();
        wednesdaySchedule.put(1, Day.computerScience);
        wednesdaySchedule.put(2, Day.physicalEducation);
        wednesdaySchedule.put(3, Day.math);
        wednesdaySchedule.put(4, Day.science);
        return wednesdaySchedule;
    }
}
