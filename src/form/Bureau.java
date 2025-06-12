package form;

import javax.swing.*;


public class Bureau extends JFrame {

    JMenuBar mb;
    JDesktopPane desktop;
    GestionProfil gestionProfil;
    CurriculumForm curriculumForm;
    Bureau(){

        curriculumForm= new CurriculumForm();
        desktop = new JDesktopPane();
        gestionProfil= new GestionProfil();

        mb= new JMenuBar();
        JMenuItem itemTp1 = new JMenuItem("TP1");
        JMenuItem itemTp2 = new JMenuItem("TP2");
        JMenu swingTP= new JMenu("TP Swing");
        JMenu baseTP= new JMenu("TP Base");
        swingTP.add(itemTp1);
        swingTP.add(itemTp2);

        mb.add(swingTP);
        mb.add(baseTP);
        this.add(mb);
        this.setSize(1000,1000);
        this.setJMenuBar(mb);
        this.setVisible(true);


        desktop.add(gestionProfil);
        desktop.add(curriculumForm);
        this.add(desktop);

    }

    public static void main(String[] args) {
    Bureau Bureau=new Bureau();

    }

}
