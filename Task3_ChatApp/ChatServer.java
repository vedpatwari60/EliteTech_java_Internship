import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Chat Server started on port 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);

                client.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thread for each client
    static class ClientHandler extends Thread {

        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {

            try {
                String msg;

                while ((msg = in.readLine()) != null) {

                    System.out.println("Client: " + msg);

                    // Send message to all clients
                    for (ClientHandler c : clients) {
                        c.out.println(msg);
                    }
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
            }
        }
    }
}
