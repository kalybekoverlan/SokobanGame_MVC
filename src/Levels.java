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
        getContentFile(file);
        return desktop;
    }

    private String getContentFile(File file) {

        try(FileInputStream in = new FileInputStream(file)) {

            int unicode;
            while((unicode=in.read()) != -1) {
                char symbol = (char) unicode;
                System.out.print(symbol);
            }
            System.out.print("will arrive after parsing");

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {

        }

        return null;
    }


}
