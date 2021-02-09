import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/** Panel que implemeneta el mouselistener, gestionando los virus y sus imagenes y los clicks.
 * @version 09/12/2020
 * @author Carlos Benjumea Cabello
 */
public class PanelVirus extends JPanel implements MouseListener {
    private ArrayList<Virus> viruses = new ArrayList<Virus>();
    private double x, y;

    /**
     * Constructor del panel, que añade el listener del ratón.
     */
    public PanelVirus() {
        addMouseListener(this);
    }

    /**
     * Método que añade virus en la ArrayList de viruses.
     * @param v Objeto Virus.
     */
    public void add(Virus v) {
        viruses.add(v);
    }

    /**
     * Método que printa una imágen para cada virus de la lista de viruses según si están vivos o muertos.
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Virus v : viruses) {
            if (v.isAlive()) {
                g2.drawImage(v.getImatgeVivo(), (int)v.getCoordX(), (int)v.getCoordY(), this);
            } else {
                g2.drawImage(v.getImatgeMuerto(), (int)v.getCoordX(), (int)v.getCoordY(), this);
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Método que lee las coordenadas del ratón en el momento de dar click y busca virus en esa posición y los mata
     * en caso de que hubiera alguno.
     * @param mouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();

        for (Virus v : viruses) {
            if (v.isAlive()) {
                double radi = v.getRadi();
                double vx = v.getCoordX();
                double vy = v.getCoordY();
                double border = radi / 4 + 8;

                if (x < vx + radi + border / 3 && x > vx - border && y < vy + radi + border / 3 && y > vy - border) {
                    v.matar();
                }
            }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
