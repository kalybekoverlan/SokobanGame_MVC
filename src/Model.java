public class Model {
    private Viewer viewer;
    private int x;
    private int y;


    public Model(Viewer viewer) {
        System.out.println("Model: " + this);
        this.viewer = viewer;
        x = 50;
        y = 50;
    }

    public void move(String direction) {
        x = x + 70;
        System.out.println("direction is " + x);
        viewer.update();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
