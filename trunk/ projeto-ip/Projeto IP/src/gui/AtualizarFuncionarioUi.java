package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class AtualizarFuncionarioUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarFuncionarioUi frame = new AtualizarFuncionarioUi();
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
	public AtualizarFuncionarioUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar Funcion\u00E1rio");
		lblAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblAtualizar.setBounds(153, 11, 300, 34);
		contentPane.add(lblAtualizar);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnNome.setBounds(57, 82, 109, 23);
		contentPane.add(rdbtnNome);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnCpf.setBounds(57, 139, 109, 23);
		contentPane.add(rdbtnCpf);
		
		JRadioButton rdbtnEndereo = new JRadioButton("Endere\u00E7o");
		rdbtnEndereo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnEndereo.setBounds(57, 202, 109, 23);
		contentPane.add(rdbtnEndereo);
		
		JRadioButton rdbtnCtps = new JRadioButton("CTPS");
		rdbtnCtps.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnCtps.setBounds(188, 202, 109, 23);
		contentPane.add(rdbtnCtps);
		
		JRadioButton rdbtnDataDeNascimento = new JRadioButton("Data de Nascimento");
		rdbtnDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnDataDeNascimento.setBounds(188, 82, 161, 23);
		contentPane.add(rdbtnDataDeNascimento);
		
		JRadioButton rdbtnRg = new JRadioButton("RG");
		rdbtnRg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnRg.setBounds(188, 141, 109, 23);
		contentPane.add(rdbtnRg);
		
		JRadioButton rdbtnLogin = new JRadioButton("Login");
		rdbtnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnLogin.setBounds(392, 141, 109, 23);
		contentPane.add(rdbtnLogin);
		
		JRadioButton rdbtnSenha = new JRadioButton("Senha");
		rdbtnSenha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnSenha.setBounds(392, 204, 109, 23);
		contentPane.add(rdbtnSenha);
		
		JRadioButton rdbtnSalrio = new JRadioButton("Sal\u00E1rio");
		rdbtnSalrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnSalrio.setBounds(392, 84, 109, 23);
		contentPane.add(rdbtnSalrio);
	}
}
