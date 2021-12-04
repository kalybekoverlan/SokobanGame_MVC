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
        initialization();
    }

    // 0 - empty
    // 1 - player
    // 2 - wall
    // 3 - box
    // 4 - destination
    private void initialization() {
        if(isSingleGamer() && isEqualBoxesGoals()) {
            goalIndexes = getGoalIndexes(desktop);
            desktop[indexX][indexY] = 1;
            isGamePlaying = true;
        } else {
            isGamePlaying = false;
        }

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
        for(int x = 0; x < goalIndexes[0].length ; x++) {
            int goalIndexI = goalIndexes[0][x];
            int goalIndexJ = goalIndexes[1][x];

            if (desktop[goalIndexI][goalIndexJ] == 0 ) {
                desktop[goalIndexI][goalIndexJ] = 4;
            }
        }
    }

    private void won() {
        boolean isWon = true;
        for(int x = 0; x < goalIndexes[0].length ; x++) {
            int goalIndexI = goalIndexes[0][x];
            int goalIndexJ = goalIndexes[1][x];

            if (desktop[goalIndexI][goalIndexJ] != 3 ) {
                isWon = false;
                break;
            }
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

    private boolean isSingleGamer() {
        int gamerCounter = 0;
        int indexXofGamer = 0;
        int indexYofGamer = 0;

        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 1) {
                    gamerCounter = gamerCounter + 1;
                    indexXofGamer = i;
                    indexYofGamer = j;
                }
            }
        }

        if(gamerCounter == 1) {
            indexX = indexXofGamer;
            indexY = indexYofGamer;
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

    public boolean isGamePlaying() {
        return isGamePlaying;
    }

    public boolean isEqualBoxesGoals() {
        int amountOfBoxes = 0;
        int amountOfGoals = 0;
        for(int i = 0; i < desktop.length; i++){
            for(int j = 0; j < desktop[i].length; j++){
                if(desktop[i][j] == 3) {
                    amountOfBoxes = amountOfBoxes + 1;
                } else if(desktop[i][j] == 4) {
                    amountOfGoals = amountOfGoals + 1;
                }
            }
        }
        if(amountOfBoxes == amountOfGoals) {
            return true;
        } else {
            return false;
        }
    }



}
