package assignment_01_10;

public class Employees {

    public String name;
    public String surname;

    public Employees(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: \""+ name + '"' +
                "-Surname: \"" + surname + '"';
    }
}
