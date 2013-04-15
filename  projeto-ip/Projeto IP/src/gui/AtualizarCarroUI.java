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
import java.awt.TextField;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;

import dados.carros.Adicionais;
import dados.carros.Carro;

import exceptions.BIException;

import principal.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AtualizarCarroUI extends JFrame {

	private JPanel contentPane;
	private JTextField textPlaca;
	private Fachada fachada;
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textPotencia;
	private JTextField textValor;
	private JTextField textCategoria;
	private JTextField textPorta;
	
	/**
	 * Launch the application.
	 */
	private boolean ar = false;
	private boolean gps = false;
	private boolean travasEletricas = false;
	private boolean som = false;
	private boolean freioABS = false;
	private boolean airbag = false;
	private boolean dirHidraulica = false;
	private double valor;
	private int porta;
	private Carro carro;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarCarroUI frame = new AtualizarCarroUI();
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
	public AtualizarCarroUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarCarro = new JLabel("Atualizar Carro");
		lblAtualizarCarro.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblAtualizarCarro.setBounds(187, 11, 223, 34);
		contentPane.add(lblAtualizarCarro);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPlaca.setBounds(172, 54, 61, 20);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String placa = textPlaca.getText();
				fachada.pesquisarCarro(placa);
				Adicionais adicionais= new Adicionais(ar, gps, travasEletricas, som, freioABS, airbag, dirHidraulica);
				carro = new Carro(placa, porta, textPorta.getText(), textModelo.getText(), textMarca.getText(), textCategoria.getText(), adicionais, valor);
				
				} catch (BIException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		textPlaca.setBounds(243, 56, 140, 20);
		contentPane.add(textPlaca);
		textPlaca.setColumns(10);
		
		JRadioButton rdbtnSom = new JRadioButton("Som");
		rdbtnSom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				som = true;
			}
		});
		rdbtnSom.setBounds(218, 211, 61, 23);
		contentPane.add(rdbtnSom);
		
		JRadioButton rdbtnAirbag = new JRadioButton("Airbag");
		rdbtnAirbag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				airbag = true;
			}
		});
		rdbtnAirbag.setBounds(314, 177, 109, 23);
		contentPane.add(rdbtnAirbag);
		
		JRadioButton rdbtnFreiosabs = new JRadioButton("FreiosABS");
		rdbtnFreiosabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				freioABS = true;
			}
		});
		rdbtnFreiosabs.setBounds(436, 104, 109, 23);
		contentPane.add(rdbtnFreiosabs);
		
		JRadioButton rdbtnDireoHid = new JRadioButton("Dire\u00E7\u00E3o Hid.");
		rdbtnDireoHid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dirHidraulica = true;
			}
		});
		rdbtnDireoHid.setBounds(436, 144, 109, 23);
		contentPane.add(rdbtnDireoHid);
		
		JRadioButton rdbtnAr = new JRadioButton("Ar");
		rdbtnAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ar = true;
			}
		});
		rdbtnAr.setBounds(436, 189, 109, 23);
		contentPane.add(rdbtnAr);
		
		JRadioButton rdbtnTravas = new JRadioButton("Travas");
		rdbtnTravas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				travasEletricas = true;
			}
		});
		rdbtnTravas.setBounds(314, 211, 109, 23);
		contentPane.add(rdbtnTravas);
		
		JRadioButton rdbtnGps = new JRadioButton("Gps");
		rdbtnGps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gps = true;
			}
		});
		rdbtnGps.setBounds(218, 177, 68, 23);
		contentPane.add(rdbtnGps);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(37, 93, 46, 14);
		contentPane.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBounds(103, 90, 86, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(37, 138, 46, 19);
		contentPane.add(lblMarca);
		
		JLabel lblPotncia = new JLabel("Pot\u00EAncia:");
		lblPotncia.setBounds(37, 172, 68, 32);
		contentPane.add(lblPotncia);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(37, 215, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(229, 126, 39, 42);
		contentPane.add(lblPorta);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(229, 83, 61, 34);
		contentPane.add(lblCategoria);
		
		textMarca = new JTextField();
		textMarca.setBounds(103, 137, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textPotencia = new JTextField();
		textPotencia.setBounds(103, 178, 86, 20);
		contentPane.add(textPotencia);
		textPotencia.setColumns(10);
		
		textValor = new JTextField();
		textValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarValor();
			}
		});
		textValor.setBounds(103, 212, 86, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(297, 90, 86, 20);
		contentPane.add(textCategoria);
		textCategoria.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setBounds(297, 137, 86, 20);
		contentPane.add(textPorta);
		textPorta.setColumns(10);
		
		JButton btnSalvar = new JButton("Atualizar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fachada.atualizarCarro(carro);
			}
		});
		btnSalvar.setBounds(351, 241, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(456, 241, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	private void verificarValor(){
		try {
			String textoValor = textValor.getText();
			double valorAluguel = Double.parseDouble(textoValor);
			valor = valorAluguel;
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Válor Inválido!");
		}
	}
	

	private void verificarPorta(){
		String textoPorta = textPorta.getText();
		try {
			int numPorta = Integer.parseInt(textoPorta);
			if(numPorta > 0 || numPorta < 5){
				porta = numPorta;
			}else{
				JOptionPane.showMessageDialog(null,"Válor Inválido!");

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,"Válor Inválido!");
		}
	}
}
