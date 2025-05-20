package Operaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controlador.Lectura_Escritura_Ficheros;

public class AgendaDao {
	Lectura_Escritura_Ficheros lef = new Lectura_Escritura_Ficheros();

	private Connection con() {
		Connection con = null;

		String url = "jdbc:mysql://localhost/agenda";
		try {
			con = DriverManager.getConnection(url, "prueba", "1234");
		} catch (SQLException ex) {
			System.out.println("Error al conectar al SGBD.");
		}

		return con;
	}

	public void ActualizarContactos() throws SQLException {
		List<Contacto> lista = lef.contactos();

		Connection con = con();
		Statement sentencia = null;
		String sql;
		
		sql = "truncate table Contactos";
		try {
			sentencia=con.createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator it = lista.iterator();
		boolean encontrado = false;

		while (it.hasNext()) {
			Contacto c = (Contacto) it.next();

			if (c.isBloqueado() == false) {
				String sql2 = "Insert into Contactos (id,nombre,apellido,numero,bloqueado) Values" + "(?,?,?,?,?)";
				try(PreparedStatement ps = con.prepareStatement(sql2)) {
					
					 ps.setString(1, c.getId());
					    ps.setString(2, c.getNombre());
					    ps.setString(3, c.getApellido());
					    ps.setString(4, c.getNum());
					    ps.setString(5, String.valueOf(c.isBloqueado()));
					    ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				String sql3 = "Insert into Bloqueados (id_Contacto) Values" + "(?)";
				try(PreparedStatement ps = con.prepareStatement(sql3)) {
					 ps.setString(1, c.getId());
					    ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		sentencia.close();

	}
}
	