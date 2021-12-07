import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class SokobanLevelServer {
    public static void main(String args[]) {
        System.out.println("Hi i am server");
        int portNumber = 4446;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client socket : " + clientSocket);
        } catch (IOException ioe) {
            System.out.println("Sokoban Level Server Error : " + ioe);
        }
    }

}
