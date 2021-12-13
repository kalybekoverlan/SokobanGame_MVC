import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyClient extends Thread {
    private Socket socket;

    public MyClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("socket : " + socket);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            String levelNumber = in.readLine();
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            int[][] desktopArray = getFileLevel("levels/level" + levelNumber + ".sok");
            Desktop desktop = new Desktop(desktopArray);
            out.writeObject(desktop);
            socket.close();
        } catch(IOException ioe) {
            System.out.println("Error : " + ioe);
        }

    }

    private int[][] convertStringIntoTwoDimensionArray(String line) {
        int n = line.length();
        int row = 0;
        for(int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if(symbol == '\n') {
                row = row + 1;
            }
        }

        int[][] array = new int[row][];
        int column = 0;
        int index = 0;

        for(int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if(symbol != '\n') {
                column = column + 1;
            } else if(symbol == '\n') {
                array[index] = new int[column];
                index = index + 1;
                column = 0;
            }
        }

        row = 0;
        column = 0;
        for(int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if(symbol != '\n') {
                array[row][column] = Integer.parseInt("" + symbol);
                column = column + 1;
            } else if(symbol == '\n') {
                row = row + 1;
                column = 0;
            }
        }

        return array;
    }

    private String getContentFile(File file) throws Exception{
        try(FileInputStream in = new FileInputStream(file)) {
            int size = (int) file.length();
            char[] array = new char[size];
            int index = 0;
            int unicode;

            while((unicode=in.read()) != -1) {
                char symbol = (char) unicode;
                if(('0' <= symbol && symbol <= '4') || (symbol == '\n')) {
                    array[index] = symbol;
                    index = index + 1;
                }
            }

            String content = new String(array, 0, index);
            return content;
        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception : " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception : " + ioe);
        }

    }


    private int[][] getFileLevel(String fileName) {

         int[][] desktop = null;
         File file = new File(fileName);
         try{
             String contentFile = getContentFile(file);
             desktop = convertStringIntoTwoDimensionArray(contentFile);
         } catch (Exception e) {
             System.out.println("Sokoban Game Error : " + e);
         }
         return desktop;
     }
}
