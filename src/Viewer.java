import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;

    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JMenuBar menuBar = new JMenuBar();
        JMenu levelmenu = new JMenu("Levels");

        Font font = new Font("SansSerif", Font.BOLD, 15);

        JMenuItem level1Item= new JMenuItem("level 1");
        level1Item.addActionListener(controller);
        level1Item.setActionCommand("level1");
        level1Item.setFont(font);
        level1Item.setBackground(new Color(35, 63, 122));
        level1Item.setForeground(new Color(255, 255, 255));

        JMenuItem level2Item= new JMenuItem("level 2");
        level2Item.addActionListener(controller);
        level2Item.setActionCommand("level2");
        level2Item.setFont(font);
        level2Item.setBackground(new Color(35, 63, 122));
        level2Item.setForeground(new Color(255, 255, 255));

        JMenuItem level3Item= new JMenuItem("level 3");
        level3Item.addActionListener(controller);
        level3Item.setActionCommand("level3");
        level3Item.setFont(font);
        level3Item.setBackground(new Color(35, 63, 122));
        level3Item.setForeground(new Color(255, 255, 255));

        JMenuItem level4Item= new JMenuItem("level 4");
        level4Item.addActionListener(controller);
        level4Item.setActionCommand("level4");
        level4Item.setFont(font);
        level4Item.setBackground(new Color(35, 63, 122));
        level4Item.setForeground(new Color(255, 255, 255));

        JMenuItem level5Item= new JMenuItem("level 5");
        level5Item.addActionListener(controller);
        level5Item.setActionCommand("level5");
        level5Item.setFont(font);
        level5Item.setBackground(new Color(35, 63, 122));
        level5Item.setForeground(new Color(255, 255, 255));

        JMenuItem level6Item= new JMenuItem("level 6");
        level6Item.addActionListener(controller);
        level6Item.setActionCommand("level6");
        level6Item.setFont(font);
        level6Item.setBackground(new Color(35, 63, 122));
        level6Item.setForeground(new Color(255, 255, 255));

        JMenuItem level7Item= new JMenuItem("level 7");
        level7Item.addActionListener(controller);
        level7Item.setActionCommand("level7");
        level7Item.setFont(font);
        level7Item.setBackground(new Color(35, 63, 122));
        level7Item.setForeground(new Color(255, 255, 255));

        JMenuItem level8Item= new JMenuItem("level 8");
        level8Item.addActionListener(controller);
        level8Item.setActionCommand("level8");
        level8Item.setFont(font);
        level8Item.setBackground(new Color(35, 63, 122));
        level8Item.setForeground(new Color(255, 255, 255));

        JMenuItem level9Item= new JMenuItem("level 9");
        level9Item.addActionListener(controller);
        level9Item.setActionCommand("level9");
        level9Item.setFont(font);
        level9Item.setBackground(new Color(35, 63, 122));
        level9Item.setForeground(new Color(255, 255, 255));

        menuBar.add(levelmenu);
        menuBar.setBackground(new Color(35, 63, 122));
        levelmenu.setFont(font);
        levelmenu.setForeground(new Color(255, 255, 255));
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
        frame.setSize(920, 700);
        frame.setLocation(60, 60);
        frame.setIconImage(new ImageIcon("images/icon.jpg").getImage());
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
