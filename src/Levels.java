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
            System.out.println(contentFile);
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return desktop;
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

            array[index++] = '\n';
            String content = new String(array, 0, index);
            return content;
        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception : " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception : " + ioe);
        }

    }


}
