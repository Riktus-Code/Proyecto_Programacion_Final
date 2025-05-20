/*
 * Created by JFormDesigner on Fri May 09 11:12:43 CEST 2025
 */

package vistas;

import java.awt.Color;
import Controlador.Lectura_Escritura_Ficheros;
import Operaciones.Contacto;
import Operaciones.AgendaDao;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import net.miginfocom.swing.*;

/**
 * @author elman
 */
public class VentanaAniadir extends JFrame {
	public VentanaAniadir() {
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
		pack(); // Ajusta los componentes
	    setBounds(100, 100, 200, 300); 
	    setLocationRelativeTo(getOwner());
	}

	private void aceptar(MouseEvent e) throws SQLException {
		String id = idTxt.getText();
		String nombre = nombreTxt.getText();
		String apellido = apellidoTxt.getText();
		String tlf = tlfTxt.getText();
		Contacto c1 = new Contacto(id,nombre,apellido,tlf,false);
		Lectura_Escritura_Ficheros f1 = new Lectura_Escritura_Ficheros();
		f1.nuevoContacto(c1);
		if(id.equals("") &&  nombre.equals("") && apellido.equals("") && tlf.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes introducir parametros","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}else {
			//cierra la ventana y actualiza
			this.dispose();
			JOptionPane.showMessageDialog(null, "Contacto añadido correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		}
		

        
        
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		label1 = new JLabel();
		idTxt = new JTextField();
		label2 = new JLabel();
		nombreTxt = new JTextField();
		label3 = new JLabel();
		apellidoTxt = new JTextField();
		label4 = new JLabel();
		tlfTxt = new JTextField();
		button1 = new JButton();

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
			"[]"));

		//---- label1 ----
		label1.setText("ID");
		contentPane.add(label1, "cell 9 1,alignx center,growx 0");
		contentPane.add(idTxt, "cell 9 2");

		//---- label2 ----
		label2.setText("  Nombre");
		contentPane.add(label2, "cell 9 3,growx");
		contentPane.add(nombreTxt, "cell 9 4");

		//---- label3 ----
		label3.setText("  Apellidos");
		contentPane.add(label3, "cell 9 5");
		contentPane.add(apellidoTxt, "cell 9 6");

		//---- label4 ----
		label4.setText("  Tel\u00e9fono");
		contentPane.add(label4, "cell 9 7");
		contentPane.add(tlfTxt, "cell 9 8");

		//---- button1 ----
		button1.setText("Aceptar");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aceptar(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(button1, "cell 9 9");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JLabel label1;
	private JTextField idTxt;
	private JLabel label2;
	private JTextField nombreTxt;
	private JLabel label3;
	private JTextField apellidoTxt;
	private JLabel label4;
	private JTextField tlfTxt;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
