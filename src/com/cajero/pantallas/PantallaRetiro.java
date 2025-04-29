package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import com.cajero.componentes.TecladoNumerico;

public class PantallaRetiro extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField retiro; // Campo de texto para la cantidad a retirar

    public PantallaRetiro(CajeroSwing cajero) {
        setLayout(null); // Usamos null layout para manejar la posición manualmente
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel title = new JLabel(cajero.esEspanol ? "Retiro" : "Withdrawal");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(140, 20, 200, 30);
        add(title);

        // Etiqueta para la cantidad a retirar
        JLabel label = new JLabel(cajero.esEspanol ? "Cantidad a retirar:" : "Amount to withdraw:");
        label.setBounds(120, 70, 200, 25);
        add(label);

        // Campo de texto para ingresar la cantidad a retirar
        retiro = new JTextField();
        retiro.setBounds(120, 100, 180, 30);
        add(retiro);

        // Botón de Confirmar
        JButton confirm = new JButton(cajero.esEspanol ? "Confirmar" : "Confirm");
        confirm.setBounds(74, 141, 120, 30);
        confirm.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(retiro.getText());
                if (amount <= 0 || amount > cajero.cuentaActual.getSaldo()) {
                    cajero.mostrarMensaje(cajero.esEspanol ? "Fondos insuficientes o cantidad inválida." : "Insufficient funds or invalid amount.");
                } else {
                    cajero.cuentaActual.retirar(amount);
                    cajero.mostrarMensaje((cajero.esEspanol ? "Retiro exitoso: $" : "Withdrawal successful: $") + amount);
                    cajero.mostrarMenuPrincipal();
                }
            } catch (NumberFormatException ex) {
                cajero.mostrarMensaje(cajero.esEspanol ? "Ingrese un número válido." : "Enter a valid number.");
            }
        });
        add(confirm);

        // Botón de Cancelar
        JButton cancelar = new JButton(cajero.esEspanol ? "Cancelar" : "Cancel");
        cancelar.setBounds(220, 141, 120, 30);
        cancelar.addActionListener(e -> cajero.mostrarMenuPrincipal());
        add(cancelar);

        // Teclado numérico para la cantidad a retirar
        TecladoNumerico teclado = new TecladoNumerico(() -> retiro); // Usamos lambda como proveedor del campo activo
        teclado.setBounds(100, 182, 220, 200); // Ajusta la posición y el tamaño si es necesario
        add(teclado);
    }
}
