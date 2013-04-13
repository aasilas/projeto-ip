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

public class PesquisaAlugarCarroUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaAlugarCarroUI frame = new PesquisaAlugarCarroUI();
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
	public PesquisaAlugarCarroUI() {
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
		
		JLabel lblAlugarCarro = new JLabel("Alugar Carro");
		lblAlugarCarro.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAlugarCarro.setBounds(171, 24, 146, 25);
		panel.add(lblAlugarCarro);
		
		JLabel lblCpf = new JLabel("CPF do Cliente:");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf.setBounds(83, 77, 119, 19);
		panel.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(212, 78, 146, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//  Verificar se existe o cliente,caso exista, abrir a janela para o cliente escolher o carro.Caso não exista,informar ao funcionário,para que ele venha a cadastrar o cliente.
			}
		});
		btnAvanar.setBounds(212, 122, 89, 23);
		panel.add(btnAvanar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(327, 122, 89, 23);
		panel.add(btnCancelar);
	}

}
