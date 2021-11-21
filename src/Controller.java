public class Controller {
    private Model model;

    public Controller(Viewer viewer) {
        System.out.println("Controller: "+this);
        model = new Model(viewer);

    }
    public Model getModel() {
        return model;
    }

}
