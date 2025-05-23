package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Operaciones.AgendaDao;
import Operaciones.Contacto;

public class Lectura_Escritura_Ficheros {
	Scanner sc = new Scanner(System.in);

	public List<Contacto> contactos() {
		BufferedReader br = null;
		List<Contacto> contactos = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader("Contactos.txt"));
			String linea = br.readLine();

			if (linea != null && linea.isEmpty()) {
				return contactos;
			} else {
				while (linea != null) {
					String[] array = linea.split(";");
					Contacto c = new Contacto(array[0], array[1], array[2], array[3], Boolean.valueOf(array[4]));
					contactos.add(c);
					linea = br.readLine();

				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return contactos;
	}

	public String listar() {
		String resul = "";
		List<Contacto> c = contactos();
		Iterator<Contacto> it = c.iterator();
		while (it.hasNext()) {
			Contacto c1 = it.next();
			resul += c1 + "\n";
		}
		return resul;
	}

	public void eliminarContacto(String id) throws SQLException {
		List<Contacto> contactos = contactos();

		Iterator it = contactos.iterator();
		boolean encontrado = false;

		while (it.hasNext() && !encontrado) {
			Contacto c = (Contacto) it.next();

			if (c.getId().equals(id)) {
				encontrado = true;
				contactos.remove(c);
				System.out.println("Contacto eliminado");

			}
		}
		if (!encontrado) {
			System.out.println("El contacto no se encuentra en la lista");
		}
		actualizarContactos(contactos);
		AgendaDao ag = new AgendaDao();
		ag.ActualizarContactos();
	}

	public void nuevoContacto(Contacto contacto) throws SQLException {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Contactos.txt", true));
			bw.write(contacto.getId() + ";" + contacto.getNombre() + ";" + contacto.getApellido() + ";"
					+ contacto.getNum() + ";" + contacto.isBloqueado());
			bw.newLine();
			System.out.println("Contacto añadido");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		AgendaDao ag = new AgendaDao();
		ag.ActualizarContactos();

	}

	public void actualizarContactos(List<Contacto> contactos) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("Contactos.txt"));
			for (int i = 0; i < contactos.size(); i++) {
				bw.write(contactos.get(i).getId() + ";" + contactos.get(i).getNombre() + ";"
						+ contactos.get(i).getApellido() + ";" + contactos.get(i).getNum() + ";"
						+ contactos.get(i).isBloqueado());
				bw.newLine();
			}

			System.out.println("Lista actualizada");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void bloquearContacto(String id) throws SQLException {

		List<Contacto> contactos = contactos();

		Iterator<Contacto> it = contactos.iterator();
		while (it.hasNext()) {
			Contacto c = it.next();
			if (c.getId().equals(id)) {
				c.setBloqueado(true);
			}
		}
		actualizarContactos(contactos);
		AgendaDao ag = new AgendaDao();
		ag.ActualizarContactos();
	}

	public void eliminarBloqueo(String id) throws SQLException {
		List<Contacto> contactos = contactos();

		Iterator<Contacto> it = contactos.iterator();
		while (it.hasNext()) {
			Contacto c = it.next();
			if (c.getId().equals(id) ) {
				c.setBloqueado(false);
			}
		}
		actualizarContactos(contactos);
		AgendaDao ag = new AgendaDao();
		ag.ActualizarContactos();
	}

	

	public Contacto buscarContacto(String id) {
		List<Contacto> lista = contactos();
		Contacto a = new Contacto();
		Iterator it = lista.iterator();
		boolean encontrado = false;

		while (it.hasNext() && !encontrado) {
			Contacto c = (Contacto) it.next();

			if (c.getId().equals(id)) {

				encontrado = true;
				a = c;

			}
			
		}
		return a;
	}
}