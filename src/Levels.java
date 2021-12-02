import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Levels {
    private int level;

    public Levels() {
        level=1;
    }

    public int[][] nextLevel() {
        int[][] desktop = null;

        switch(level) {
            case 1:
                desktop = getLevelOne();
                break;
            case 2:
                desktop = getLevelTwo();
                break;
            // case 3:
            //     desktop = getLevelThree();
            //     break;
            default:
                level = 1;
                desktop = getLevelOne();
        }
        level = level + 1;
        return desktop;
    }

   // public int[][] nextLevel(String fileName) {
   //
   //      int[][] desktop = null;
   //      File file = new File(fileName);
   //      try{
   //          String contentFile = getContentFile(file);
   //          desktop = convertString IntoTwoDimensionArray(contentFile);
   //          System.out.println("after converting to two-dimensional array");
   //          for(int i = 0; i < desktop.length; i++){
   //              for(int j = 0; j < desktop[i].length; j++){
   //                  System.out.print(desktop[i][j]);
   //              }
   //              System.out.println();
   //          }
   //      } catch (Exception e) {
   //          System.out.println("Error : " + e);
   //      }
   //
   //      return desktop;
   //  }

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

    private int[][] getLevelOne() {
        int[][] levelOne = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 4, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 3, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 1, 3, 0, 0, 4, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        return levelOne;
    }

    private int[][] getLevelTwo() {
        int[][] levelTwo = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 2, 2, 0, 0, 0, 2},
            {2, 0, 0, 4, 2, 2, 0, 0, 0, 2},
            {2, 0, 0, 2, 2, 2, 2, 0, 0, 2},
            {2, 0, 3, 2, 1, 4, 2, 0, 0, 2},
            {2, 0, 0, 2, 0, 0, 2, 0, 0, 2},
            {2, 0, 0, 0, 3, 0, 3, 0, 0, 2},
            {2, 0, 0, 0, 4, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        return levelTwo;
    }


}
