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
  private JTextField attrNameTextField = new JTextField();
  private JLabel lName1 = new JLabel();
  private JRadioButton attrIsPrivateRadioButton = new JRadioButton();
  private JRadioButton attrIsPublicRadioButton = new JRadioButton();
  private JComboBox<String> attrTypeComboBox = new JComboBox<String>();
    private DefaultComboBoxModel<String> attrTypeComboBoxModel = new DefaultComboBoxModel<String>();
  private JButton attrHinzufuegenButton = new JButton();
  private JButton attrEntfernenButton = new JButton();
  private JTextArea klasseTextArea = new JTextArea("");
    private JScrollPane klasseTextAreaScrollPane = new JScrollPane(klasseTextArea);
  private JCheckBox attrGetterCheckBox = new JCheckBox();
  private JCheckBox attrSetterCheckBox = new JCheckBox();
  private JCheckBox attrKonstruktorCheckBox = new JCheckBox();
  // Ende Attribute

  Generator g = new Generator();

  public GUI() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 292; 
    int frameHeight = 427;
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
    jList1ScrollPane.setBounds(8, 104, 110, 148);
    jList1.addListSelectionListener(new ListSelectionListener() { 
      public void valueChanged(ListSelectionEvent evt) { 
        jList1_ValueChanged(evt);
      }
    });
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
    attrNameTextField.setBounds(160, 104, 110, 20);
    cp.add(attrNameTextField);
    lName1.setBounds(120, 104, 38, 20);
    lName1.setText("Name:");
    cp.add(lName1);
    attrIsPrivateRadioButton.setBounds(120, 128, 76, 20);
    attrIsPrivateRadioButton.setText("private");
    attrIsPrivateRadioButton.setOpaque(false);
    cp.add(attrIsPrivateRadioButton);
    attrIsPublicRadioButton.setBounds(200, 128, 68, 20);
    attrIsPublicRadioButton.setText("public");
    attrIsPublicRadioButton.setOpaque(false);
    cp.add(attrIsPublicRadioButton);
    attrTypeComboBox.setModel(attrTypeComboBoxModel);
    attrTypeComboBox.setBounds(120, 152, 150, 20);
    attrTypeComboBoxModel.addElement("int");
    attrTypeComboBoxModel.addElement("float");
    attrTypeComboBoxModel.addElement("double");
    attrTypeComboBoxModel.addElement("boolean");
    attrTypeComboBoxModel.addElement("String");
    attrTypeComboBoxModel.addElement("char");
    attrTypeComboBoxModel.addElement("byte");
    attrTypeComboBoxModel.addElement("void");
    cp.add(attrTypeComboBox);
    attrHinzufuegenButton.setBounds(120, 224, 75, 25);
    attrHinzufuegenButton.setText("Hinzufügen");
    attrHinzufuegenButton.setMargin(new Insets(2, 2, 2, 2));
    attrHinzufuegenButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attrHinzufuegenButton_ActionPerformed(evt);
      }
    });
    cp.add(attrHinzufuegenButton);
    attrEntfernenButton.setBounds(200, 224, 75, 25);
    attrEntfernenButton.setText("Entfernen");
    attrEntfernenButton.setMargin(new Insets(2, 2, 2, 2));
    attrEntfernenButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        attrEntfernenButton_ActionPerformed(evt);
      }
    });
    cp.add(attrEntfernenButton);
    klasseTextAreaScrollPane.setBounds(8, 256, 264, 124);
    cp.add(klasseTextAreaScrollPane);
    attrGetterCheckBox.setBounds(120, 176, 60, 20);
    attrGetterCheckBox.setOpaque(false);
    attrGetterCheckBox.setText("getter");
    cp.add(attrGetterCheckBox);
    attrSetterCheckBox.setBounds(200, 176, 60, 20);
    attrSetterCheckBox.setOpaque(false);
    attrSetterCheckBox.setText("setter");
    cp.add(attrSetterCheckBox);
    attrKonstruktorCheckBox.setBounds(120, 200, 156, 20);
    attrKonstruktorCheckBox.setOpaque(false);
    attrKonstruktorCheckBox.setText("Konstruktorparameter");
    cp.add(attrKonstruktorCheckBox);
    // Ende Komponenten

    setVisible(true);
  } // end of public GUI

  // Anfang Methoden

  public static void main(String[] args) {
    new GUI();
  } // end of main

  public void attrHinzufuegenButton_ActionPerformed(ActionEvent evt) {
    g.neuesAttribut();
    updateList();
  } // end of attrHinzufuegenButton_ActionPerformed

  public void attrEntfernenButton_ActionPerformed(ActionEvent evt) {

  } // end of attrEntfernenButton_ActionPerformed

  public void updateKlasse() {
    g.updateKlasse(klassenNameTextField.getText(), klasseIsPrivateRadioButton.isSelected());
    updateTextArea();
  }

  public void updateList() {
    jList1.setListData(g.attributNamen());
  }

  public void updateTextArea() {
    klasseTextArea.setText(g.klasseAlsString());
  }
  public void updateAttrTextFields() {
    Attribut tmp = g.getAttr(jList1.getSelectedIndex());
    attrNameTextField.setText(tmp.name);
    attrIsPrivateRadioButton.setSelected(tmp.privat);
    attrIsPublicRadioButton.setSelected(!tmp.privat);  
    attrTypeComboBox.setSelectedItem(tmp.typ);
    attrGetterCheckBox.setSelected(tmp.getter);
    attrSetterCheckBox.setSelected(tmp.setter);  
    attrKonstruktorCheckBox.setSelected(tmp.konstruktor);
  }

  public void klassenNameTextField_ActionPerformed(ActionEvent evt) {
    updateKlasse();
  } // end of klassenNameTextField_ActionPerformed

  public void klasseIsPrivateRadioButton_ActionPerformed(ActionEvent evt) {
    updateKlasse();
  } // end of klasseIsPrivateRadioButton_ActionPerformed

  public void jList1_ValueChanged(ListSelectionEvent evt) {
    updateAttrTextFields();
  } // end of jList1_ValueChanged

  // Ende Methoden
} // end of class GUI
