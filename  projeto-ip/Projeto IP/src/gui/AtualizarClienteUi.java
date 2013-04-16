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

import dados.pessoas.Cliente;

import exceptions.BIException;

import principal.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

public class AtualizarClienteUi extends JFrame {

	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textEmail;
	private JTextField textCnh;
	private JTextField textRG;
	private JTextField textDate;
	private Fachada fachada;
	private Cliente cliente;
	private Date data;
	private boolean achou;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarClienteUi frame = new AtualizarClienteUi();
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
	public AtualizarClienteUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarCliente = new JLabel("Atualizar Cliente");
		lblAtualizarCliente.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblAtualizarCliente.setBounds(174, 22, 230, 24);
		contentPane.add(lblAtualizarCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCpf.setBounds(154, 71, 53, 24);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String textoCpf = textCpf.getText();
					fachada.pesquisarCliente(textoCpf);
					achou = true;
				} catch (BIException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		textCpf.setBounds(209, 77, 131, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNome.setBounds(62, 121, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(118, 120, 120, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEndereo.setBounds(62, 166, 82, 14);
		contentPane.add(lblEndereo);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(139, 165, 99, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(62, 206, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(108, 205, 130, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCnh = new JLabel("Cnh:");
		lblCnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCnh.setBounds(295, 121, 46, 14);
		contentPane.add(lblCnh);
		
		textCnh = new JTextField();
		textCnh.setBounds(334, 118, 86, 20);
		contentPane.add(textCnh);
		textCnh.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRg.setBounds(295, 166, 46, 14);
		contentPane.add(lblRg);
		
		textRG = new JTextField();
		textRG.setBounds(334, 163, 86, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento(//):");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(295, 208, 178, 14);
		contentPane.add(lblDataDeNascimento);
		
		textDate = new JTextField();
		textDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date();
			}
		});
		textDate.setBounds(460, 205, 86, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (achou) {
					cliente = new Cliente(textCnh.getText(), textEmail.getText(), textNome.getText(), textCpf.getText(), textRG.getText(),data, textEndereco.getText());
					fachada.atualizarCliente(cliente);
				}else{
					JOptionPane.showMessageDialog(null, "Cliente Inexistente!");
				}
			}
		});
		btnAtualizar.setBounds(315, 244, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(428, 244, 89, 23);
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
}
