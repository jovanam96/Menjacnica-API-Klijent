package rs.ac.bg.fon.jgrass.menjacnica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menjacnica extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzValuteZemlje;
	private JLabel lblUValutuZemlje;
	private JComboBox comboBoxIZ;
	private JComboBox comboBoxU;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblIznos;
	private JLabel label;
	private JButton btnKonvertuj;

	

	/**
	 * Create the frame.
	 */
	public Menjacnica() {
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzValuteZemlje());
		contentPane.add(getLblUValutuZemlje());
		contentPane.add(getComboBoxIZ());
		contentPane.add(getComboBoxU());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getLblIznos());
		contentPane.add(getLabel());
		contentPane.add(getBtnKonvertuj());
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje");
			lblIzValuteZemlje.setBounds(87, 61, 95, 14);
		}
		return lblIzValuteZemlje;
	}
	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje");
			lblUValutuZemlje.setBounds(223, 61, 95, 14);
		}
		return lblUValutuZemlje;
	}
	private JComboBox<String> getComboBoxIZ() {
		if (comboBoxIZ == null) {
			comboBoxIZ = new JComboBox<String>();
			comboBoxIZ.setBounds(71, 99, 111, 20);
			LinkedList<String> zemlje = GUIKontroler.preuzimiZemlje();
			for (int i = 0; i < zemlje.size(); i++) {
				comboBoxIZ.addItem(zemlje.get(i));
			}
		}
		return comboBoxIZ;
	}
	private JComboBox<String> getComboBoxU() {
		if (comboBoxU == null) {
			comboBoxU = new JComboBox<String>();
			comboBoxU.setBounds(207, 99, 111, 20);
			LinkedList<String> zemlje = GUIKontroler.preuzimiZemlje();
			for (int i = 0; i < zemlje.size(); i++) {
				comboBoxU.addItem(zemlje.get(i));
			}
		}
		return comboBoxU;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(71, 173, 111, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(207, 173, 111, 20);
		}
		return textField_1;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(109, 148, 46, 14);
		}
		return lblIznos;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Iznos");
			label.setBounds(242, 148, 46, 14);
		}
		return label;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(142, 210, 111, 23);
		}
		return btnKonvertuj;
	}
}
