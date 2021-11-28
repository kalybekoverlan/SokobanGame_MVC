import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Canvas extends JPanel{
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;

    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.GRAY);
        setOpaque(true);
        File fileNameImageGamer = new File("../images/gamer.png");
        File fileNameImageWall = new File("../images/wall.png");
        File fileNameImageBox = new File("../images/box.png");
        File fileNameImageGoal = new File("../images/goal.png");
        try {
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        int[][] desktop = model.getDesktop();

        int start = 50;
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;

        for(int i=0; i < desktop.length; i++) {
            for(int j=0; j < desktop[i].length; j++ ) {
                if(desktop[i][j] == 1) {
                    g.drawImage(imageGamer, x, y, null);
                    //g.setColor(new Color(199, 18, 50));
                    //g.fillRect(x, y, width, height);
                    //g.setColor(Color.YELLOW);
                    //g.drawRect(x, y, width, height);
                } else if(desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                    //g.setColor(new Color(39, 177, 67));
                    //g.fillRect(x, y, width, height);
                    //g.setColor(Color.BLUE);
                    //g.drawRect(x, y, width, height);
                } else if(desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if(desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);
                }
                x = x + width + 10;
            }
            x = start;
            y = y + height + 10;
        }

    }

}
