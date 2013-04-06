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

public class SegundoUI extends JFrame {

	private JPanel contentPane;

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
				
			}
		});
		mnListas.add(mntmCarrosDaloja);
		
		JMenuItem mntmCarrosAlugados = new JMenuItem("Carros Alugados");
		mntmCarrosAlugados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Mostrar os carros que tem o disponibilidade false
				
			}
		});
		mnListas.add(mntmCarrosAlugados);
		
		JMenuItem mntmCarrosDisponveis = new JMenuItem("Carros dispon\u00EDveis");
		mntmCarrosDisponveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				// Imprimir carros com disponibilidade true
			}
		});
		mnListas.add(mntmCarrosDisponveis);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnCliente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lista de clientes");
		mnCliente.add(mntmNewMenuItem);
		
		JMenuItem mntmClientesComCarro = new JMenuItem("Clientes com carro");
		mnCliente.add(mntmClientesComCarro);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnCliente.add(mntmCadastrarCliente);
		
		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		mnFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnFuncionrio);
		
		JMenuItem mntmListaDeFuncionrios = new JMenuItem("Lista de Funcion\u00E1rios");
		mnFuncionrio.add(mntmListaDeFuncionrios);
		
		JMenuItem mntmInserirFuncionrio = new JMenuItem("Inserir Funcion\u00E1rio");
		mnFuncionrio.add(mntmInserirFuncionrio);
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
