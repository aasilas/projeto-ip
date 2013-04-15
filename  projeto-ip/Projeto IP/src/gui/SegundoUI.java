package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.util.Vector;

public class SegundoUI extends JFrame {

	private JPanel contentPane;
	private JTable Carros;
	private JTable CarroDisponivel;
	private JTable CarroIndisponivel;
	private JTable Clientes;
	private JTable ClientesAtendimento;
	private JTable ListaFuncionarios;
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
	private JTable table;
	private DefaultTableModel modeloTabelaCarro;
	private DefaultTableModel modeloTabelaCliente;
	private DefaultTableModel modeloTabelaFuncionario;
	private JTable table_1;
	private JTable table_2;
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
		setBounds(100, 100, 925, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 908, 21);
		contentPane.add(menuBar);

		JMenu mnListas = new JMenu("Carros");
		mnListas.setBackground(new Color(0, 153, 255));
		mnListas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnListas);


		JMenuItem mntmCarrosDaloja = new JMenuItem("Carros da loja");
		mntmCarrosDaloja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				// mandar um get repositorio,pra ele imprimir as informações dos carros
				tabelaCarro();



				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				

			}
		});
		mnListas.add(mntmCarrosDaloja);

		JMenuItem mntmCarrosAlugados = new JMenuItem("Carros Indisponiveis");
		mntmCarrosAlugados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				esconderPanel();
				// Verificar se já existe uma lista aberta e caso sim,fechar e abrir a desejada.
				// Mostrar os carros que tem o disponibilidade false
				Panel panel = new Panel();
				panel.setBounds(10, 33, 925, 539);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 27, 899, 355);
				panel.add(scrollPane);

				CarroIndisponivel = new JTable();
				CarroIndisponivel.setModel(new DefaultTableModel(
						new Object[][] {
								
						},
						new String[] {
								"Carros Indisponiveis"
						}
						));
				CarroIndisponivel.getColumnModel().getColumn(0).setPreferredWidth(620);
				scrollPane.setViewportView(CarroIndisponivel);

				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				trocarPanel(panel);
				mostrarPanel();

			}
		});
		mnListas.add(mntmCarrosAlugados);

		JMenuItem mntmCarrosDisponveis = new JMenuItem("Carros dispon\u00EDveis");
		mntmCarrosDisponveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				esconderPanel();
				// Imprimir carros com disponibilidade true
				Panel panel = new Panel();
				panel.setBounds(10, 33, 925, 539);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 27, 899, 355);
				panel.add(scrollPane);

				CarroDisponivel = new JTable();
				CarroDisponivel.setModel(new DefaultTableModel(
						new Object[][] {
								
						},
						new String[] {
								"Carros Disponiveis"
						}
						));
				CarroDisponivel.getColumnModel().getColumn(0).setPreferredWidth(620);
				

				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				trocarPanel(panel);
				mostrarPanel();
			}
		});
		mnListas.add(mntmCarrosDisponveis);

		JMenuItem mntmInserirCarro = new JMenuItem("Inserir Carro");
		mntmInserirCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirCarroUI inserirCarro = new InserirCarroUI();
				inserirCarro.setVisible(true);
			}
		});
		mnListas.add(mntmInserirCarro);

		JMenu mnCliente = new JMenu("  Cliente");
		mnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnCliente);

		JMenuItem mntmNewMenuItem = new JMenuItem("Lista de clientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				esconderPanel();

				Panel panel = new Panel();
				panel.setBounds(10, 33, 925, 539);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 27, 899, 355);
				panel.add(scrollPane);

				Clientes = new JTable();
				Clientes.setModel(new DefaultTableModel(
						new Object[][] {
								
						},
						new String[] {
								"Clientes"
						}
						));
				Clientes.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(Clientes);

				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				trocarPanel(panel);
				mostrarPanel();
			}
		});
		mnCliente.add(mntmNewMenuItem);

		JMenuItem mntmClientesComCarro = new JMenuItem("Clientes em atendimento");
		mntmClientesComCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				esconderPanel();

				Panel panel = new Panel();
				panel.setBounds(10, 33, 925, 539);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 27, 899, 355);
				panel.add(scrollPane);

				ClientesAtendimento = new JTable();
				ClientesAtendimento.setModel(new DefaultTableModel(
						new Object[][] {
								
						},
						new String[] {
								"Clientes em atendimento"
						}

						));
				ClientesAtendimento.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(ClientesAtendimento);

				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				trocarPanel(panel);
				mostrarPanel();

			}
		});
		mnCliente.add(mntmClientesComCarro);

		JMenuItem mntmInserirCliente = new JMenuItem("Inserir Cliente");
		mntmInserirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirClienteUI inserirCliente = new InserirClienteUI();
				inserirCliente.setVisible(true);
			}
		});
		mnCliente.add(mntmInserirCliente);

		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		mnFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnFuncionrio);

		JMenuItem mntmListaDeFuncionrios = new JMenuItem("Lista de Funcion\u00E1rios");
		mntmListaDeFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				esconderPanel();

				Panel panel = new Panel();
				panel.setBounds(10, 33, 925, 539);
				contentPane.add(panel);
				panel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 27, 899, 355);
				panel.add(scrollPane);

				ListaFuncionarios = new JTable();
				ListaFuncionarios.setModel(new DefaultTableModel(

						new Object[][] {

						},
						new String[] {
								"Funcionários"
						}
						));
				ListaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(619);
				scrollPane.setViewportView(ListaFuncionarios);


				JButton btnAtualizar = new JButton("Atualizar");
				btnAtualizar.setBounds(657, 410, 89, 23);
				panel.add(btnAtualizar);

				JButton btnRemover = new JButton("Remover");
				btnRemover.setBounds(775, 410, 89, 23);
				panel.add(btnRemover);

				trocarPanel(panel);
				mostrarPanel();

			}
		});
		mnFuncionrio.add(mntmListaDeFuncionrios);

		JMenuItem mntmInserirFuncionrio = new JMenuItem("Inserir Funcion\u00E1rio");
		mntmInserirFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirFuncionarioUI inserirFuncionario = new InserirFuncionarioUI();
				inserirFuncionario.setVisible(true);
			}
		});
		mnFuncionrio.add(mntmInserirFuncionrio);

		JMenu mnInserir = new JMenu("Relat\u00F3rio");
		mnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnInserir.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnInserir);

		JMenu mnMovimentaes = new JMenu("Movimenta\u00E7\u00F5es");
		mnMovimentaes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnMovimentaes);

		JMenuItem mntmAlugarCarro = new JMenuItem("Alugar Carro");
		mntmAlugarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PesquisaAlugarCarroUI pesquisarCliente = new PesquisaAlugarCarroUI();
				pesquisarCliente.setVisible(true);
			}
		});
		mnMovimentaes.add(mntmAlugarCarro);

		JMenuItem mntmEntregarCarro = new JMenuItem("Entregar Carro");
		mntmEntregarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PesquisaEntregarCarro entregarCarro = new PesquisaEntregarCarro();
				entregarCarro.setVisible(true);
			}
		});
		mnMovimentaes.add(mntmEntregarCarro);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		mnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmCarro = new JMenuItem("Carro");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarCarroUI atualizarCarro = new AtualizarCarroUI();
				atualizarCarro.setVisible(true);
			}
		});
		mntmCarro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAtualizar.add(mntmCarro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAtualizar.add(mntmCliente);
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mnAtualizar.add(mntmFuncionrio);



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
		panel.setVisible(true);
	}

	private void esconderPanel(){
		this.panel.setVisible(false);
	}

	private void trocarPanel(Panel panel){
		this.panel = panel;
	}

	private void atualizar(){

	}

	private void tabelaCarro(){
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 27, 908, 378);
		contentPane.add(panel_1);
		this.panel = panel_1;
		panel_1.setLayout(null);

		final ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(0, 0, 908, 378);
		panel_1.add(scrollPane_1);

		table = new JTable();
		table.setBounds(0, 376, 908, 375);

		modeloTabelaCarro = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Placa", "Valor", "Categoria", "Marca", "Modelo", "Travas", "GPS", "AIRBAG", "Dir.Hidraulica", "FreiosABS", "Som"
				}
				);
		table.setModel(modeloTabelaCarro);
		table.getColumnModel().getColumn(1).setPreferredWidth(52);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(5).setPreferredWidth(47);
		table.getColumnModel().getColumn(6).setPreferredWidth(38);
		table.getColumnModel().getColumn(7).setPreferredWidth(54);
		table.getColumnModel().getColumn(10).setPreferredWidth(47);
		table.setFont(new Font("Segoe UI", Font.BOLD, 11));
		panel_1.add(table);
		
		panel_1.setVisible(true);
		
	}

	private void tabelaClientes(){
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 27, 908, 378);
		contentPane.add(panel_1);
		this.panel = panel_1;
		panel_1.setLayout(null);

		final ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(0, 0, 908, 378);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		modeloTabelaCliente = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Cpf", "CNH", "RG", "Email", "Data de Nasc.", "Endere\u00E7o"
				}
				);
		table_1.setModel(modeloTabelaCliente);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(111);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(82);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(177);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(85);
		table_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panel.add(table_1);

	}
	
	private void tabelaFuncionario(){
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 27, 908, 378);
		contentPane.add(panel_1);
		this.panel = panel_1;
		panel_1.setLayout(null);

		final ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(0, 0, 908, 378);
		panel_1.add(scrollPane_1);
		

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Login", "Cpf", "CTPS", "Rg", "Data de Nascimento", "Endere\u00E7o"
				}
				));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(103);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(99);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(106);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(106);
		table_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		table_2.setBounds(0, 376, 908, -375);
		panel_1.add(table_2);

	}
}
