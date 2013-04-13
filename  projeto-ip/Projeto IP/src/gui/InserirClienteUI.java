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

import dados.pessoas.Cliente;

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

	/**
	 * Launch the application.
	 */
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
		
		JLabel lblNewLabel_5 = new JLabel("Data de Nascimento:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_5.setBounds(493, 223, 149, 25);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_6.setBounds(493, 290, 83, 20);
		panel.add(lblNewLabel_6);
		
		textNome = new JTextField();
		textNome.setBounds(227, 164, 211, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(227, 227, 132, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		textRG = new JTextField();
		textRG.setBounds(227, 292, 102, 20);
		panel.add(textRG);
		textRG.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(224, 347, 214, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textCNH = new JTextField();
		textCNH.setBounds(549, 164, 155, 20);
		panel.add(textCNH);
		textCNH.setColumns(10);
		
		textData = new JTextField();
		textData.setBounds(652, 227, 132, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		textEndereço = new JTextField();
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
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = new Date(df.parse(textData.getText()).getTime());
			Cliente cliente = new Cliente(textCNH.getText(), textEmail.getText(), textNome.getText(), textCpf.getText(), textRG.getText(),date , textEndereço.getText());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
