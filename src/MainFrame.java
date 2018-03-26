import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainFrame extends javax.swing.JFrame implements ActionListener{
    Map<String, String> dictionary = new HashMap<String, String>();
    JButton[][] buttons;
    public MainFrame() {
        JFrame mainframe;

        dictionary.put("dark", "C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\dark.png");
        dictionary.put("white", "C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\light.png");
        dictionary.put("transparent", "C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\transparent.png");
        JPanel jPanel1 = new javax.swing.JPanel();
        JPanel jPanell2 = new javax.swing.JPanel();
        mainframe = generateFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.buttons =  generateButtons(64);
        mainframe.setVisible(true);
        jPanel1.setLayout( new GridLayout( 8, 8 ) );

        JButton button4 = new JButton("Neutstart");
        button4.setSize(10, 5);

        jPanell2.setLayout( new java.awt.BorderLayout() );

        jPanell2.add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanell2.add(button4, BorderLayout.PAGE_END);



        for (JButton[] button: buttons) {
            for (JButton butt: button) {
                jPanel1.add(butt);
                butt.addActionListener(this);
            }
        }

        Component[] comp = jPanel1.getComponents();
        for (int i = 0;i<comp.length;i++) {
            if (comp[i] instanceof JButton) {
                if (i == 5) {
                    //((JButton) comp[i]).setIcon(new ImageIcon(dictionary.get("white")));
                }
            }
        }
        buttons[4][4].setIcon(new ImageIcon(dictionary.get("dark")));
        buttons[4][4].setEnabled(true);

        buttons[3][3].setIcon(new ImageIcon(dictionary.get("dark")));
        buttons[3][3].setEnabled(true);

        buttons[4][3].setIcon(new ImageIcon(dictionary.get("white")));
        buttons[4][3].setEnabled(true);

        buttons[3][4].setIcon(new ImageIcon(dictionary.get("white")));
        buttons[3][4].setEnabled(true);



        mainframe.add(jPanell2);


        System.out.println(mainframe.getContentPane());
        //mainframe.repaint();
    }
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        for (JButton[] button: buttons) {
            for (JButton butt: button) {
                if (ae.getSource() == button) {
                    butt.setIcon(new ImageIcon(dictionary.get("transparent")));
                }
            }
        }

    }
    public JFrame generateFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Word Cloud");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        return frame;
    }
    public JButton[][] generateButtons(int count) {
        JButton[][] buttons = new JButton[8][8];
        for (int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                JButton button = new JButton();
                button.setEnabled(false);
                button.setSize(10, 10);
                buttons[j][i] = button;
            }
        }
        return buttons;
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
