package structuralDP.compositeDP;

import java.util.Arrays;
import java.util.List;

public class RnD extends Department{
    @Override
    String getName() {
        return "Research and Dev";
    }

    @Override
    List<String> getEmployee() {
        return Arrays.asList("R1", "R2", "R3");
    }
}
