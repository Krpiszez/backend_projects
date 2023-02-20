package Assignment_22_12;

public class Class {
/*
    1. Create class Student with fields name, surname, age, groupNumber, fieldOfStudy,
     id. Create 10 objects of Student class, add them to list.
     1.1. Create static method to display all information from the list (3 points)
     1.2. Display information about students younger than 20 y.o. (3 points)
     1.3. Display list of students in alphabetical order (3 points)

 */
    private String name;
    private String surname;
    private Integer age;
    private Integer groupNumber;
    private String fieldOfStudy;
    private static Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Class.id = id;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", groupNumber=" + groupNumber +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    public Class(String name, String surname, Integer age, Integer groupNumber, String fieldOfStudy, Integer id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.groupNumber = groupNumber;
        this.fieldOfStudy = fieldOfStudy;
        this.id = id;
    }

    public static void main(String[] args) {


    }
}
