import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class test2 implements ActionListener {
    JButton button, button2;
    ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\dark.png");
    ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\light.png");
    public static final String CARD_URL = "http://assets0.wordansassets.com/wvc-1345850020/wordansfiles/images/2012/8/24/156256/156256_340.jpg";

    protected void createAndShowGUI() throws MalformedURLException {
        JFrame frame = new JFrame("Test button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.button = new JButton(imageIcon1);
        this.button2 = new JButton(imageIcon1);
        this.button.setDisabledIcon(imageIcon2);
        this.button2.setDisabledIcon(imageIcon2);
        button.addActionListener(this);
        button2.addActionListener(this);
        frame.add(button, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        if (ae.getSource() == button) {
            System.out.print("test1");
            button.setEnabled(false);
        }
        if (ae.getSource() == button2) {
            System.out.print("test2");
            button2.setEnabled(false);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new test2().createAndShowGUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}