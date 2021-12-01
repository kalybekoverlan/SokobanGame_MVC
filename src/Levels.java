import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Levels {
    private int level;

    public Levels() {
            level=4;
    }

    public int[][] nextLevel(String fileName) {
        int[][] desktop = null;
        File file = new File(fileName);
        try{
            String contentFile = getContentFile(file);
            desktop = convertStringIntoTwoDimensionArray(contentFile);
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return desktop;
    }

    private int[][] convertStringIntoTwoDimensionArray(String line) {
        System.out.println(line);
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
        int a = 0;

        for(int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if(symbol != '\n') {
                column = column + 1;
            }
            if(symbol == '\n') {
                array[a] = new int[column];
                a = a + 1;
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
            }
            if(symbol == '\n') {
                row = row + 1;
                column = 0;
            }
        }

        System.out.println("after converting to two-dimensional array");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        return null;
    }

    private String getContentFile(File file) throws Exception{

        try(FileInputStream in = new FileInputStream(file)) {
            int size = (int) file.length();
            char[] array = new char[size];
            int index = 0;
            int unicode;
            //System.out.println("file size: "+size);
            while((unicode=in.read()) != -1) {
                char symbol = (char) unicode;
                if(('0' <= symbol && symbol <= '4') || (symbol == '\n')) {
                    array[index] = symbol;
                    index = index + 1;
                }
            }
            //array[index++] = '\n';
            String content = new String(array, 0, index);
            return content;
        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception : " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception : " + ioe);
        }

    }


}