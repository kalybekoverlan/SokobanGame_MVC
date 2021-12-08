import java.net.Socket;

public class MyClient extends Thread {
    private Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("socket : " + socket);

        socket.close();
    }
}
