package assignment_01_31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetworkingServer {
    public static void main(String[] args) {
        //Here, the server listens on port 8000 and waits for a client to connect.
                try (ServerSocket serverSocket = new ServerSocket(8000)) {
                    System.out.println("The Server has been Started!");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        //When a client connects, it reads two integers from the client and returns
                // the sum of those two integers back to the client.
                int num1 = dis.readInt();
                int num2 = dis.readInt();
                int result = num1 + num2;

                dos.writeInt(result);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
