import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Canvas extends JPanel{
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;

    public Canvas(Model model) {
        this.model = model;
        setBackground(new Color(59, 91, 161));
        setOpaque(true);
        File fileNameImageGamer = new File("images/gamer.png");
        File fileNameImageWall = new File("images/wall.png");
        File fileNameImageBox = new File("images/box.png");
        File fileNameImageGoal = new File("images/goal.png");
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
        if (!model.isGamePlaying()) {
            initializationError(g);
            return;
        }
        super.paint(g);
        int[][] desktop = model.getDesktop();

        int start = 50;
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;

        g.setColor(new Color(213, 241, 255));
        setFont(new Font("SansSerif", Font.BOLD, 15));
        g.drawString("Level : " + (model.getLevelNumber() - 1), 250, 20);

        for(int i=0; i < desktop.length; i++) {
            for(int j=0; j < desktop[i].length; j++ ) {
                if(desktop[i][j] == 1) {
                    g.drawImage(imageGamer, x, y, null);
                } else if(desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if(desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if(desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);
                }
                x = x + width;
            }
            x = start;
            y = y + height;
        }

    }

    public void initializationError(Graphics g) {
        g.setColor(new Color(35, 63, 122));
        g.drawRect(0, 0, 920, 700);
        g.fillRect(0, 0, 920, 700);
        g.setColor(new Color(159, 225, 255));
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("Level : " + (model.getLevelNumber() - 1)
                    + ". Initialization Error!!! "
                    + " Choice another level from menu \"Levels\"", 70, 320);
    }


}
