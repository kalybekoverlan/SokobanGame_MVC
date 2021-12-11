import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SokobanLevelClient {
    public static void main(String args[]) {
        // hostname of home virtual server
        String hostName = "192.168.157.128";
        // String hostName = "192.168.204.129";
        int portNumber = 4446;
        System.out.println("Connection to : Sokoban Level Server");

        try(
        Socket socket = new Socket(hostName, portNumber);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            Desktop desktopObject = (Desktop) in.readObject();
            int[][] desktop = desktopObject.getDesktop();

            for(int i = 0; i < desktop.length; i++ ) {
                for(int j = 0; j <desktop[i].length; j++) {
                    System.out.print(desktop[i][j]);
                }
                System.out.println();
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error : " + cnfe);
        } catch (IOException ioe) {
            System.out.println("Error : " + ioe);
        }
        System.out.println("Close connection");
    }

}
