import java.io.Serializable;

public class Desktop implements Serializable {
    private int[][] desktop;

    public Desktop() {
        desktop = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 2, 2, 2, 0, 0, 0, 0, 2},
            {2, 0, 2, 4, 2, 0, 0, 0, 0, 2},
            {2, 0, 2, 0, 2, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 1, 0, 0, 0, 2},
            {2, 0, 3, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
    }

    public int[][] getDesktop() {
        return desktop;
    }
}