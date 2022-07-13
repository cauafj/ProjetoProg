package gui;

import modelo.Empregado;

public class App {
	public static void main(String[] args) {
		var telaPrincipal = new TelaCrudEmpregado();
		while(true) {
			telaPrincipal.start();
		}
	}
}
