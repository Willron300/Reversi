import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainFrame extends javax.swing.JFrame implements ActionListener{
    JButton[][] buttonSpielfeld;
    JButton buttonNeustart;
    Map<String, ImageIcon> dictionary = new HashMap<String, ImageIcon>();


    public MainFrame() {
        JFrame mainframe;

        dicDic();
        System.out.println("Start");
        mainframe = generateFrame();
        System.out.println("Ende");
        neuStart();
        spiele(0 , 0, dictionary.get("white"));
    }

    public void spiele(int x, int y, Icon zug) {
        int[][] directions = new int[][] {{-1, -1}, {-1, 0}, {-1,1}, {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1,1}};
        for (int i = 0; i < buttonSpielfeld.length; i++) {
            for (int j = 0; j < buttonSpielfeld[i].length; j++) {
                for (int[] dire: directions) {
                    if (revi(i, j, dire, buttonSpielfeld[i][j].getIcon(), 0)) {
                        if (!buttonSpielfeld[i+dire[0]][j+dire[1]].getIcon().equals(zug)) {
                            buttonSpielfeld[i][j].setEnabled(true);
                        }

                    }
                }
            }
        }
    }

    public Boolean revi(int x, int y, int[] dir, Icon icon, int counter) {

        if (x + dir[0] >= 0 && x + dir[0] <= 7 && y + dir[1] >= 0 && y + dir[1] <= 7) {
            if (!(buttonSpielfeld[x + dir[0]][y + dir[1]].getIcon().equals(dictionary.get("transparent")))) {
                if (buttonSpielfeld[x + dir[0]][y + dir[1]].getIcon().equals(buttonSpielfeld[x][y].getIcon()) || counter == 0) {
                    counter++;
                    return revi(x + dir[0], y + dir[1], dir, icon, counter);
                } else {
                    return Boolean.TRUE;
                }
            } else {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
    public void actionPerformed (ActionEvent ae){
        // Die Quelle wird mit getSource() abgefragt und mit den
        // Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
        // der Buttons ist, wird der Text des JLabels entsprechend geändert
        if (ae.getSource() == buttonNeustart) {
            neuStart();
        }

        for (JButton[] buttons: buttonSpielfeld) {
            for (JButton button: buttons) {
                if (ae.getSource() == button) {
                    button.setIcon(dictionary.get("dark"));
                }
            }
        }

    }

    public void neuStart() {
        for (JButton[] buttons: buttonSpielfeld) {
            for (JButton button: buttons) {
                button.setIcon(dictionary.get("transparent"));
                button.setEnabled(false);
            }
        }
        changeButton(dictionary.get("white"), 3,3);
        changeButton(dictionary.get("white"), 4,4);
        changeButton(dictionary.get("dark"), 4,3);
        changeButton(dictionary.get("dark"), 3,4);
        /*
        buttonSpielfeld[3][2].setEnabled(true);
        buttonSpielfeld[2][3].setEnabled(true);
        buttonSpielfeld[4][5].setEnabled(true);
        buttonSpielfeld[5][4].setEnabled(true);
        */
    }
    public void changeButton(ImageIcon icon, JButton button) {
        button.setIcon(icon);
        button.setDisabledIcon(icon);
        button.setEnabled(false);
    }
    public void changeButton(ImageIcon icon, int x, int y){
        buttonSpielfeld[y][x].setIcon(icon);
        buttonSpielfeld[y][x].setDisabledIcon(icon);
        buttonSpielfeld[y][x].setEnabled(false);
    }
    public void getActionListener() {

        for (JButton[] buttons: this.buttonSpielfeld) {
            for (JButton button: buttons) {
                button.addActionListener(this);
            }
        }
        buttonNeustart.addActionListener(this);

    }
    public JPanel besezteSpielfeld(JPanel panel) {
        for (JButton[] buttons : this.buttonSpielfeld) {
            for (JButton button : buttons) {
                panel.add(button);
            }
        }
        return panel;
    }

    public void generateButtons() {
        this.buttonSpielfeld = new JButton[8][8];
        for (int i = 0; i < this.buttonSpielfeld.length; i++) {
            for(int j = 0; j < this.buttonSpielfeld[i].length; j++) {
                JButton button = new JButton(dictionary.get("transparent"));
                //JButton button = new JButton();
                button.setSize(10, 10);
                this.buttonSpielfeld[j][i] = button;
            }
        }
        this.buttonNeustart = new JButton("Neutstart");
        this.buttonNeustart.setSize(10, 5);
    }
    public JFrame generateFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Riversi");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel jPanelHaupt = new javax.swing.JPanel();
        JPanel jPanelSpielfeld = new javax.swing.JPanel();

        generateButtons();

        jPanelSpielfeld.setLayout( new GridLayout( 8, 8 ) );
        jPanelHaupt.setLayout( new java.awt.BorderLayout() );

        jPanelSpielfeld = besezteSpielfeld(jPanelSpielfeld);
        System.out.println("Jetzt");
        jPanelHaupt.add(jPanelSpielfeld, java.awt.BorderLayout.CENTER);
        jPanelHaupt.add(this.buttonNeustart, BorderLayout.PAGE_END);

        frame.add(jPanelHaupt);
        getActionListener();

        return frame;
    }
    public void dicDic() {
        this.dictionary.put("dark", new ImageIcon("C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\dark.png"));
        this.dictionary.put("white", new ImageIcon("C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\light.png"));
        this.dictionary.put("transparent", new ImageIcon("C:\\Users\\Willi\\IdeaProjects\\Reversi\\images\\transparent.png"));
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
