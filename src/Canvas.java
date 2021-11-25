import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Canvas extends JPanel{
    private Model model;

    public Canvas(Model model) {
        System.out.println("Canvas: " + this);
        this.model = model;
        setBackground(Color.GRAY);
        setOpaque(true);
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
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, width, height);
                    g.setColor(Color.YELLOW);
                    g.drawRect(x, y, width, height);

                    //x = x + width + 10;
                } else {
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, width, height);
                }
                x = x + width + 10;
            }
            x = start;
            y = y + height + 10;
        }

    }

}
