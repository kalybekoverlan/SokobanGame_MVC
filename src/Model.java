public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        // Optimize initialization method
        initialization();
    }

    // 0 - empty
    // 1 - player
    // 2 - wall
    // 3 - box
    // 4 - destination
    private void initialization() {
        desktop = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 4, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 3, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 3, 0, 0, 4, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        // solve
        indexX = 3;
        indexY = 4;
        desktop[indexX][indexY] = 1;
        // solve end

    }

    private void nextLevel() {
        desktop = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 4, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 0, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 3, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 4, 0, 0, 2},
                {2, 0, 3, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
        // solve
        indexX = 8;
        indexY = 4;
        desktop[indexX][indexY] = 1;
        // solve end

    }

    // up, right, down, left,
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
        checkGoal();
        viewer.update();
        won();
    }

    private void checkGoal() {
        if (desktop[6][6] == 0){
            desktop[6][6] = 4;
        } else if (desktop[2][2] == 0) {
            desktop[2][2] = 4;
        }
    }

    private void won() {
        boolean isWon = true;
        if(desktop[2][2] != 3 || desktop[6][6] != 3) {
            isWon = false;
        }

        if(isWon){
            if(viewer.showWonDialog() ) {
                System.out.println("Go to next Level");
                nextLevel();
                viewer.update();
            }
        }
    }

    private void moveUp() {
        if(desktop[indexX - 1][indexY] == 3) {
            if(desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if(desktop[indexX-1][indexY] == 0 || desktop[indexX-1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight() {
        if(desktop[indexX][indexY + 1] == 3) {
            if(desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if(desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if(desktop[indexX + 1][indexY] == 3) {
            if(desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if(desktop[indexX+1][indexY] == 0 || desktop[indexX+1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if(desktop[indexX][indexY - 1] == 3) {
            if(desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if(desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    public int[][] getDesktop() {
        return  desktop;
    }

}
