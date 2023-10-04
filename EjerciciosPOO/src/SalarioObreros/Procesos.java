package SalarioObreros;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	HashMap<String, ArrayList<String>> listaObreros = new HashMap<String, ArrayList<String>>();
	Obrero miO;
	String porcentajeAumento, mensaje;
	double aumento;
	int cantObreros=0, tipoA=0, tipoB=0, tipoC=0;
	
	public Procesos() {
		menu();
	}
	
	public void menu() {
		int cod = 0;
		String menu = "¿Que desea realizar?\n";
		menu += "1.	Procesar obreros\n";
		menu += "2.	Consultar obrero por cedula\n";
		menu += "3.	Consulta lista de obreros procesados\n";
		menu += "4.	Consultar cantidad de obreros procesados\n";
		menu += "5. Salir\n";
		
		do {
			cod = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (cod) {
			case 1:
				miO = new Obrero();
				procesarObrero();
				cantObreros++;
				break;
			case 2:
				consultaCedula();
				break;
			case 3:
				listadoObreros();
				break;
			case 4:
				cantidadObreros();
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Gracias por usarnos", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
		} while (cod !=5);
	
	}
	

	public void procesarObrero() {
		ArrayList<String> obreros = new ArrayList<String>();
		miO.nombre= JOptionPane.showInputDialog("Digite el nombre del Obrero");
		miO.cedula= JOptionPane.showInputDialog("Digite la cedula de "+miO.nombre);
		
		miO.tipo = JOptionPane.showInputDialog("Digite el tipo de categoria de "+miO.nombre);
		procesarObrerosTipo(miO.tipo);
		
		miO.salarioActual = Double.parseDouble(JOptionPane.showInputDialog("Digite el salario de "+miO.nombre));
		miO.salarioNuevo = calcularSalarioNuevo(miO.salarioActual);
		
		agregarDatos(obreros);
		
	}
	
	public void procesarObrerosTipo(String tipo) {
		switch (tipo.toUpperCase()) {
		case "A":
			tipoA++;
			aumento= 0.30;
			porcentajeAumento= "30%";
			break;
		case "B":
			tipoB++;
			aumento= 0.20;
			porcentajeAumento= "20%";
			break;
		case "C":
			tipoC++;
			aumento= 0.10;
			porcentajeAumento= "10%";
			break;
		default:
			break;
		}
	}
	
	public double calcularSalarioNuevo(double salario) {
		salario = salario+(salario*aumento);
		return salario;
	}
	
	public void agregarDatos(ArrayList<String> obreros) {
		obreros.add(miO.cedula);
		obreros.add(miO.nombre);
		obreros.add(miO.tipo.toUpperCase());
		obreros.add(porcentajeAumento);
		obreros.add(Double.toString(miO.salarioActual));
		obreros.add(Double.toString(miO.salarioNuevo));
		
		listaObreros.put(obreros.get(0),obreros);	
	}
	
	public void consultaCedula() {
		String cedula = JOptionPane.showInputDialog("Digite la cedula del obrero");
		
		if (listaObreros.containsKey(cedula)) {
			ArrayList<String> datosObrero = listaObreros.get(cedula);
			mensaje = "<<DATOS OBRERO>>\n";
		    mensaje += "--------------------------------------\n";
		    mensaje += "Cedula: "+datosObrero.get(0)+"\n";
		    mensaje += "Nombre: "+datosObrero.get(1)+"\n";
		    mensaje += "Tipo: "+datosObrero.get(2)+"\n";
		    mensaje += "Aumento: "+datosObrero.get(3)+"\n";
		    mensaje += "Salario Actual: "+datosObrero.get(4)+"\n";
		    mensaje += "Salario Nuevo: "+datosObrero.get(5)+"\n";
		    mensaje += "--------------------------------------\n";
	      
	      	JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Documento no existe", "Advertencia",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void listadoObreros() {
		
		for (String cedula : listaObreros.keySet()) {
	        ArrayList<String> datosObrero = listaObreros.get(cedula);
	        mensaje = "<<LISTADO DE OBREROS>>\n";
	        mensaje += "--------------------------------------\n";
	        mensaje += "Cedula: " + datosObrero.get(0) + "\n";
	        mensaje += "Nombre: " + datosObrero.get(1) + "\n";
	        mensaje += "Tipo: " + datosObrero.get(2) + "\n";
	        mensaje += "Aumento: " + datosObrero.get(3) + "\n";
	        mensaje += "Salario Actual: " + datosObrero.get(4) + "\n";
	        mensaje += "Salario Nuevo: " + datosObrero.get(5) + "\n";
	        mensaje += "--------------------------------------\n";
	        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	    }
		
	}

	public void cantidadObreros() {
	      mensaje = "<<INFORMACION OBREROS>>\n";
	      mensaje += "--------------------------------------\n";
	      mensaje += "Total obreros procesados: "+cantObreros+"\n";
	      mensaje += "Cantidad Obreros Tipo A:  "+tipoA+"\n";
	      mensaje += "Cantidad Obreros Tipo B:  "+tipoB+"\n";
	      mensaje += "Cantidad Obreros Tipo C: : "+tipoC+"\n";
	      mensaje += "--------------------------------------\n";
	      JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
}
