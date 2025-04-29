package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import com.cajero.componentes.TecladoNumerico;

public class PantallaPIN extends JPanel {
    private static final long serialVersionUID = 1L;

    public PantallaPIN(CajeroSwing cajero) {
        setLayout(null);

        JLabel label = new JLabel("Ingrese su PIN:");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setBounds(100, 20, 200, 30);
        add(label);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(100, 60, 200, 30);
        add(pinField);

        JButton continuar = new JButton("Continuar");
        continuar.setBounds(140, 100, 120, 30);
        continuar.addActionListener(e -> {
            String pin = new String(pinField.getPassword());
            if (cajero.cuentaActual.autenticar(pin)) {
                cajero.mostrarSeleccionIdioma();
            } else {
                cajero.mostrarMensaje("PIN incorrecto");
            }
        });
        add(continuar);

        // Teclado que siempre actúa sobre pinField
        TecladoNumerico teclado = new TecladoNumerico(() -> pinField);
        teclado.setBounds(90, 150, 220, 200);
        add(teclado);
    }
}
