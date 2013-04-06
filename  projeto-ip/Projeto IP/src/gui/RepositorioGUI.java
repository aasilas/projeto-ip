package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;

public class RepositorioGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepositorioGUI frame = new RepositorioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RepositorioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaCarro = new JLabel("Lista Carros :");
		lblListaCarro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaCarro.setBounds(26, 27, 161, 32);
		contentPane.add(lblListaCarro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setBounds(214, 36, 701, 20);
		contentPane.add(comboBox);
		
		JLabel lblLista = new JLabel("Lista Clientes:");
		lblLista.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLista.setBounds(26, 70, 131, 52);
		contentPane.add(lblLista);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(214, 89, 701, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblListaFuncionrio = new JLabel("Lista Funcion\u00E1rio:");
		lblListaFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaFuncionrio.setBounds(26, 146, 188, 14);
		contentPane.add(lblListaFuncionrio);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(214, 146, 701, 20);
		contentPane.add(comboBox_2);
	}
}
