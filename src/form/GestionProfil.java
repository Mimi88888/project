package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GestionProfil extends JInternalFrame {
    JPanel pn;
    JLabel help;
    JTextField nomTA, prenomTA, pseudoTA;
    JLabel nom, prenom, pseudo;
    JButton enregistrer;
    JSplitPane jsp;
    JTabbedPane jtp;
    JList jl;

    Data ProfilTable;

    DefaultListModel model;

    GestionProfil() {

        ArrayList<FormPanel> TabulationList = new ArrayList<>();
        pn = new JPanel();
        pn.setLayout(new FlowLayout());
        nom = new JLabel("Nom");
        nomTA = new JTextField(15);

        prenom = new JLabel("Prenom");
        prenomTA = new JTextField(15);

        pseudo = new JLabel("Pseudo");
        pseudoTA = new JTextField(15);

        enregistrer = new JButton("Enregistrer");
        pn.add(nom);
        pn.add(nomTA);
        pn.add(prenom);
        pn.add(prenomTA);
        pn.add(pseudo);
        pn.add(pseudoTA);
        pn.add(enregistrer);

        help = new JLabel("Help");
        jsp = new JSplitPane();
        jtp = new JTabbedPane();
        // jtp.addTab("TAB1", new JPanel());
        // jtp.addTab("TAB1", new JPanel());
        model = new DefaultListModel();
        jl = new JList(model);
        jsp.setResizeWeight(0.3);
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);

        nomTA.addFocusListener(new EcouteurFocus(this));
        prenomTA.addFocusListener(new EcouteurFocus(this));
        pseudoTA.addFocusListener(new EcouteurFocus(this));

        // nom.addMouseListener(new EcouteurLabel(this));
        // prenom.addMouseListener(new EcouteurLabel(this));
        // pseudo.addMouseListener(new EcouteurLabel(this));

        this.setTitle("Gestion Profil");
        this.setLocation(200, 200);
        this.setSize(800, 350);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.add(pn, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.CENTER);
        this.add(help, BorderLayout.SOUTH);


        //EVENT

        enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sauvegarder les données dans la base de données
                // à faire:test si vide

                Profil nomProfil = new Profil(nomTA.getText(), prenomTA.getText(), pseudoTA.getText());
                Data.data.add(nomProfil);

                model.addElement(pseudoTA.getText());
            }
        });

        this.setVisible(true);
        jl.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    //Double clique
                    Profil P = Data.ProfilRechercheSelonPseudo(jl.getSelectedValue() + "");
                    FormPanel pn = new FormPanel();
                    TabulationList.add(pn);

                    jtp.addTab(jl.getSelectedValue() + " ", pn);

                    //Clique button droite
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        JPopupMenu contextList = new JPopupMenu();
                        JMenuItem itemModifier = new JMenuItem("Modifier");
                        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
                        JMenuItem itemSupprimerTout = new JMenuItem("Supprimer Tout");
                        contextList.add(itemModifier);
                        contextList.add(itemSupprimer);
                        contextList.add(itemSupprimerTout);
                        contextList.show(GestionProfil.this, e.getX(), e.getY());
                        itemModifier.addActionListener(new EcouteurPopPupMenu(GestionProfil.this));
                        itemSupprimer.addActionListener(new EcouteurPopPupMenu(GestionProfil.this));
                        itemSupprimerTout.addActionListener(new EcouteurPopPupMenu(GestionProfil.this));
                    }
                }
            }

        });

    }
}
