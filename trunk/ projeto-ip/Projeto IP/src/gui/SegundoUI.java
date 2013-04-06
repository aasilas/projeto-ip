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
		
		JMenu mnCliente = new JMenu("Cliente");
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
		mnInserir.add(mntmCarro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnInserir.add(mntmCliente);
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mnInserir.add(mntmFuncionrio);
		
		
		
		
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
}
