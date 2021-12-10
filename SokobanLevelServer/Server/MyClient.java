import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

public class MyClient extends Thread {
    private Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("socket : " + socket);
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            Desktop desktop = new Desktop();
            out.writeObject(desktop);
            socket.close();
        } catch(IOException ioe) {
            System.out.println("Error : " + ioe);
        }

    }
}
