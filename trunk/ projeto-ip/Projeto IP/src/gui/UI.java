package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exceptions.BIException;

import principal.Fachada;

@SuppressWarnings("serial")
public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private Fachada fachada;
	private JTextField textCpf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 359);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		textLogin.setBounds(218, 77, 122, 30);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(103, 138, 85, 29);
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPane.add(lblSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(218, 137, 122, 30);
		contentPane.add(textSenha);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(103, 85, 85, 22);
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPane.add(lblLogin);
		
		
		JLabel lblAluguelDeCarros_1 = new JLabel("Aluguel de Carros");
		lblAluguelDeCarros_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblAluguelDeCarros_1.setBounds(179, 17, 214, 48);
		contentPane.add(lblAluguelDeCarros_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCpf.setBounds(103, 195, 70, 33);
		contentPane.add(lblCpf);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(229, 267, 102, 23);
		contentPane.add(btnAcessar);
		
		textCpf = new JTextField();
		textCpf.setBounds(218, 200, 122, 28);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		btnAcessar.addMouseListener(new MouseAdapter() {
			
			
		});
		btnAcessar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				verificarConta();
			}
		});
	}
	
	private void verificarConta() {
		
		
		try {
			
			boolean cadastro = fachada.verificarLogin(textLogin.getText(),textSenha.toString(),textCpf.getText());
			if(cadastro){
			SegundoUI ui2 = new SegundoUI();
			ui2.setVisible(true);
			dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Busca Inexistente!");
		}
	}
	
	}

