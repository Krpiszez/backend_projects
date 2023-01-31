package assignment_01_31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyNetworkingClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8000)) {
            System.out.println("The Client has been Connected!");
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();
            // On the client side, the user is prompted to enter two numbers,
            // which are then sent to the server.
            dos.writeInt(num1);
            dos.writeInt(num2);
            //The result of the calculation is then displayed to the user.
            int result = dis.readInt();
            System.out.println("Result from server: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

