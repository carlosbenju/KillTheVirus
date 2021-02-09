import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Clase que contiene los botones, el panel y gestiona su funcionamiento.
 * @version 09/12/2020
 * @author Carlos Benjumea Cabello
 */
public class KillTheVirusGUI extends JFrame {

    private PanelVirus panelVirus = new PanelVirus();

    /**
     * Constructor del GUI, creando el panel y los botones.
     */
    public KillTheVirusGUI() {
        setBounds(600, 300, 400, 350);
        setTitle("Kill the Virus");
        add(panelVirus, BorderLayout.CENTER);
        JPanel botones = new JPanel();
        JButton pandemic = new JButton("Pandemic!");
        JButton sortir = new JButton("Sortir");
        botones.add(pandemic);
        botones.add(sortir);
        pandemic.addActionListener(new ClickPandemic());
        sortir.addActionListener(new ClickSortir());
        add(botones, BorderLayout.SOUTH);
    }

    /**
     *  Clase que implementa el listener del botón Pandemic y le da su función.
     */
    class ClickPandemic implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int rand = (int) (Math.random() * ((10 - 5) + 1));
            for (int i = 0; i < rand; i++) {
                Virus v = new Virus(panelVirus);
                Thread t = new Thread(v);
                t.start();
                panelVirus.add(v);
            }
        }
    }

    /**
     * Clase que implementa el listener del botón Salir y le da su función.
     */
    class ClickSortir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }


}
