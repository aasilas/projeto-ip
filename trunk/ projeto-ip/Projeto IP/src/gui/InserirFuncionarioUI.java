package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import dados.pessoas.Atendente;
import dados.pessoas.Funcionario;
import exceptions.BIException;
import exceptions.FCException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InserirFuncionarioUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRG;
	private JTextField textLogin;
	private JTextField textSenha;
	private JTextField textEndereco;
	private JTextField textData;
	private JTextField textCTPS;
	private JTextField textSalario;

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
		
		textNome = new JTextField();
		textNome.setBounds(188, 160, 176, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(188, 221, 139, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		textRG = new JTextField();
		textRG.setBounds(188, 283, 139, 20);
		panel.add(textRG);
		textRG.setColumns(10);
		
		textLogin = new JTextField();
		textLogin.setBounds(498, 160, 128, 20);
		panel.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(498, 221, 128, 20);
		panel.add(textSenha);
		textSenha.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(508, 288, 248, 20);
		panel.add(textEndereco);
		textEndereco.setColumns(10);
		
		textData = new JTextField();
		textData.setBounds(580, 355, 164, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		textCTPS = new JTextField();
		textCTPS.setBounds(188, 355, 139, 20);
		panel.add(textCTPS);
		textCTPS.setColumns(10);
		
		textSalario = new JTextField();
		textSalario.setBounds(201, 418, 89, 20);
		panel.add(textSalario);
		textSalario.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
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
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalrio.setBounds(132, 412, 89, 28);
		panel.add(lblSalrio);
	}
	
	private void salvar(){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = new Date(df.parse(textData.getText()).getTime());
				String palavra = textData.getText();
				double salario = Double.parseDouble(textSalario.getText());
				Atendente atendente = new Atendente(textNome.getText(), textCpf.getText(), textRG.getText(), date, textEndereco.getText(), textCTPS.getText(), textLogin.getText(), textSenha.getText(), salario);
				JOptionPane.showMessageDialog(this, "Funcionário Inserido com sucesso!");
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
	}
}
