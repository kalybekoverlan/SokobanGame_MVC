public class Model {
    private Viewer viewer;

    public Model(Viewer viewer) {
        System.out.println("Model: " + this);
        this.viewer = viewer;
    }

}
