package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import com.cajero.componentes.TecladoNumerico;

public class PantallaDeposito extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField amountField; // Necesario para que el teclado lo use

    public PantallaDeposito(CajeroSwing cajero) {
        setLayout(null); // Compatible con WindowBuilder

        // Título
        JLabel title = new JLabel(cajero.esEspanol ? "Depósito" : "Deposit");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(140, 20, 200, 30);
        add(title);

        // Etiqueta de cantidad a depositar
        JLabel label = new JLabel(cajero.esEspanol ? "Cantidad a depositar:" : "Amount to deposit:");
        label.setBounds(120, 70, 200, 25);
        add(label);

        // Campo para ingresar cantidad
        amountField = new JTextField();
        amountField.setBounds(120, 100, 180, 30);
        add(amountField);

        // Botón de Confirmar
        JButton confirm = new JButton(cajero.esEspanol ? "Confirmar" : "Confirm");
        confirm.setBounds(140, 140, 120, 30);
        confirm.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= 0) {
                    cajero.mostrarMensaje(cajero.esEspanol ? "Cantidad inválida." : "Invalid amount.");
                } else {
                    cajero.cuentaActual.depositar(amount);
                    cajero.mostrarMensaje((cajero.esEspanol ? "Depósito exitoso: $" : "Deposit successful: $") + amount);
                    cajero.mostrarMenuPrincipal();
                }
            } catch (NumberFormatException ex) {
                cajero.mostrarMensaje(cajero.esEspanol ? "Ingrese un número válido." : "Enter a valid number.");
            }
        });
        add(confirm);

        // Botón de Cancelar
        JButton cancelar = new JButton(cajero.esEspanol ? "Cancelar" : "Cancel");
        cancelar.setBounds(140, 180, 120, 30);
        cancelar.addActionListener(e -> cajero.mostrarMenuPrincipal());
        add(cancelar);

        // Teclado numérico para la cantidad
        TecladoNumerico teclado = new TecladoNumerico(() -> amountField); // Usamos lambda como proveedor del campo activo
        teclado.setBounds(90, 220, 220, 200); // Ajusta la posición y el tamaño si es necesario
        add(teclado);
    }
}
