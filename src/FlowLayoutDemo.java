
/**
 * Demo für den Layout-Manager FlowLayout.
 *
 * Wenn Sie dieses Codebeispiel zum Laufen bringen wollen, beachten Sie, dass
 * Sie den Quelltext in einer Datei namens FlowLayoutDemo.java speichern
 * (Achtung auf Groß-und Kleinschreibung) und dass sich die Datei in einem
 * Unterordner „gui“ unter Ihrem Projektordner befinden muss.
 *
 * Die meisten Swing-Formulare leiten javax.swing.JFrame ab.
 *
 * @author phaidros
 */
public class FlowLayoutDemo extends javax.swing.JFrame {

    // Die Objektvariablen für die Elemente auf dem JFrame:

    // Auf dem JPanel wird alles angeordnet.
    // Es ist das Element, dem das Flow-Layout zugewiesen wird
    private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();

    // Die sichtbaren Elemente werden als Objektvariablen angelegt:
    private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    private javax.swing.JButton jButton1 = new javax.swing.JButton();
    private javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    private javax.swing.JTextField jTextField1 = new javax.swing.JTextField();

    /**
     * Der Konstruktor.
     */
    public FlowLayoutDemo() {

        // Was soll bei Klick auf das System-X rechts oben passieren:
        // Das Programm soll gänzlich beendet werden.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Beachten Sie, dass Swing gar nicht so selten auf Elemente der
        // Vorgänger-Bibliothek 'awt' zugreift. Auch Das FlowLayout gehört
        // eigentlich zum awt. Das JPanel bekommt sein Layout:
        jPanel1.setLayout( new java.awt.FlowLayout() );

        // Das JLabel beschriften…
        jLabel1.setText ( "1. ein JLabel" );
        // …und dem JPanel zuweisen
        jPanel1.add ( jLabel1 );

        // Den JButton beschriften…
        jButton1.setText ( "2. einjButton" );

        /** Der Vollständigkeit halber fügen wir einen ActionListener ein –
         * hier ausgeführt als innere Klasse. Aber das ist nicht das Thema
         * dieses Code-Beispiels.
         */
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // …und dem JPanel zuweisen
        jPanel1.add ( jButton1 ) ;

        // Das Gleiche für jTextField1 und jLabel2:
        jTextField1.setText ( "3. ein jTextField" ) ;
        jPanel1.add ( jTextField1 ) ;

        jLabel2.setText ( "4. wieder ein jLabel usw." ) ;
        jPanel1.add ( jLabel2 ) ;

        // Das Panel zum aktiven, sichtbaren Inhalt des JFrame machen:
        this.getContentPane().add ( jPanel1 ) ;

        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();
    }

    /**
     * Die Listener-Methode des JButton.
     * Wird von der oben implementierte ActionListener-Klasse aufgerufen.
     */
    private void jButton1ActionPerformed( java.awt.event.ActionEvent evt ) {
        // TODO add your handling code here:
    }

    /*
     * Jedes Java-Programm beginnt bei einer Methode main() zu laufen, so auch
     * dieses. Beachten Sie, dass die Methode main() in jeder beliebigen
     * Klasse stehen könnte, die Zugriff auf FlowLayoutDemo hat, also auch in
     * ihr selbst – also hier:
     */
    public static void main(String args[]) {
        // Ein Objekt der Klasse erzeugen und sichtbar machen.
        new FlowLayoutDemo().setVisible ( true );
    }
}