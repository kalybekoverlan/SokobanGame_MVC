import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String args[]) {
        // hostname of home virtual server
        String hostName = "192.168.204.129";
        int portNumber = 4446;
        System.out.println("Connection to : Sokoban Level Server");

        try(Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader inputStreamReader  = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            ) {
            String message = "Send me level";
            out.println(message);

            String desktop = in.readLine();
            System.out.println("Received level: " + desktop);
        } catch (IOException ioe) {
            System.out.println("Sokoban Level Server Error : " + ioe);
        }
        System.out.println("Close connection");
    }

}
