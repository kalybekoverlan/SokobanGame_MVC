import javax.swing.JFrame;
import java.awt.event.KeyListener;

public class Viewer {
    private Canvas canvas;

    public Viewer() {
        System.out.println("Viewer: " + this);
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JFrame frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setSize(700, 700);
        frame.setLocation(300, 300);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    public void update() {
        canvas.repaint();
    }


}
