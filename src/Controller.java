import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements KeyListener {
    private Model model;

    public Controller(Viewer viewer) {
        System.out.println("Controller: "+this);
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
        System.out.println(keyCode);

    }



}
