public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private boolean isGamePlaying;
    private int[][] goalIndexes;
    private Levels levels;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        isGamePlaying = true;
        levels = new Levels();
        desktop = levels.nextLevel();
        // Optimize initialization method
        initialization();
    }

    // 0 - empty
    // 1 - player
    // 2 - wall
    // 3 - box
    // 4 - destination
    private void initialization() {
        // solve
        indexX = getIndexXofGamer(desktop);
        indexY = getIndexYofGamer(desktop);
        goalIndexes = getGoalIndexes(desktop);
        System.out.println(indexX+" "+indexY);
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
        for(int i = 0; i < goalIndexes.length; i++){
            for(int j = 0; j < goalIndexes[i].length; j++){
                System.out.print(goalIndexes[i][j] + " ");
            }
            System.out.println();
        }
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
                desktop = levels.nextLevel();
                initialization();
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

    private boolean isSingleGamer(int[][] desktop) {
        int gamerCounter=0;

        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 1) {
                    gamerCounter = gamerCounter + 1;
                }
            }
        }

        if(gamerCounter == 1) {
            return true;
        } else {
            // System.out.println("Gamer: " + gamerCounter);
            return false;
        }
    }

    private int[][] getGoalIndexes(int[][] desktop) {
        int goals=0;
        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 4 ) {
                    goals++;
                }
            }
        }

        int[][] indexes = new int[2][goals];

        int y=0;
        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 4 ) {
                    indexes[0][y] = i;
                    indexes[1][y] = j;
                    y = y +1;
                }
            }
        }

        return indexes;
    }

    private  int getIndexXofGamer(int[][] desktop) {

        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 1) {
                    return i;
                }
            }
        }
        return 0;
    }

    private  int getIndexYofGamer(int[][] desktop) {

        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 1) {
                    return j;
                }
            }
        }
        return 0;
    }



}
