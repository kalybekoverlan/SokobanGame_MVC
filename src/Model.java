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
        if(direction.equals("Left")) {
            moveLeft();
        } else if(direction.equals("Up")) {
            moveUp();
        } else if(direction.equals("Right")) {
            moveRight();
        } else if(direction.equals("Down")) {
            moveDown();
        }
        viewer.update();
    }

    private void moveLeft() {
        x = x - 10;
    }

    private void moveUp() {
        y = y - 10;
    }

    private void moveRight() {
        x = x + 10;
    }

    private void moveDown() {
        y = y + 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
