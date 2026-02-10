import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader input =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader keyboard =
                new BufferedReader(new InputStreamReader(System.in));

            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

            // Thread to receive messages
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Message: " + msg);
                    }
                } catch (Exception e) {}
            }).start();

            // Send messages
            String userMsg;
            while ((userMsg = keyboard.readLine()) != null) {
                out.println(userMsg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
