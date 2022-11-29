package Assignments1129;

public class Employees {
    /*
    1. Assign the phone number, address and ID number of two employees having
     names "Anna" and "John" respectively by creating two objects of class ‘Employee’.
      Create the method in the Employee class to print information about employees (3 points).
     */
    private String phoneNumber;
    private String address;
    private Integer idNumber;

    public Employees(String phoneNumber, String address, Integer idNumber) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }

    public Employees() {
    }

    public static void main(String[] args) {
        Employees print = new Employees();
        print.printInfo();
    }

    public void printInfo(){
        Employees anna = new Employees("+48123456789", "Ul.Daszynskiego 24/Warsaw", 112222);
        System.out.println("anna = " + anna);
        Employees john = new Employees("+48223456780", "Ul.Waszynskiego 24/Warsaw", 112223);
        System.out.println("john = " + john);


    }
}
