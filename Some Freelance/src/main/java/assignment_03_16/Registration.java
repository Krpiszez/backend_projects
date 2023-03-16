package assignment_03_16;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration {

    boolean flag;

    List<User> register(){
        List<User> userList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        flag = true;
        while (flag){
            System.out.println("Enter a username to add UserList");
            String userName = in.next();
            userList.add(getUser(userName));
            System.out.println("Do you want to keep adding? Y: Yes - N: No");
            if (in.next().equalsIgnoreCase("n")){
                flag = false;
            }
        }
        return userList;
    }

    User getUser(String name){
        return new User(name, LocalDateTime.now());
    }

    void printHappyUsers(List<User> userList){
        for (User u: userList){
            int registerSecond = u.getRegisterDate().getSecond();
            if (registerSecond<=10){
                System.out.println(u.getName());
                System.out.println(u.getRegisterDate().getSecond());
                System.out.println(u);
            }
        }
    }

}
