import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements KeyListener, ActionListener {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public Model getModel() {
        return model;
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();


        String direction = "";
    // left, up, right, down
        switch (keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
            default:
                return;
        }
    }

    public void keyReleased(KeyEvent event) {}

    public void keyTyped(KeyEvent e) {}

    public void actionPerformed(ActionEvent e) {
        String levelNumber = e.getActionCommand();
        model.menuAction(levelNumber);
    }

}
