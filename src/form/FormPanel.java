package form;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    JLabel Bienvenue = new JLabel("Bienvenue");

    JButton button = new JButton("Valider");

    public FormPanel() {
        this.setLayout(new BorderLayout());
        this.add(Bienvenue, BorderLayout.NORTH);
        this.add(button, BorderLayout.SOUTH);

    }
}
