import javax.swing.JFrame;
import java.awt.event.KeyListener;

public class Viewer {

    public Viewer() {
        System.out.println("Viewer: " + this);
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        Canvas canvas = new Canvas(model);

        JFrame frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setSize(600, 600);
        frame.setLocation(300, 300);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

}
