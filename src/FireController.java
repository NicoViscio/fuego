import javax.swing.*;

class FireController {
    private FireView view;

    public FireController(int width, int height) {
        FireModel model = new FireModel(width, height);
        view = new FireView(model, width, height);
        FireThread fireThread = new FireThread(model, view);
    }


    public JPanel getView() {
        return view;
    }
}