package assignment_03_16;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Registration newRegister = new Registration();
        List<User> userList = newRegister.register();
        newRegister.printHappyUsers(userList);

    }
}
