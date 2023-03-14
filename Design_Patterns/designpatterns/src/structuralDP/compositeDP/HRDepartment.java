package structuralDP.compositeDP;

import java.util.List;
import java.util.stream.Collectors;

public class HRDepartment extends Department{

    List<Department> childDepartments;

    public HRDepartment(List<Department> childDepartments) {
        this.childDepartments = childDepartments;
    } // here the list data type is parent abstract class so we can have any child classes elements.

    @Override
    String getName() {
        return childDepartments.stream().map(Department::getName).collect(Collectors.joining(" - "));
                        //.joining() method Returns a Collector that concatenates the input elements into a String, in encounter order.
                        // by using list we create here and the parent class we gett all names by getName method in parent interface
    }

    @Override
    List<String> getEmployee() {
        return childDepartments.stream().flatMap(d-> d.getEmployee().stream()).collect(Collectors.toList());
                    // here is a way to get all getList methods from child classes. flatMap -> its a special map which is used to convert
                    // a stream into another stream.
    }
}
