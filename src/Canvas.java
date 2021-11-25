import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Canvas extends JPanel{
    private Model model;

    public Canvas(Model model) {
        System.out.println("Canvas: " + this);
        this.model = model;
        setBackground(Color.RED);
        setOpaque(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(model.getX(), model.getY(), 70, 70);
    }

}
