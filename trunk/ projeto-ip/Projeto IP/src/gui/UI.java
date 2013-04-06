package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
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
		
		textField = new JTextField();
		textField.setBounds(218, 77, 122, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(103, 138, 85, 29);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 137, 122, 30);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(103, 85, 85, 22);
		contentPane.add(lblLogin);
		
		JPanel panel = new JPanel();
		panel.setBounds(229, 205, 102, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addMouseListener(new MouseAdapter() {
			
			
		});
		btnAcessar.setBounds(0, 0, 102, 23);
		panel.add(btnAcessar);
		btnAcessar.addActionListener(new ActionListener() {
			// Pesquisar o login e a senha,caso aquele não exista,enviar um exception e caso a senha esteja incorreta,enviar msg com senha incorreta.
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					SegundoUI ui2 = new SegundoUI();
					ui2.setVisible(true);
					
				} catch (Exception e) {
					
				}
			}
		});
		
		JLabel lblAluguelDeCarros = DefaultComponentFactory.getInstance().createTitle("Aluguel de Carros");
		lblAluguelDeCarros.setFont(new Font("Planet Benson 2", Font.BOLD | Font.ITALIC, 18));
		lblAluguelDeCarros.setBounds(152, 3, 244, 45);
		contentPane.add(lblAluguelDeCarros);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
