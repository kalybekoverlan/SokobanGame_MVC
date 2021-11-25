public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;

    public Model(Viewer viewer) {
        System.out.println("Model: " + this);
        this.viewer = viewer;
        desktop = new int[10][10];

        desktop[3][3] = 1;
    }

    public void move(String direction) {
        if(direction.equals("Up")) {
            moveUp();
        } else if(direction.equals("Right")) {
            moveRight();
        } else if(direction.equals("Down")) {
            moveDown();
        } else if(direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        viewer.update();
    }

    private void moveLeft() {

    }

    private void moveUp() {

    }

    private void moveRight() {
        desktop[3][3] = 0;
    }

    private void moveDown() {

    }

    public int[][] getDesktop() {
        return  desktop;
    }

}
