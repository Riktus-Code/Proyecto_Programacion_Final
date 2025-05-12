/*
 * Created by JFormDesigner on Fri May 09 10:30:43 CEST 2025
 */

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import net.miginfocom.swing.*;
import Operaciones.AgendaDao;

/**
 * @author elman
 */
public class PanelPrincipal extends JFrame {
	AgendaDao f1 = new AgendaDao();
	public PanelPrincipal() {
		try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		UIManager.put("Button.arc", 20); // Botones redondeados
        UIManager.put("Button.background", Color.WHITE); // Fondo de los botones blanco
        UIManager.put("Button.foreground", Color.BLACK); // Texto de los botones negro
        UIManager.put("Component.arc", 15); // Bordes redondeados en otros componentes
        UIManager.put("Panel.background", new Color(45, 45, 45));
		initComponents();
		Titulo1.setForeground(Color.BLACK);
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setPreferredSize(new Dimension(600, 600)); // Tamaño deseado
		panel1.setMinimumSize(new Dimension(600, 600));   // Evita que se reduzca
		panel1.setMaximumSize(new Dimension(600, 600)); 
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setBounds(500, 200, 500, 500);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     


	private void aniadir(MouseEvent e) {
		VentanaAniadir a1 = new VentanaAniadir();
		a1.setVisible(true);
		
		
	}

	private void buscar(MouseEvent e) {
		VentanaBuscar a2 = new VentanaBuscar();
		a2.setVisible(true);
	}

	private void eliminar(MouseEvent e) {
		VentanaEliminar a3  = new VentanaEliminar();
		a3.setVisible(true);
	}

	private void aBloqueo(MouseEvent e) {
		VentanaAniadirBloqueo a4 = new VentanaAniadirBloqueo();
		a4.setVisible(true);
	}

	private void eBloqueo(MouseEvent e) {
		VentanaEliminarBloqueo a5 = new VentanaEliminarBloqueo();
		a5.setVisible(true);
	}
	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		label2 = new JLabel();
		Titulo1 = new JLabel();
		panel1 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();

		//======== this ========
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));
		contentPane.add(label2, "cell 7 0 2 1");

		//---- Titulo1 ----
		Titulo1.setText("           Bienvenido a tu Agenda");
		contentPane.add(Titulo1, "cell 7 1 3 1");

		//======== panel1 ========
		{
			panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
			. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax
			. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,
			12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
			. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .
			getPropertyName () )) throw new RuntimeException( ); }} );
			panel1.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[fill]" +
				"[fill]",
				// rows
				"[]" +
				"[]" +
				"[]"));
		}
		contentPane.add(panel1, "cell 19 16 2 2");
		panel1= new JPanel() {
            private Image backgroundImage = new ImageIcon("C:\\Users\\elman\\OneDrive\\Escritorio\\logo-removebg-preview.jpg").getImage(); // Cambia la ruta
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };


		//---- button1 ----
		button1.setText("A\u00f1adir");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aniadir(e);
			}
		});
		contentPane.add(button1, "cell 4 9");

		//---- button2 ----
		button2.setText("Buscar");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar(e);
			}
		});
		contentPane.add(button2, "cell 4 10");

		//---- button3 ----
		button3.setText("Eliminar");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar(e);
			}
		});
		contentPane.add(button3, "cell 4 11");

		//---- button4 ----
		button4.setText("A\u00f1adir Bloqueado");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aBloqueo(e);
			}
		});
		contentPane.add(button4, "cell 4 12");

		//---- button5 ----
		button5.setText("Eliminar Bloqueado");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eBloqueo(e);
			}
		});
		contentPane.add(button5, "cell 4 13");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JLabel label2;
	private JLabel Titulo1;
	private JPanel panel1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
