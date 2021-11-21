public class Viewer {

    public Viewer() {
        System.out.println("Viewer: "+this);
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        Canvas canvas = new Canvas(model);
    }

}
