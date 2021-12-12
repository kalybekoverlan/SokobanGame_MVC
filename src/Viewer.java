import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class Viewer {
    private Canvas canvas;
    private JFrame frame;

    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JMenuBar menuBar = new JMenuBar();
        JMenu levelmenu = new JMenu("Levels");

        menuBar.add(levelmenu);
        JMenuItem level1Item= new JMenuItem("level 1");
        level1Item.addActionListener(controller);
        level1Item.setActionCommand("level1");
        JMenuItem level2Item= new JMenuItem("level 2");
        level2Item.addActionListener(controller);
        level2Item.setActionCommand("level2");
        JMenuItem level3Item= new JMenuItem("level 3");
        level3Item.addActionListener(controller);
        level3Item.setActionCommand("level3");
        JMenuItem level4Item= new JMenuItem("level 4");
        level4Item.addActionListener(controller);
        level4Item.setActionCommand("level4");
        JMenuItem level5Item= new JMenuItem("level 5");
        level5Item.addActionListener(controller);
        level5Item.setActionCommand("level5");
        JMenuItem level6Item= new JMenuItem("level 6");
        level6Item.addActionListener(controller);
        level6Item.setActionCommand("level6");
        JMenuItem level7Item= new JMenuItem("level 7");
        level7Item.addActionListener(controller);
        level7Item.setActionCommand("level7");
        JMenuItem level8Item= new JMenuItem("level 8");
        level8Item.addActionListener(controller);
        level8Item.setActionCommand("level8");
        JMenuItem level9Item= new JMenuItem("level 9");
        level9Item.addActionListener(controller);
        level9Item.setActionCommand("level9");

        levelmenu.add(level1Item);
        levelmenu.add(level2Item);
        levelmenu.add(level3Item);
        levelmenu.add(level4Item);
        levelmenu.add(level5Item);
        levelmenu.add(level6Item);
        levelmenu.add(level7Item);
        levelmenu.add(level8Item);
        levelmenu.add(level9Item);

        frame = new JFrame("Sokoban Game MVC Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add("Center",canvas);
        frame.setSize(1000, 1000);
        frame.setLocation(300, 300);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.addKeyListener(controller);

    }

    public void update() {
        canvas.repaint();
    }

    public boolean showWonDialog() {
        JOptionPane.showMessageDialog(frame, "You won!!!");
        return true;
    }

}
