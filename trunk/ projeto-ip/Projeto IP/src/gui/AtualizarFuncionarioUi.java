package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dados.pessoas.Atendente;
import dados.pessoas.Funcionario;
import exceptions.BIException;

import principal.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

public class AtualizarFuncionarioUi extends JFrame {

	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textNome;
	private JTextField textCtps;
	private JTextField textRg;
	private JTextField textEndereco;
	private JTextField textDate;
	private JTextField textSenha;
	private JTextField textLogin;
	private JTextField textSalario;
	private Fachada fachada;
	private boolean achou = false;
	private Date data;
	private double salario;
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
		setBounds(100, 100, 584, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar Funcion\u00E1rio");
		lblAtualizar.setBounds(153, 11, 300, 34);
		lblAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		contentPane.add(lblAtualizar);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCpf.setBounds(178, 56, 47, 25);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoCpf = textCpf.getText();
				try {
					fachada.pesquisarFuncionario(textoCpf);
					achou = true;
				} catch (BIException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		textCpf.setBounds(230, 62, 131, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNome.setBounds(60, 106, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(117, 105, 108, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCtps = new JLabel("Ctps:");
		lblCtps.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCtps.setBounds(60, 135, 59, 20);
		contentPane.add(lblCtps);
		
		textCtps = new JTextField();
		textCtps.setBounds(117, 137, 108, 20);
		contentPane.add(textCtps);
		textCtps.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEndereo.setBounds(60, 194, 78, 25);
		contentPane.add(lblEndereo);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRg.setBounds(60, 169, 37, 14);
		contentPane.add(lblRg);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLogin.setBounds(287, 133, 46, 25);
		contentPane.add(lblLogin);
		
		textRg = new JTextField();
		textRg.setBounds(117, 168, 108, 20);
		contentPane.add(textRg);
		textRg.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSenha.setBounds(287, 108, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalrio.setBounds(287, 169, 57, 15);
		contentPane.add(lblSalrio);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento(//):");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(60, 230, 166, 14);
		contentPane.add(lblDataDeNascimento);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(139, 198, 222, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		textDate = new JTextField();
		textDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textDate.setBounds(235, 229, 126, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(343, 105, 86, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		textLogin = new JTextField();
		textLogin.setBounds(343, 137, 86, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSalario = new JTextField();
		textSalario.setBounds(343, 168, 86, 20);
		contentPane.add(textSalario);
		textSalario.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(achou){
					date();
					Salario();
					
					Funcionario funcionario = new Atendente(textNome.getText(), textCpf.getText(), textRg.getText(),data , textEndereco.getText(), textCtps.getText(), textLogin.getText(), textSenha.getText(), salario);
					fachada.atualizarFuncionario(funcionario);
				}
			}
		});
		btnAtualizar.setBounds(365, 258, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(458, 258, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	private void date(){
		String textoData = textDate.getText();
		if(textoData.length() == 0){
			JOptionPane.showConfirmDialog(null, "Insira a Data de Nascimento!");
		}else if(textoData.length() > 0 && textoData.length() < 11){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				data = new Date(df.parse(textoData).getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Data Inválida!");
		}
		
	}
	
	private void Salario(){
		String textoSalario = textSalario.getText();
		salario = Double.parseDouble(textoSalario);
	}
}
