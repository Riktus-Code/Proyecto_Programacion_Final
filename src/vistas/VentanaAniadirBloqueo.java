/*
 * Created by JFormDesigner on Fri May 09 11:13:53 CEST 2025
 */

package vistas;

import java.awt.Color;
import Operaciones.AgendaDao;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import Controlador.Lectura_Escritura_Ficheros;
import net.miginfocom.swing.*;

/**
 * @author elman
 */
public class VentanaAniadirBloqueo extends JFrame {
	public VentanaAniadirBloqueo() {
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
	    setBounds(100, 100, 270, 300); 
	    setLocationRelativeTo(getOwner());
	}

	private void bloqueaMouseClicked(MouseEvent e) throws SQLException {
		String bloquea = bloqueaTxt.getText();
		Lectura_Escritura_Ficheros f1 = new Lectura_Escritura_Ficheros();
		f1.bloquearContacto(bloquea);
		if(bloquea.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes introducir parametros","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}else{
			this.dispose();
			JOptionPane.showMessageDialog(null, "Contacto bloqueado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		label1 = new JLabel();
		bloqueaTxt = new JTextField();
		bloquea = new JButton();

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
		label1.setText("Introduce el id a bloquear");
		contentPane.add(label1, "cell 7 1");
		contentPane.add(bloqueaTxt, "cell 7 2");

		//---- bloquea ----
		bloquea.setText("Aceptar");
		bloquea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					bloqueaMouseClicked(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(bloquea, "cell 7 8");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JLabel label1;
	private JTextField bloqueaTxt;
	private JButton bloquea;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
