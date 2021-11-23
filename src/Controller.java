import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements KeyListener {
    private Model model;

    public Controller(Viewer viewer) {
        System.out.println("Controller: " + this);
        model = new Model(viewer);

    }

    public Model getModel() {
        return model;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();

        String direction = "";
        switch (keyCode) {
            case 37:
                direction = "Right";
                break;
            case 38:
                direction = "Up";
                break;
            case 39:
                direction = "Left";
                break;
            case 40:
                direction = "Down";
                break;
            default:
                return;
        }
        System.out.println(direction);

    }



}
