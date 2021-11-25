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
        System.out.println("direction is " + direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
