import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/** Clase que implementa Runnable para poder ejecutarse como Thread. Inicializa las variables para la posición,
 * su radio y su velocidad.
 * @version 09/12/2020
 * @author Carlos Benjumea Cabello
 */
public class Virus implements Runnable {
    private double coordX;
    private double coordY;
    private double dX = 1;
    private double dY = 1;
    private int radi;
    private Image imatgeVivo, imatgeMuerto;
    private boolean isAlive;

    private static JPanel panel;

    /**
     * Constructor que recibe un panel en el que se printará el virus. Inicializa las variables de las coordenadas
     * aleatoriamente según los bordes del panel, y también inicializa su velocidad y su tamaño aleatoriamente en un
     * rango determinado. Y carga las imagenes necesarías.
     * @param pan Panel en el que se printará el virus.
     */
    public Virus(JPanel pan) {
        coordX = randNum(400, 10);
        coordY = randNum(350, 10);
        radi = randNum(40,10);
        dX = Math.random();
        dY = Math.random();
        panel = pan;
        isAlive = true;

        try {
            BufferedImage imatgeViu = ImageIO.read(getClass().getResource("virus.png"));
            BufferedImage imatgeMort = ImageIO.read(getClass().getResource("virusMort.png"));
            imatgeVivo = imatgeViu.getScaledInstance(radi, radi, Image.SCALE_DEFAULT);
            imatgeMuerto = imatgeMort.getScaledInstance(radi, radi, Image.SCALE_DEFAULT);

        } catch (IOException ex) {}
    }

    /**
     * Función que mueve el virus cambiando la coordenada de aparición cada vez.
     */
    public void moureVirus() {
        Rectangle2D limits = panel.getBounds();
        double width = limits.getWidth();
        double height = limits.getHeight();
        coordX += dX;
        coordY += dY;
        if (coordX > width || coordX < 0) dX = -dX;
        if (coordY > height || coordY < 0) dY = -dY;
    }

    /**
     * Función que nos devuelve un número aleatorio según un mínimo y un máximo.
     * @param max Número máximo que queremos obtener.
     * @param min Número mínimo que queremos obtener.
     * @return Número generado aleatoriamente en el rango indicado.
     */
    public static int randNum(int max, int min) {
        return (int)Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public void matar() {
        this.isAlive = false;
    }

    /**
     * Getter de la coordenada X
     * @return Double coordX;
     */
    public double getCoordX() {
        return coordX;
    }

    /**
     * Getter de la coordenada Y
     * @return Double coordY;
     */
    public double getCoordY() {
        return coordY;
    }

    /**
     * Comprobar si el virus está vivo o no.
     * @return boolean isAlive;
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Getter del radio.
     * @return Double radi;
     */
    public double getRadi() {
        return radi;
    }

    /**
     * Getter de la imagen cuando está vivo.
     * @return Image imatgeVivo;
     */
    public Image getImatgeVivo() {
        return imatgeVivo;
    }

    /**
     * Getter de la imagen cuando está muerto.
     * @return Imatge imatgeMuerto;
     */
    public Image getImatgeMuerto() {
        return imatgeMuerto;
    }

    /**
     * Método que ejecuta el Runnable cuando es llamado. Mueve el virus por el panel.
     */
    @Override
    public void run() {
        while (isAlive) {
            moureVirus();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {}
            panel.repaint();
        }
    }
}
