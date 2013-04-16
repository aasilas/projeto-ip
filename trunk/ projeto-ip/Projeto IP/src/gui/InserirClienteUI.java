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
import javax.xml.crypto.Data;

import principal.Fachada;

import dados.carros.Carro;
import dados.pessoas.Cliente;
import exceptions.BIException;
import exceptions.CCException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InserirClienteUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRG;
	private JTextField textEmail;
	private JTextField textCNH;
	private JTextField textData;
	private JTextField textEndereço;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	private String CPF;
	private String CNH;
	private String email;
	private String nome;
	private String rg;
	private Date data;
	private String endereco;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirClienteUI frame = new InserirClienteUI();
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
	public InserirClienteUI() {
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
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCadastrarCliente.setBounds(313, 39, 226, 43);
		panel.add(lblCadastrarCliente);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(168, 160, 97, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(168, 225, 55, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(168, 290, 28, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(168, 348, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CNH:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(493, 165, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data de Nascimento(//):");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_5.setBounds(493, 223, 171, 25);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_6.setBounds(493, 290, 83, 20);
		panel.add(lblNewLabel_6);
		
		textNome = new JTextField();
		textNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nome = textNome.getText();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Nome Inválido!");
				}
			}
		});
		textNome.setBounds(227, 164, 211, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarCpf();
			}
		});
		textCpf.setBounds(227, 227, 132, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		textRG = new JTextField();
		textRG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rg = textRG.getText();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "RG Inválido!");
				}
			}
		});
		textRG.setBounds(227, 292, 102, 20);
		panel.add(textRG);
		textRG.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					email = textEmail.getText();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Email Inválido!");
				}
			}
		});
		textEmail.setBounds(224, 347, 214, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textCNH = new JTextField();
		textCNH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CNH = textCNH.getText();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "CNH Inválida!");
				}
			}
		});
		textCNH.setBounds(549, 164, 155, 20);
		panel.add(textCNH);
		textCNH.setColumns(10);
		
		textData = new JTextField();
		textData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoData = textData.getText();
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
		});
		textData.setBounds(674, 227, 132, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		textEndereço = new JTextField();
		textEndereço.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco = textEndereço.getText();
			}
		});
		textEndereço.setBounds(586, 292, 198, 20);
		panel.add(textEndereço);
		textEndereço.setColumns(10);
		
		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvarCliente.setBounds(553, 436, 89, 23);
		panel.add(btnSalvarCliente);
		
		JButton btnCancelarCliente = new JButton("Cancelar");
		btnCancelarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelarCliente.setBounds(673, 436, 89, 23);
		panel.add(btnCancelarCliente);
	}
	
	private void salvar(){
		
		//Cliente cliente = new Cliente(CNH, email, nome, CPF, rg, data, endereco);
		Cliente cliente = new Cliente("wdowdkdw", "cskcs", "wddw", "90309393180", "wdókwdo", new Date(), "endereco");
		try {
			SegundoUI.fachada.cadastrarCliente(cliente);
			cliente.getCarro();
		} catch (CCException e) {
			e.printStackTrace();
		}
	}
	private void verificarCpf() {
		String textoCpf = textCpf.getText();
		boolean achou = false;
		try {
			fachada.pesquisarCliente(textoCpf);
			
		} catch (BIException e2) {
			CPF = textoCpf;
			achou = true;
		}finally{
			if(achou){
				JOptionPane.showMessageDialog(null, "Cliente já Cadastrado!");
			}
		}
	}
	
}
