package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CurriculumForm extends JInternalFrame  {
    JLabel lb_title;
    JButton btQuitter, btValider;
    public CurriculumForm(){
        super();
        btQuitter = new JButton("Quitter");
        this.add(btQuitter);
        btValider = new JButton("Valider");
        this.add(btValider);

        this.setTitle("FORM");
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        lb_title= new JLabel("CV");
        lb_title.setForeground(Color.white);
        lb_title.setOpaque(true);
        lb_title.setBackground(Color.MAGENTA);
        lb_title.setFont(new Font(Font.MONOSPACED, Font.BOLD|Font.ITALIC,20));
        lb_title.setPreferredSize(new Dimension(800,80));
        lb_title.setHorizontalAlignment(JLabel.CENTER);

        //event

        this.add(lb_title);
        this.add(btQuitter);
        this.add(btValider);

        JLabel lb_nom= new JLabel("NOM");
        JTextField nom_field= new JTextField();
        JLabel lb_prenom= new JLabel("PRENOM");
        JTextField prenom_field= new JTextField();


        btQuitter.addActionListener(new Ecouteur());
        btValider.addActionListener(new Ecouteur());

        setVisible(true);

    }
    class Ecouteur implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btQuitter){
                System.exit(0);
            }
            if(e.getSource()==btValider){

                File f= new File("cv.html");
                try {
                    FileWriter fz=new FileWriter(f,false);
                    fz.write("<!DOCTYPE html>\n"+
                    "<html lang=\"en\">\n"+
                    "<head><meta charset=\"UTF-8\"><title>Your Name - CV</title></head>\n"+
                    "<body>\n"+
                    "<h1>Your Name</h1>\n"+
                    "<h2>Professional Summary</h2>\n"+
                    "<p>Brief description of your professional background.</p>\n"+
                    "<h2>Experience</h2>\n"+
                    "<ul><li>Job Title at Company (Year - Year)</li></ul>\n"+
                    "</body>\n"+
                    "</html>\n" );
                    fz.close();

                    Desktop.getDesktop().open(f);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}
