package assignment_02_07;

import java.util.Map;

public abstract class Day {

    protected static final String math = "Math";
    protected static final String science = "Science";
    protected static final String art = "Art";
    protected static final String computerScience = "Computer Science";
    protected static final String physicalEducation = "P.E.";

    public abstract Map<Integer, String> getDay();
}
