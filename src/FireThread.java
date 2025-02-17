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
        //Utilizo un while ture, ya que no queremos que pare, en el caso de querer hacerlo podemos
        //poner el run en un listener de algún botón
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