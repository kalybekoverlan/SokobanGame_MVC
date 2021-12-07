import java.net.Socket;
import java.io.IOException;

public class Client {
    public static void main(String args[]) {
        // hostname of home virtual server
        String hostName = "192.168.204.129";
        int portNumber = 4446;
        try {
            System.out.println("Connection to : Sokoban Level Server");
            Socket socket = new Socket(hostName, portNumber);
            System.out.println("Close connection");
        } catch (IOException ioe) {
            System.out.println("Sokoban Level Server Error : " + ioe);
        }
    }

}
