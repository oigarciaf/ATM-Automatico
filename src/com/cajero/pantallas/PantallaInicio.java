package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import com.cajero.componentes.TecladoNumerico;

public class PantallaInicio extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField field; // Necesario para que el teclado lo use

    public PantallaInicio(CajeroSwing cajero) {
        setLayout(null); // Compatible con WindowBuilder

        // Título principal
        JLabel title = new JLabel("Bienvenido al Cajero Automático");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(40, 20, 400, 30);
        add(title);

        // Etiqueta del campo
        JLabel label = new JLabel("Número de Cuenta:");
        label.setBounds(130, 70, 150, 25);
        add(label);

        // Campo de número de cuenta
        field = new JTextField();
        field.setBounds(130, 100, 150, 30);
        add(field);

        // Botón continuar
        JButton continuar = new JButton("Continuar");
        continuar.setBounds(150, 140, 110, 30);
        continuar.addActionListener(e -> {
            String num = field.getText();
            if (num.equals("123") || num.equals("456")) {
                cajero.cuentaActual = new CuentaBancaria("Cliente", num, 1000.0, "1234");
                cajero.mostrarPantallaPIN();
            } else {
                cajero.mostrarMensaje("Cuenta no válida");
            }
        });
        add(continuar);

        // Teclado numérico
        TecladoNumerico teclado = new TecladoNumerico(() -> field); // Usamos lambda como proveedor del campo activo
        teclado.setBounds(90, 190, 220, 200); // Ajusta si es necesario
        add(teclado);
    }
}
