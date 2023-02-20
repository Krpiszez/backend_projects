package first_git_package;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaClass {



    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        list.stream().map(t-> t>4).collect(Collectors.toList());
    }
}
