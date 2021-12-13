import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class SokobanServer {

    private ServerSocket serverSocket;
    private static final Object object = new Object();

    public SokobanServer(int portNumber) {

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException ioe) {
            System.out.println("Error : " + ioe);
        }

    }

    public void go() {
        System.out.println("Sokoban Level Server started");

        while(true) {
            synchronized(object) {
                Socket clientSocket;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException ioe) {
                    System.out.println("Error  : " + ioe);
                    clientSocket = null;
                }

                if(clientSocket != null) {
                    MyClient client = new MyClient(clientSocket);
                    client.start();
                }

            }

        }

    }


}
