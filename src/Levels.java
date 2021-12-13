import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

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
            case 3:
                desktop = getLevelThree();
                break;
            case 4:
                desktop = getLevelFour();
                break;
            case 5:
                desktop = getLevelFive();
                break;
            case 6:
                desktop = getLevelSix();
                break;
            case 7:
                desktop = getLevelSeven();
                break;
            case 8:
                desktop = getLevelEight();
                break;
            case 9:
                desktop = getLevelNine();
                break;
            default:
                level = 1;
                desktop = getLevelOne();
        }
        level = level + 1;
        return desktop;
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
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 1, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
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
            {2, 0, 0, 0, 2, 2, 0, 0, 0, 2},
            {2, 0, 0, 2, 2, 2, 2, 0, 0, 2},
            {2, 0, 0, 2, 1, 3, 4, 0, 0, 2},
            {2, 0, 0, 2, 0, 0, 2, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        return levelTwo;
    }

    private int[][] getLevelThree() {
        int[][] levelThree = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 3, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 1, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        return levelThree;
    }

    private int[][] getLevelFour() {
        return getFileLevel("levels/level4.sok");
    }

    private int[][] getLevelFive() {
        return getFileLevel("levels/level5.sok");
    }

    private int[][] getLevelSix() {
        return getFileLevel("levels/level6.sok");
    }

    private int[][] getLevelSeven() {
        return getServerLevel("7");
    }

    private int[][] getLevelEight() {
        return getServerLevel("8");
    }

    private int[][] getLevelNine() {
        return getServerLevel("9");
    }

    private int[][] getFileLevel(String fileName) {

         int[][] desktop = null;
         File file = new File(fileName);
         try{
             String contentFile = getContentFile(file);
             desktop = convertStringIntoTwoDimensionArray(contentFile);
         } catch (Exception e) {
             System.out.println("Sokoban Game Error : " + e);
             return getLevelOne();
         }
         return desktop;
     }

     private int[][] getServerLevel(String levelNumber) {
         String hostName = "localhost";
         int portNumber = 4446;
         int[][] desktop = null;
         // System.out.println("Connection to : Sokoban Level Server");
         try(
         Socket socket = new Socket(hostName, portNumber);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         ) {
             out.println(levelNumber);
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Desktop desktopObject = (Desktop) in.readObject();
             desktop = desktopObject.getDesktop();
         } catch (ClassNotFoundException | IOException exp) {
             System.out.println("Error : " + exp);
             return getLevelOne();
         }
         System.out.println("Close connection");
         if(desktop == null) {
             return getLevelOne();
         } else {
            return desktop;
         }
     }

     public void setNextLevelNumber(int level) {
         this.level = level;
     }

     public int getLevelNumber() {
         return level;
     }


}
