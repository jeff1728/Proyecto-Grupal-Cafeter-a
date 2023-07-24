package cafeteria;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import arbol.binario.*;
import javax.swing.JScrollPane;
public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtcafe1;
	private JTextField txtprecio1;
	JTextArea textArea1 = new JTextArea();
	ArbolBinarioBusqueda arbol=new ArbolBinarioBusqueda();
	CafeTipo c1=new CafeTipo();
	CafeTipo c2=new CafeTipo();
	CafeTipo c3=new CafeTipo();
	
	Stack pila=new Stack();
	int valor = 0,valor1 = 0,valor2 = 0,valor3,valor4,valor5;
	private JTextField txtcafe2;
	private JTextField txtprecio2;
	private JTextField txtcafe3;
	private JTextField txtprecio3;
	private JTextField txtBuscarEliminar;
	/**
	 * Launch the application.
	 */
	public boolean validar(String cadena) {
		if (cadena.matches("[0-9]*")) {
			JOptionPane.showMessageDialog(null, " precio valido");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un precio valido");
			return false;
		}
	}
	public int convertir(String numero) {
		// Se reemplazan todos los caracteres que no correspondan a un numero
		// por espacio
		numero = numero.replaceAll("[^0-9]", "");

		// Si la cadena queda vacia
		if (numero.equals("")) {
			numero = "0";
		}

		return Integer.parseInt(numero);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(207, 77, 89, 0);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Cafeteria");
		lblNewLabel.setFont(new Font("Lugrasimo", Font.BOLD, 26));
		lblNewLabel.setBounds(220, 11, 146, 31);
		contentPane.add(lblNewLabel);
		
		txtcafe1 = new JTextField();
		txtcafe1.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtcafe1.setBackground(new Color(224, 255, 255));
		txtcafe1.setBounds(207, 43, 79, 23);
		contentPane.add(txtcafe1);
		txtcafe1.setColumns(10);
		
		JButton btningresar = new JButton("Ingresar");
		contentPane.add(btningresar);
		btningresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cadenaUno="1234";
				String cadenaDos="No es numerico";
				try {validar(txtprecio1.getText());
					validar(txtprecio2.getText());
					validar(txtprecio3.getText());
					
				c1.setTipoCafe(txtcafe1.getText());
				c1.setPrecio(Integer.valueOf(txtprecio1.getText()));
				
				c2.setTipoCafe(txtcafe2.getText());
				c2.setPrecio(Integer.valueOf(txtprecio2.getText()));
				
				c3.setTipoCafe(txtcafe3.getText());
				c3.setPrecio(Integer.valueOf(txtprecio3.getText()));arbol.insertar(c1);
					arbol.insertar(c2);
					arbol.insertar(c3);
				textArea1.setText("Pedido Añadido");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
				
			}
		});
		
		btningresar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		btningresar.setBounds(81, 258, 109, 23);
		contentPane.add(btningresar);
		
		JButton btnbuscar = new JButton("Buscar");
		contentPane.add(btningresar);
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arbol.buscar(txtBuscarEliminar.getText());
				
			}
		});
		btnbuscar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		btnbuscar.setBounds(446, 186, 109, 23);
		contentPane.add(btnbuscar);
		
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		btneliminar.setBounds(317, 186, 120, 23);
		contentPane.add(btneliminar);
		
		JButton btnmostrar = new JButton("Mostrar");
		btnmostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textArea1.setText("Cafe 1: "+c1.getTipoCafe()+"\n Precio: "+c1.getPrecio()+"$\n Cafe 2:: "+c2.getTipoCafe()+"\n Precio: "+c2.getPrecio()+"$\n Cafe: "+c3.getTipoCafe()+"\n Precio: "+c3.getPrecio()+"$");
			}
		});
		btnmostrar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		btnmostrar.setBounds(236, 258, 120, 23);
		contentPane.add(btnmostrar);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre del tipo de café 1:");
		lblNewLabel_2.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 46, 187, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio :");
		lblNewLabel_3.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(134, 75, 63, 26);
		contentPane.add(lblNewLabel_3);
		
		txtprecio1 = new JTextField();
		txtprecio1.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtprecio1.setBackground(new Color(224, 255, 255));
		txtprecio1.setBounds(206, 77, 80, 20);
		contentPane.add(txtprecio1);
		txtprecio1.setColumns(10);
		
		JButton btnordenar = new JButton("Ordenar");
		btnordenar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		btnordenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				arbol.preorden(arbol.raizArbol());
				arbol.inorden(arbol.raizArbol());
				arbol.postorden(arbol.raizArbol());
				
			}
		});
		btnordenar.setBounds(402, 258, 105, 24);
		contentPane.add(btnordenar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del tipo de café 2:");
		lblNewLabel_1.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(320, 48, 181, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Precio :");
		lblNewLabel_4.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(426, 77, 75, 14);
		contentPane.add(lblNewLabel_4);
		
		txtcafe2 = new JTextField();
		txtcafe2.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtcafe2.setBackground(new Color(224, 255, 255));
		txtcafe2.setBounds(511, 45, 86, 20);
		contentPane.add(txtcafe2);
		txtcafe2.setColumns(10);
		
		txtprecio2 = new JTextField();
		txtprecio2.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtprecio2.setBackground(new Color(224, 255, 255));
		txtprecio2.setBounds(511, 79, 86, 20);
		contentPane.add(txtprecio2);
		txtprecio2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre del tipo de café 3:");
		lblNewLabel_5.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 131, 187, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Precio :");
		lblNewLabel_6.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(126, 156, 71, 14);
		contentPane.add(lblNewLabel_6);
		
		txtcafe3 = new JTextField();
		txtcafe3.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtcafe3.setBackground(new Color(224, 255, 255));
		txtcafe3.setBounds(210, 129, 86, 20);
		contentPane.add(txtcafe3);
		txtcafe3.setColumns(10);
		
		txtprecio3 = new JTextField();
		txtprecio3.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtprecio3.setBackground(new Color(224, 255, 255));
		txtprecio3.setBounds(210, 163, 86, 20);
		contentPane.add(txtprecio3);
		txtprecio3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("ingrese el cafe que desea buscar o eliminar");
		lblNewLabel_7.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(307, 131, 290, 14);
		contentPane.add(lblNewLabel_7);
		
		txtBuscarEliminar = new JTextField();
		txtBuscarEliminar.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		txtBuscarEliminar.setBackground(new Color(224, 255, 255));
		txtBuscarEliminar.setBounds(317, 155, 86, 20);
		contentPane.add(txtBuscarEliminar);
		txtBuscarEliminar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 291, 447, 105);
		contentPane.add(scrollPane);
		textArea1.setFont(new Font("Lugrasimo", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea1);
	}
}
