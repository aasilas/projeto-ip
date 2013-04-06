package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;

public class SegundoUI extends JFrame {

	private JPanel contentPane;
	private JTable Carros;
	private JTable CarroDisponivel;
	private JTable CarroIndisponivel;
	private JTable Clientes;
	private JTable ClientesAtendimento;
	private Panel panel;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtDataDeNascimento;
	private JTextField txtEmail;
	private JTextField txtCnh;
	private JTextField txtEndereo;
	private JTextField txtPlaca;
	private JTextField txtPorta;
	private JTextField txtPotncia;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtAr;
	private JTextField txtGps;
	private JTextField txtTravas;
	private JTextField txtSom;
	private JTextField txtFreiosAbs;
	private JTextField txtAirbag;
	private JTextField txtDireoHidrulica;
	private JTextField textField;
	private JTextField txtNome_1;
	private JTextField txtCpf_1;
	private JTextField txtRg_1;
	private JTextField txtDataDeNascimento_1;
	private JTextField txtEndereo_1;
	private JTextField txtCtps;
	private JTextField txtLogin;
	private JTextField txtSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundoUI frame = new SegundoUI();
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
	public SegundoUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 716, 21);
		contentPane.add(menuBar);

		JMenu mnListas = new JMenu("Carros");
		mnListas.setBackground(new Color(0, 153, 255));
		mnListas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnListas);

		JMenuItem mntmCarrosDaloja = new JMenuItem("Carros da loja");
		mntmCarrosDaloja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				// mandar um get repositorio,pra ele imprimir as informações dos carros
				JPanel panel = new JPanel();
				panel.setBounds(10, 33, 700, 462);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 694, 462);
				panel.add(scrollPane);

				Carros = new JTable();
				Carros.setModel(new DefaultTableModel(
						new Object[][] {
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
						},
						new String[] {
								"Carros"
						}
				));
				Carros.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(Carros);

			}
		});
		mnListas.add(mntmCarrosDaloja);

		JMenuItem mntmCarrosAlugados = new JMenuItem("Carros Alugados");
		mntmCarrosAlugados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				// Verificar se já existe uma lista aberta e caso sim,fechar e abrir a desejada.
				// Mostrar os carros que tem o disponibilidade false
				JPanel panel = new JPanel();
				panel.setBounds(10, 33, 700, 462);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 694, 462);
				panel.add(scrollPane);

				CarroIndisponivel = new JTable();
				CarroIndisponivel.setModel(new DefaultTableModel(
						new Object[][] {
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
						},
						new String[] {
								"Carros Indisponiveis"
						}
				));
				CarroIndisponivel.getColumnModel().getColumn(0).setPreferredWidth(620);
				scrollPane.setViewportView(CarroIndisponivel);

			}
		});
		mnListas.add(mntmCarrosAlugados);

		JMenuItem mntmCarrosDisponveis = new JMenuItem("Carros dispon\u00EDveis");
		mntmCarrosDisponveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				// Imprimir carros com disponibilidade true
				JPanel panel = new JPanel();
				panel.setBounds(10, 33, 700, 462);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 694, 462);
				panel.add(scrollPane);

				CarroDisponivel = new JTable();
				CarroDisponivel.setModel(new DefaultTableModel(
						new Object[][] {
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
						},
						new String[] {
								"Carros Disponiveis"
						}
				));
				CarroDisponivel.getColumnModel().getColumn(0).setPreferredWidth(620);
				scrollPane.setViewportView(CarroDisponivel);
			}
		});
		mnListas.add(mntmCarrosDisponveis);

		JMenu mnCliente = new JMenu("  Cliente");
		mnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnCliente);

		JMenuItem mntmNewMenuItem = new JMenuItem("Lista de clientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				JPanel panel = new JPanel();
				panel.setBounds(10, 33, 700, 462);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 694, 462);
				panel.add(scrollPane);

				Clientes = new JTable();
				Clientes.setModel(new DefaultTableModel(
						new Object[][] {
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
						},
						new String[] {
								"Clientes"
						}
				));
				Clientes.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(Clientes);

			}
		});
		mnCliente.add(mntmNewMenuItem);

		JMenuItem mntmClientesComCarro = new JMenuItem("Clientes em atendimento");
		mntmClientesComCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				JPanel panel = new JPanel();
				panel.setBounds(10, 33, 700, 462);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 694, 462);
				panel.add(scrollPane);

				ClientesAtendimento = new JTable();
				ClientesAtendimento.setModel(new DefaultTableModel(
						new Object[][] {
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
								{null},
						},
						new String[] {
								"Clientes em atendimento"
						}
				));
				ClientesAtendimento.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(ClientesAtendimento);
			}
		});
		mnCliente.add(mntmClientesComCarro);

		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnCliente.add(mntmCadastrarCliente);

		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		mnFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnFuncionrio);

		JMenuItem mntmListaDeFuncionrios = new JMenuItem("Lista de Funcion\u00E1rios");
		mnFuncionrio.add(mntmListaDeFuncionrios);

		JMenu mnInserir = new JMenu("Inserir");
		mnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnInserir.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnInserir);

		JMenuItem mntmCarro = new JMenuItem("Carro");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esconderPanel();
				// Criando painel Cadastro carro

				Panel panelCadastrarCarro = new Panel();
				panelCadastrarCarro.setBounds(0, 27, 706, 464);
				contentPane.add(panelCadastrarCarro);
				panelCadastrarCarro.setLayout(null);

				JLabel lblNewLabel = new JLabel("Cadastrar Carro");
				lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
				lblNewLabel.setBounds(222, 25, 226, 43);
				panelCadastrarCarro.add(lblNewLabel);

				txtPlaca = new JTextField();
				txtPlaca.setText("Placa");
				txtPlaca.setBounds(84, 118, 122, 28);
				panelCadastrarCarro.add(txtPlaca);
				txtPlaca.setColumns(10);

				txtPorta = new JTextField();
				txtPorta.setText("Porta");
				txtPorta.setBounds(84, 174, 122, 28);
				panelCadastrarCarro.add(txtPorta);
				txtPorta.setColumns(10);

				txtPotncia = new JTextField();
				txtPotncia.setText("Pot\u00EAncia");
				txtPotncia.setBounds(84, 229, 122, 28);
				panelCadastrarCarro.add(txtPotncia);
				txtPotncia.setColumns(10);

				txtModelo = new JTextField();
				txtModelo.setText("Modelo");
				txtModelo.setBounds(84, 282, 122, 28);
				panelCadastrarCarro.add(txtModelo);
				txtModelo.setColumns(10);

				txtMarca = new JTextField();
				txtMarca.setText("Marca");
				txtMarca.setBounds(84, 338, 122, 28);
				panelCadastrarCarro.add(txtMarca);
				txtMarca.setColumns(10);

				txtCategoria = new JTextField();
				txtCategoria.setText("Categoria");
				txtCategoria.setBounds(296, 118, 122, 28);
				panelCadastrarCarro.add(txtCategoria);
				txtCategoria.setColumns(10);

				txtAr = new JTextField();
				txtAr.setText("Ar");
				txtAr.setBounds(296, 174, 122, 28);
				panelCadastrarCarro.add(txtAr);
				txtAr.setColumns(10);

				txtGps = new JTextField();
				txtGps.setText("GPS");
				txtGps.setBounds(296, 229, 122, 28);
				panelCadastrarCarro.add(txtGps);
				txtGps.setColumns(10);

				txtTravas = new JTextField();
				txtTravas.setText("Trava El\u00E9trica");
				txtTravas.setBounds(296, 282, 122, 28);
				panelCadastrarCarro.add(txtTravas);
				txtTravas.setColumns(10);

				txtSom = new JTextField();
				txtSom.setText("Som");
				txtSom.setBounds(296, 338, 122, 28);
				panelCadastrarCarro.add(txtSom);
				txtSom.setColumns(10);

				txtFreiosAbs = new JTextField();
				txtFreiosAbs.setText("Freios ABS");
				txtFreiosAbs.setBounds(499, 118, 122, 28);
				panelCadastrarCarro.add(txtFreiosAbs);
				txtFreiosAbs.setColumns(10);

				txtAirbag = new JTextField();
				txtAirbag.setText("AIRBAG");
				txtAirbag.setBounds(499, 174, 122, 28);
				panelCadastrarCarro.add(txtAirbag);
				txtAirbag.setColumns(10);

				txtDireoHidrulica = new JTextField();
				txtDireoHidrulica.setText("Dire\u00E7\u00E3o Hidr\u00E1ulica");
				txtDireoHidrulica.setBounds(499, 229, 122, 28);
				panelCadastrarCarro.add(txtDireoHidrulica);
				txtDireoHidrulica.setColumns(10);

				trocarPanel(panelCadastrarCarro);
				mostrarPanel();
			}
		});
		mnInserir.add(mntmCarro);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				esconderPanel();
				// Criando Painel Cadastro Cliente

				Panel panelCadastroCliente = new Panel();
				panelCadastroCliente.setBounds(0, 27, 706, 464);
				contentPane.add(panelCadastroCliente);
				panelCadastroCliente.setLayout(null);

				txtNome = new JTextField();
				txtNome.setText("Nome");
				txtNome.setBounds(59, 108, 122, 28);
				panelCadastroCliente.add(txtNome);
				txtNome.setColumns(10);

				txtCpf = new JTextField();
				txtCpf.setBounds(59, 173, 122, 28);
				txtCpf.setText("CPF");
				panelCadastroCliente.add(txtCpf);
				txtCpf.setColumns(10);

				txtRg = new JTextField();
				txtRg.setBounds(59, 241, 122, 28);
				txtRg.setText("RG");
				panelCadastroCliente.add(txtRg);
				txtRg.setColumns(10);

				txtDataDeNascimento = new JTextField();
				txtDataDeNascimento.setBounds(59, 299, 133, 28);
				txtDataDeNascimento.setText("Data de Nascimento");
				panelCadastroCliente.add(txtDataDeNascimento);
				txtDataDeNascimento.setColumns(10);

				txtEmail = new JTextField();
				txtEmail.setBounds(320, 108, 295, 28);
				txtEmail.setText("Email");
				panelCadastroCliente.add(txtEmail);
				txtEmail.setColumns(10);

				txtCnh = new JTextField();
				txtCnh.setBounds(320, 173, 122, 28);
				txtCnh.setText("CNH");
				panelCadastroCliente.add(txtCnh);
				txtCnh.setColumns(10);

				txtEndereo = new JTextField();
				txtEndereo.setBounds(320, 241, 122, 28);
				txtEndereo.setText("Endere\u00E7o");
				panelCadastroCliente.add(txtEndereo);
				txtEndereo.setColumns(10);

				JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
				lblCadastroCliente.setBounds(222, 25, 226, 43);
				lblCadastroCliente.setFont(new Font("Segoe UI", Font.PLAIN, 25));
				panelCadastroCliente.add(lblCadastroCliente);



				textField = new JTextField();
				textField.setBounds(59, 108, 122, 28);
				panelCadastroCliente.add(textField);
				textField.setColumns(10);
				
				trocarPanel(panelCadastroCliente);
				mostrarPanel();

			}
		});
		mnInserir.add(mntmCliente);

		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mntmFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				esconderPanel();
				// Criando o painel Cadastrar Funcionário

				Panel panelCadastrarFuncionario = new Panel();
				panelCadastrarFuncionario.setBounds(0, 27, 706, 464);
				contentPane.add(panelCadastrarFuncionario);
				panelCadastrarFuncionario.setLayout(null);

				JLabel lblCadastrarFuncionrio = new JLabel("Cadastrar Funcion\u00E1rio");
				lblCadastrarFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 25));
				lblCadastrarFuncionrio.setBounds(222, 25, 250, 43);
				panelCadastrarFuncionario.add(lblCadastrarFuncionrio);

				txtNome_1 = new JTextField();
				txtNome_1.setText("Nome");
				txtNome_1.setBounds(91, 127, 176, 28);
				panelCadastrarFuncionario.add(txtNome_1);
				txtNome_1.setColumns(10);

				txtCpf_1 = new JTextField();
				txtCpf_1.setText("CPF");
				txtCpf_1.setBounds(91, 197, 159, 28);
				panelCadastrarFuncionario.add(txtCpf_1);
				txtCpf_1.setColumns(10);

				txtRg_1 = new JTextField();
				txtRg_1.setText("RG");
				txtRg_1.setBounds(91, 264, 122, 28);
				panelCadastrarFuncionario.add(txtRg_1);
				txtRg_1.setColumns(10);

				txtDataDeNascimento_1 = new JTextField();
				txtDataDeNascimento_1.setText("Data de Nascimento");
				txtDataDeNascimento_1.setBounds(91, 332, 137, 28);
				panelCadastrarFuncionario.add(txtDataDeNascimento_1);
				txtDataDeNascimento_1.setColumns(10);

				txtEndereo_1 = new JTextField();
				txtEndereo_1.setText("Endere\u00E7o");
				txtEndereo_1.setBounds(394, 332, 244, 28);
				panelCadastrarFuncionario.add(txtEndereo_1);
				txtEndereo_1.setColumns(10);

				txtCtps = new JTextField();
				txtCtps.setText("CTPS");
				txtCtps.setBounds(394, 127, 159, 28);
				panelCadastrarFuncionario.add(txtCtps);
				txtCtps.setColumns(10);

				txtLogin = new JTextField();
				txtLogin.setText("Login");
				txtLogin.setBounds(394, 197, 122, 28);
				panelCadastrarFuncionario.add(txtLogin);
				txtLogin.setColumns(10);

				txtSenha = new JTextField();
				txtSenha.setText("Senha");
				txtSenha.setBounds(394, 264, 122, 28);
				panelCadastrarFuncionario.add(txtSenha);
				txtSenha.setColumns(10);
				
				trocarPanel(panelCadastrarFuncionario);
				mostrarPanel();
				
			}
		});
		mnInserir.add(mntmFuncionrio);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 27, 716, 474);
		contentPane.add(panel_1);
		this.panel = panel_1;
		panel_1.setLayout(null);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}

		});
	}

	
	private void mostrarPanel(){
		this.panel.setVisible(true);
		
	}

	private void esconderPanel(){
		this.panel.setVisible(false);
	}

	private void trocarPanel(Panel panel){
		this.panel = panel;
	}

	
}
