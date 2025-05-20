/*
 * Created by JFormDesigner on Fri May 09 11:13:31 CEST 2025
 */

package vistas;

import java.awt.Color;
import Operaciones.AgendaDao;
import java.awt.event.*;
import Operaciones.Contacto;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import Controlador.Lectura_Escritura_Ficheros;
import net.miginfocom.swing.*;

/**
 * @author elman
 */
public class VentanaBuscar extends JFrame {
	public VentanaBuscar() {
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

	private void busca(MouseEvent e) {
		String buscar = buscarTxt.getText();
		Lectura_Escritura_Ficheros f1 = new Lectura_Escritura_Ficheros();
		Contacto c1 = f1.buscarContacto(buscar);
		if(buscar.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes introducir parametros","ERROR",JOptionPane.INFORMATION_MESSAGE);
		}else if (buscar.equals(c1.getId())) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "ID: "+c1.getId()+" Nombre: "
			+c1.getNombre()+" Apellido: "+c1.getApellido()+" Numero: "+c1.getNum(), "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		}else {
			this.dispose();
			JOptionPane.showMessageDialog(null, "Contacto inexistente", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		label1 = new JLabel();
		buscarTxt = new JTextField();
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
		label1.setText("Introduce el Id del contacto");
		contentPane.add(label1, "cell 7 1");
		contentPane.add(buscarTxt, "cell 7 2");

		//---- button1 ----
		button1.setText("Aceptar");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				busca(e);
			}
		});
		contentPane.add(button1, "cell 7 8");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JLabel label1;
	private JTextField buscarTxt;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
