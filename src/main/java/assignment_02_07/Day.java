package assignment_02_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Day {

    protected static final String math = "Math";
    protected static final String science = "Science";
    protected static final String art = "Art";
    protected static final String computerScience = "Computer Science";
    protected static final String physicalEducation = "P.E.";

    public abstract Map<Integer, String> getDay();

    List<String> lessonList = new ArrayList<>();

    public List<String> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<String> lessonList) {
        lessonList.add(Day.art);
        lessonList.add(Day.math);
        lessonList.add(Day.science);
        lessonList.add(Day.computerScience);
        lessonList.add(Day.physicalEducation);
        this.lessonList = lessonList;
    }
}
