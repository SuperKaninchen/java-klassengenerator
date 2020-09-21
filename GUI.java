import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.09.2020
 * @author 
 */

public class GUI extends JFrame {
  // Anfang Attribute
  private JLabel lAttribute = new JLabel();
  private JList jList1 = new JList();
    private DefaultListModel jList1Model = new DefaultListModel();
    private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JLabel lName = new JLabel();
  private JRadioButton klasseIsPrivateRadioButton = new JRadioButton();
  private JTextField klassenNameTextField = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JLabel lName1 = new JLabel();
  private JRadioButton rbPrivate1 = new JRadioButton();
  private JRadioButton rbPublic1 = new JRadioButton();
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JButton bHinzufuegen = new JButton();
  private JButton bEntfernen = new JButton();
  private JTextArea klasseTextArea = new JTextArea("");
    private JScrollPane klasseTextAreaScrollPane = new JScrollPane(klasseTextArea);
  // Ende Attribute
  
  Generator g = new Generator();
  
  public GUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 292; 
    int frameHeight = 374;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("GUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lAttribute.setBounds(8, 80, 110, 20);
    lAttribute.setText("Attribute:");
    cp.add(lAttribute);
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(8, 104, 110, 100);
    cp.add(jList1ScrollPane);
    lName.setBounds(8, 8, 38, 20);
    lName.setText("Name:");
    cp.add(lName);
    klasseIsPrivateRadioButton.setBounds(8, 32, 68, 20);
    klasseIsPrivateRadioButton.setOpaque(false);
    klasseIsPrivateRadioButton.setText("private");
    klasseIsPrivateRadioButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        klasseIsPrivateRadioButton_ActionPerformed(evt);
      }
    });
    cp.add(klasseIsPrivateRadioButton);
    klassenNameTextField.setBounds(48, 8, 150, 20);
    klassenNameTextField.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        klassenNameTextField_ActionPerformed(evt);
      }
    });
    cp.add(klassenNameTextField);
    jTextField2.setBounds(160, 104, 110, 20);
    cp.add(jTextField2);
    lName1.setBounds(120, 104, 38, 20);
    lName1.setText("Name:");
    cp.add(lName1);
    rbPrivate1.setBounds(120, 128, 76, 20);
    rbPrivate1.setOpaque(false);
    cp.add(rbPrivate1);
    rbPublic1.setBounds(200, 128, 68, 20);
    rbPublic1.setOpaque(false);
    cp.add(rbPublic1);
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(120, 152, 150, 20);
    jComboBox1Model.addElement("int");
    jComboBox1Model.addElement("float");
    jComboBox1Model.addElement("double");
    jComboBox1Model.addElement("boolean");
    jComboBox1Model.addElement("String");
    jComboBox1Model.addElement("char");
    jComboBox1Model.addElement("byte");
    cp.add(jComboBox1);
    bHinzufuegen.setBounds(120, 176, 75, 25);
    bHinzufuegen.setText("Hinzufügen");
    bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bHinzufuegen_ActionPerformed(evt);
      }
    });
    cp.add(bHinzufuegen);
    bEntfernen.setBounds(200, 176, 75, 25);
    bEntfernen.setText("Entfernen");
    bEntfernen.setMargin(new Insets(2, 2, 2, 2));
    bEntfernen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEntfernen_ActionPerformed(evt);
      }
    });
    cp.add(bEntfernen);
    klasseTextAreaScrollPane.setBounds(8, 232, 264, 100);
    cp.add(klasseTextAreaScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI();
  } // end of main
  
  public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bHinzufuegen_ActionPerformed

  public void bEntfernen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bEntfernen_ActionPerformed
  
  public void updateKlasse() {
    System.out.println("UPDATE CALLED");
    g.updateKlasse(klassenNameTextField.getText(), klasseIsPrivateRadioButton.isSelected());
    updateTextArea();
  }
  
  public void updateTextArea() {
    klasseTextArea.setText(g.klasseAlsString());
  }

  public void klassenNameTextField_ActionPerformed(ActionEvent evt) {
    updateKlasse();
  } // end of klassenNameTextField_ActionPerformed

  public void klasseIsPrivateRadioButton_ActionPerformed(ActionEvent evt) {
    updateKlasse();
  } // end of klasseIsPrivateRadioButton_ActionPerformed

  // Ende Methoden
} // end of class GUI

