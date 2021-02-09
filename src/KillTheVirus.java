import javax.swing.*;

/** Clase Main que inicia el JFrame del juego.
 * @version 09/12/2020
 * @author Carlos Benjumea Cabello
 */
public class KillTheVirus {
    /**
     * Main principal
     * @param args
     */
    public static void main(String[] args) {
        JFrame joc = new KillTheVirusGUI();
        joc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        joc.setVisible(true);
    }
}
