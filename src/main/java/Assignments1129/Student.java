package Assignments1129;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Student {
    /*
    3. Create class ‘Student’ with fields name, surname, ID, field of study, year of enrollment.
     Class ‘Student’ should have one method to initialize all these fields for newly created object
      of class ‘Student’. Second method in the class ‘Student’ should return the year of study when
       year of enrollment is passed to this method. Third method should print the list of students of
        a particular field of study (3 points).
     */
    private String name;
    private String surname;
    private String id;
    private String fieldOfStudy;
    private LocalDate yearOfEnrollment;

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.initialize("Tom", "Hanks", "12345", "Math", LocalDate.of(2020, 1, 4));
        student2.initialize("Brad", "Pitt", "22345", "Math", LocalDate.of(2018, 1, 4));
        System.out.println(student1);
        System.out.println("student.yearOfEnrollment = " + student1.yearOfStudy(student1.yearOfEnrollment));
        System.out.println("ListOfStudents who takes Math = " + listOfStudents("Math", student1, student2));

    }

    public void initialize(String name, String surname, String id, String fieldOfStudy, LocalDate yearOfEnrollment) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.yearOfEnrollment = yearOfEnrollment;
    }
    public long yearOfStudy(LocalDate yearOfEnrollment){

        return ChronoUnit.YEARS.between(yearOfEnrollment, LocalDate.now());

    }

    public static List<String> listOfStudents (String fieldOfStudy, Student... obj){
        List<String> listofStudents = new ArrayList<>();
        for (Student w: obj){
            if (w.fieldOfStudy.equals(fieldOfStudy)){
                listofStudents.add(w.name);
            }
        }
        return listofStudents;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", yearOfEnrollment=" + yearOfEnrollment +
                '}';
    }
}
