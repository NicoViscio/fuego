import javax.swing.*;

class FireThread implements Runnable {
    private final FireModel model;
    private final FireView view;

    public FireThread(FireModel model, FireView view) {
        this.model = model;
        this.view = view;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                SwingUtilities.invokeLater(() -> {
                    model.updateFire();
                    view.repaint();
                });
                Thread.sleep(33);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}