package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InserirFuncionarioUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirFuncionarioUI frame = new InserirFuncionarioUI();
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
	public InserirFuncionarioUI() {
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
		
		JLabel lblCadastrarFuncionrio = new JLabel("Cadastrar Funcion\u00E1rio");
		lblCadastrarFuncionrio.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCadastrarFuncionrio.setBounds(304, 46, 274, 34);
		panel.add(lblCadastrarFuncionrio);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(132, 161, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCPF.setBounds(132, 222, 46, 14);
		panel.add(lblCPF);
		
		JLabel lblNascimento = new JLabel("Data de Nascimento:");
		lblNascimento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNascimento.setBounds(428, 353, 152, 20);
		panel.add(lblNascimento);
		
		JLabel lblRG = new JLabel("RG:");
		lblRG.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRG.setBounds(132, 289, 46, 14);
		panel.add(lblRG);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSenha.setBounds(428, 222, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblCTPS = new JLabel("CTPS:");
		lblCTPS.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCTPS.setBounds(132, 356, 46, 14);
		panel.add(lblCTPS);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLogin.setBounds(428, 158, 60, 20);
		panel.add(lblLogin);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEndereco.setBounds(428, 286, 102, 20);
		panel.add(lblEndereco);
		
		textField = new JTextField();
		textField.setBounds(188, 160, 176, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 221, 139, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 283, 139, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(498, 160, 128, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(498, 221, 128, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(508, 288, 248, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(580, 355, 164, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(188, 355, 139, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(553, 436, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(685, 436, 89, 23);
		panel.add(btnCancelar);
	}

}
