package com.cajero.pantallas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import com.cajero.CajeroSwing;

public class MenuPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;

	public MenuPrincipal(CajeroSwing cajero) {
		setLayout(null); // Diseño absoluto compatible con WindowBuilder

		// Título
		JLabel lblTitulo = new JLabel(cajero.esEspanol ? "Menú Principal" : "Main Menu");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(177, 29, 250, 30);
		add(lblTitulo);

		// Botón 1: Consultar saldo
		JButton btnSaldo = new JButton(cajero.esEspanol ? "Consultar saldo" : "Check balance");
		btnSaldo.setBounds(31, 69, 200, 25);
		btnSaldo.addActionListener(e -> cajero.mostrarMensaje("Saldo: $" + cajero.cuentaActual.getSaldo()));
		add(btnSaldo);

		// Botón 2: Depositar dinero
		JButton btnDeposito = new JButton(cajero.esEspanol ? "Depositar dinero" : "Deposit");
		btnDeposito.setBounds(240, 69, 200, 25);
		btnDeposito.addActionListener(e -> cajero.mostrarPantallaDeposito());
		add(btnDeposito);

		// Botón 3: Retirar dinero
		JButton btnRetiro = new JButton(cajero.esEspanol ? "Retirar dinero" : "Withdraw");
		btnRetiro.setBounds(31, 123, 200, 25);
		btnRetiro.addActionListener(e -> cajero.mostrarPantallaRetiro());
		add(btnRetiro);

		// Botón 4: Cambiar PIN
		JButton btnCambioPIN = new JButton(cajero.esEspanol ? "Cambiar PIN" : "Change PIN");
		btnCambioPIN.setBounds(240, 123, 200, 25);
		btnCambioPIN.addActionListener(e -> cajero.mostrarPantallaCambioPIN());
		add(btnCambioPIN);

		// Botón 5: Historial
		JButton btnHistorial = new JButton(cajero.esEspanol ? "Historial" : "History");
		btnHistorial.setBounds(31, 181, 200, 25);
		btnHistorial.addActionListener(e -> cajero.mostrarPantallaHistorial());
		add(btnHistorial);

		// Botón 6: Recibo
		JButton btnRecibo = new JButton(cajero.esEspanol ? "Recibo" : "Receipt");
		btnRecibo.setBounds(240, 181, 200, 25);
		btnRecibo.addActionListener(e -> cajero.mostrarPantallaRecibo());
		add(btnRecibo);

		// Botón 7: Salir
		JButton btnSalir = new JButton(cajero.esEspanol ? "Salir" : "Exit");
		btnSalir.setBounds(150, 233, 200, 25);
		btnSalir.addActionListener(e -> cajero.mostrarPantallaInicio());
		add(btnSalir);
	}
}
