import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SokobanLevelServer {
    public static void main(String args[]) {
        System.out.println("Hi i am server");
        int portNumber = 4446;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            String infoFromClient = in.readLine();
            System.out.println("Client socket : " + clientSocket);
            System.out.println("From client : " + infoFromClient);
            String desktop = "2222222222";
        } catch (IOException ioe) {
            System.out.println("Sokoban Level Server Error : " + ioe);
        }
    }

}
