package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InserirCarroUI extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirCarroUI frame = new InserirCarroUI();
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
	public InserirCarroUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 909, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Carro");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(319, 11, 204, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(76, 103, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(76, 160, 61, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Porta:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(76, 213, 73, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pot\u00EAncia:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(76, 271, 73, 32);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marca:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_5.setBounds(76, 333, 73, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_6.setBounds(447, 97, 84, 27);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(156, 102, 132, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 162, 132, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 218, 132, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 279, 132, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(156, 339, 132, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(541, 102, 132, 20);
		panel.add(textField_5);
		
		JRadioButton rdbtnAr = new JRadioButton("Ar");
		rdbtnAr.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnAr.setBounds(447, 159, 109, 23);
		panel.add(rdbtnAr);
		
		JRadioButton rdbtnTravas = new JRadioButton("Travas El\u00E9tricas");
		rdbtnTravas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnTravas.setBounds(633, 159, 171, 23);
		panel.add(rdbtnTravas);
		
		JRadioButton rdbtnSom = new JRadioButton("Som");
		rdbtnSom.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnSom.setBounds(447, 276, 109, 23);
		panel.add(rdbtnSom);
		
		JRadioButton rdbtnAirbag = new JRadioButton("AIRBAG");
		rdbtnAirbag.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnAirbag.setBounds(447, 336, 109, 23);
		panel.add(rdbtnAirbag);
		
		JRadioButton rdbtnGps = new JRadioButton("GPS");
		rdbtnGps.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnGps.setBounds(447, 215, 109, 23);
		panel.add(rdbtnGps);
		
		JRadioButton rdbtnFreiosAbs = new JRadioButton("Freios ABS");
		rdbtnFreiosAbs.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnFreiosAbs.setBounds(642, 215, 109, 23);
		panel.add(rdbtnFreiosAbs);
		
		JRadioButton rdbtnDireoHidrulica = new JRadioButton("Dire\u00E7\u00E3o Hidr\u00E1ulica");
		rdbtnDireoHidrulica.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnDireoHidrulica.setBounds(642, 276, 221, 23);
		panel.add(rdbtnDireoHidrulica);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(529, 428, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(662, 428, 89, 23);
		panel.add(btnNewButton_1);
	}
}
