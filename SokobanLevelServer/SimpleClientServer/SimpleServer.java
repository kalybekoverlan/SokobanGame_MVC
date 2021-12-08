public class SimpleServer {
    public static void main(String args[]) {
        System.out.println("Sokoban Level Server started");
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
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(desktop);
            System.out.println("level : " + desktop + " sended");

        } catch (IOException ioe) {
            System.out.println("Sokoban Level Server Error : " + ioe);
        }
    }
}
