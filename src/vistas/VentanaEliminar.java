/*
 * Created by JFormDesigner on Fri May 09 11:13:02 CEST 2025
 */

package vistas;

import java.awt.Color;

import Controlador.Lectura_Escritura_Ficheros;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import net.miginfocom.swing.*;

/**
 * @author elman
 */
public class VentanaEliminar extends JFrame {
	public VentanaEliminar() {
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
	    setBounds(100, 100, 230, 300); 
	    setLocationRelativeTo(getOwner());
	}

	private void elimina(MouseEvent e) throws SQLException {
		String eliminar = eliminaTxt.getText();
		Lectura_Escritura_Ficheros f1 = new Lectura_Escritura_Ficheros();
		f1.eliminarContacto(eliminar);
		if(eliminar.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes introducir parametros","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}else {
			//cierra la ventana y actualiza
			this.dispose();
			JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		label1 = new JLabel();
		eliminaTxt = new JTextField();
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
			"[]"));

		//---- label1 ----
		label1.setText("Introduce id del contacto");
		contentPane.add(label1, "cell 5 1");
		contentPane.add(eliminaTxt, "cell 5 2");

		//---- button1 ----
		button1.setText("Aceptar");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					elimina(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(button1, "cell 5 8");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JLabel label1;
	private JTextField eliminaTxt;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
