package Assignment_22_12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
    /*
         2. Write the program that stores information about university library users: surname and initials of the reader,
        the number of books on the subscription. It has to be possible to add information about library users manually.
        On the user request the program must display either a message about the reader who has the largest number of books,
        or a list of library users in ascending order based on the number of books (6 points)
     */
    private String userName;
    private static int userId = 20220000;
    private int numOfBooks;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        Library.userId = userId + 1;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    @Override
    public String toString() {
        return "Library{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", numOfBooks=" + numOfBooks +
                '}';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Library> user = new ArrayList<>();
        boolean flag = true;
        do {
            System.out.println("Welcome to Library Application");
            System.out.println("Please Select an Option to continue");
            System.out.println("1- Add User");
            System.out.println("2- Display Users");
            System.out.println("3- Update a User");
            System.out.println("4- Exit Program");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    user.add(addUser());
                    break;
                case 2:
                    displayUsers(user);
                    break;
                case 3:
                    updateUser(user);
                    break;
                case 4:
                    System.out.println("Thank you for reading :). So long!");
                    flag = false;
                    break;
            }

        } while (flag);

    }

    public static Library addUser() {
        Scanner in = new Scanner(System.in);
        Library newUser = new Library();
        System.out.println("Enter your surname and initial of your first name: ");
        newUser.setUserName(in.next());
        System.out.println("Enter how many books are there in your subscription");
        newUser.setNumOfBooks(in.nextInt());
        newUser.setUserId(userId++);
        return newUser;
    }

    public static void displayUsers(List<Library> user) {
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to display?");
        System.out.println("1- The user with the biggest number of books");
        System.out.println("2- All users sorted by their number of books");
        int option = in.nextInt();
        switch (option) {
            case 1:
                int max = 0;
                for (Library w : user) {
                    max = Math.max(max, w.getNumOfBooks());
                }
                for (Library w : user) {
                    if (w.getNumOfBooks() == max) {
                        System.out.println(w);
                    }
                }
                break;
            case 2:
                user.stream().sorted(Comparator.comparing(Library::getNumOfBooks)).forEach(System.out::println);
                break;
        }
    }

    public static void updateUser(List<Library> user) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the surname and initial of first name of the user you want to update:");
        String userToUpdate = in.next();
        System.out.println("What is the new amount of books on users subscription");
        int newAmountOfBooks = in.nextInt();
        for (Library w : user) {
            if (w.getUserName().equalsIgnoreCase(userToUpdate)) {
                w.setNumOfBooks(newAmountOfBooks);
            }
        }

    }
}

//    public static void optionMenu(List<Library> user, int option, boolean flag){
//        switch (option){
//            case 1 :
//                user.add(addUser());
//                break;
//            case 2:
//                displayUsers(user);
//                break;
//            case 3:
//                System.out.println("Thank you for reading :). So long!");
//                flag = false;
//                break;
//        }
//    }


