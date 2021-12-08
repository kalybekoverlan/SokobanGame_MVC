import java.net.Socket;
import java.io.IOException;

public class MyClient extends Thread {
    private Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("socket : " + socket);
        try {
            socket.close();
        } catch(IOException ioe) {
            System.out.println("Error : " + ioe);
        }

    }
}
