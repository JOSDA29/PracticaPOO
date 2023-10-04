package LavadoAutos;

import javax.swing.JOptionPane;

public class Procesos {
	Vehiculo miV;
	int añoActual, cod = 0;
	double valor;
	
	public Procesos() {
		menu();
	};
	
	public void menu() {
		String menuPrincipal = "¿Que desea realizar?\n";
		menuPrincipal += "1. Ingresar un vehiculo\n";
		menuPrincipal+= "2.	Salir\n";
		
		do {
			cod = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
			
			switch (cod) {
			case 1:
				datosVehiculo();
				menuTipoVehiculo(menuPrincipal);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Gracias por usarnos", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
		} while (cod != 2);
	}
	
	public void datosVehiculo() {
		miV = new Vehiculo();
		añoActual = Integer.parseInt(JOptionPane.showInputDialog("Digite el año en el que se encuentra"));
		miV.modelo = Integer.parseInt(JOptionPane.showInputDialog("Digite el modelo de su vehiculo"));
	}
	
	public void menuTipoVehiculo(String tipo) {
		String menuVehiculo = "¿De que es el vehiculo?\n";
		menuVehiculo += "1.	Automovil\n";
		menuVehiculo += "2.	Campero\n";
		menuVehiculo += "3.	Camioneta\n";
		
			cod = Integer.parseInt(JOptionPane.showInputDialog(menuVehiculo));
			
			switch (cod) {
			case 1:
				menuAutomovil();
				miV.tipoVehiculo = "Automovil";
				break;
			case 2:
				menuCampero();
				miV.tipoVehiculo = "Campero";
				break;
			case 3:
				menuCamioneta();
				miV.tipoVehiculo = "Camioneta";
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			incrementoPrecioLavado();
			imprimirDatos();
	}
	
	public void menuAutomovil() {
		String menuA = "¿Que caracteristica posee el automovil?\n";
		menuA += "1.	Es pequeño\n";
		menuA += "2.	Es mediano\n";
		menuA += "3.	Es de lujo\n";
		
		cod = Integer.parseInt(JOptionPane.showInputDialog(menuA));
		
			switch (cod) {
			case 1:
				valor=4000;
				miV.caracteristicaVehiculo = "Pequeño";
				break;
			case 2:
				valor=5000;
				miV.caracteristicaVehiculo = "Mediano";
				break;
			case 3:
				valor=6000;
				miV.caracteristicaVehiculo = "De Lujo";
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
			
	}
	
	public void  menuCampero() {
		String menuC = "¿Que caracteristica posee el campero?\n";
		menuC += "1.	Es sencillo\n";
		menuC += "2.	Es de lujo\n";
		cod = Integer.parseInt(JOptionPane.showInputDialog(menuC));
		
			switch (cod) {
			case 1:
				valor=5000;
				miV.caracteristicaVehiculo = "Sencillo";
				break;
			case 2:
				valor=8000;
				miV.caracteristicaVehiculo = "De Lujo";
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
	}
	
	public void menuCamioneta() {
		String menuCa = "¿Que caracteristica posee la camioneta?\n";
		menuCa += "1.	Posee una cabina sencilla\n";
		menuCa += "2.	Posee cabina doble";
		cod = Integer.parseInt(JOptionPane.showInputDialog(menuCa));
		
			switch (cod) {
			case 1:
				valor=6000;
				miV.caracteristicaVehiculo = "Cabina sencilla";
				break;
			case 2:
				valor=8000;
				miV.caracteristicaVehiculo = "Cabina doble";
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digito invalido", "Advertencia",JOptionPane.ERROR_MESSAGE);
				break;
			}
	}
	
	public void incrementoPrecioLavado() {
		if (añoActual >= 8) {
			valor = (valor*0.20)+valor;
		}
	}
	
	public void imprimirDatos() {
		String mensaje = "<<DATOS VEHICULO>>\n";
	    mensaje += "--------------------------------------\n";
	    mensaje += "Año Actual: "+añoActual+"\n";
	    mensaje += "Modelo: "+miV.modelo+"\n";
	    mensaje += "Tipo: "+miV.tipoVehiculo+"\n";
	    mensaje += "Caracteristicas: "+miV.caracteristicaVehiculo+"\n";
	    mensaje += "Precio Lavado: "+valor+"\n";
	    mensaje += "--------------------------------------\n";
	    JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
