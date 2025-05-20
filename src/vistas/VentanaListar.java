/*
 * Created by JFormDesigner on Tue May 13 08:33:20 CEST 2025
 */

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import Controlador.Lectura_Escritura_Ficheros;
import net.miginfocom.swing.*;
import Operaciones.AgendaDao;
import Operaciones.Contacto;

/**
 * @author elman
 */
public class VentanaListar extends JFrame {
	public VentanaListar() {
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
	    setBounds(100, 100, 450, 400); 
	    setLocationRelativeTo(getOwner());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - manuel
		scrollPane1 = new JScrollPane();
		Lista = new JTextArea();
		Lista.setEnabled(false);
		Lectura_Escritura_Ficheros a = new Lectura_Escritura_Ficheros();
		if(a.listar().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista Vacía","ERROR",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			return;
		}else {
			Lista.setText(a.listar());
		}
		

		//======== this ========
		var contentPane = getContentPane();
		
        contentPane.setLayout(new BorderLayout());

		//======== scrollPane1 ========
        scrollPane1.setViewportView(Lista);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - manuel
	private JScrollPane scrollPane1;
	private JTextArea Lista;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
