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

import exceptions.BIException;

import principal.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaEntregarCarro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Fachada fachada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaEntregarCarro frame = new PesquisaEntregarCarro();
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
	public PesquisaEntregarCarro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 459, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEntregarCarro = new JLabel("Entregar Carro");
		lblEntregarCarro.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEntregarCarro.setBounds(162, 23, 125, 24);
		panel.add(lblEntregarCarro);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do cliente:");
		lblCpfDoCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpfDoCliente.setBounds(85, 73, 112, 24);
		panel.add(lblCpfDoCliente);
		
		textField = new JTextField();
		textField.setBounds(207, 77, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAvanar.setBounds(215, 122, 89, 23);
		panel.add(btnAvanar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(328, 122, 89, 23);
		panel.add(btnCancelar);
	}
	
	private void pesquisaCliente(){
		
		try {
			fachada.pesquisarCliente(textField.getText());
			// Chamar a lista 
		} catch (BIException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
