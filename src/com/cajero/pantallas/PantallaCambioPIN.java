package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.cajero.CajeroSwing;
import com.cajero.componentes.TecladoNumerico;

public class PantallaCambioPIN extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPasswordField nuevoPIN;
    private JPasswordField confirmarPIN;
    private JTextField campoActivo; // Usado por el teclado numérico

    public PantallaCambioPIN(CajeroSwing cajero) {
        setLayout(null);

        JLabel lblTitulo = new JLabel(cajero.esEspanol ? "Cambiar PIN" : "Change PIN");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(120, 20, 250, 30);
        add(lblTitulo);

        // Campo nuevo PIN
        JLabel lblNuevo = new JLabel(cajero.esEspanol ? "Nuevo PIN:" : "New PIN:");
        lblNuevo.setBounds(50, 70, 100, 25);
        add(lblNuevo);

        nuevoPIN = new JPasswordField();
        nuevoPIN.setBounds(160, 70, 150, 25);
        add(nuevoPIN);

        // Campo confirmar PIN
        JLabel lblConfirmar = new JLabel(cajero.esEspanol ? "Confirmar PIN:" : "Confirm PIN:");
        lblConfirmar.setBounds(50, 110, 100, 25);
        add(lblConfirmar);

        confirmarPIN = new JPasswordField();
        confirmarPIN.setBounds(160, 110, 150, 25);
        add(confirmarPIN);

        // Activar campo en uso
        FocusAdapter focusHandler = new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                campoActivo = (JTextField) e.getComponent();
            }
        };
        nuevoPIN.addFocusListener(focusHandler);
        confirmarPIN.addFocusListener(focusHandler);

        // Botón confirmar
        JButton btnConfirmar = new JButton(cajero.esEspanol ? "Confirmar" : "Confirm");
        btnConfirmar.setBounds(80, 160, 100, 30);
        btnConfirmar.addActionListener(e -> {
            String nuevo = new String(nuevoPIN.getPassword());
            String confirmar = new String(confirmarPIN.getPassword());
            if (nuevo.equals(confirmar) && !nuevo.isEmpty()) {
                cajero.cuentaActual.cambiarPin(nuevo);
                cajero.mostrarMensaje(cajero.esEspanol ? "PIN cambiado exitosamente." : "PIN changed successfully.");
                cajero.mostrarMenuPrincipal();
            } else {
                cajero.mostrarMensaje(cajero.esEspanol ? "Los PINs no coinciden o están vacíos." : "PINs do not match or are empty.");
            }
        });
        add(btnConfirmar);

        // Botón cancelar
        JButton btnCancelar = new JButton(cajero.esEspanol ? "Cancelar" : "Cancel");
        btnCancelar.setBounds(200, 160, 100, 30);
        btnCancelar.addActionListener(e -> cajero.mostrarMenuPrincipal());
        add(btnCancelar);

        // Teclado numérico compartido
        TecladoNumerico teclado = new TecladoNumerico(() -> campoActivo);
        teclado.setBounds(100, 210, 200, 200); // Tamaño y posición
        add(teclado);
    }
}
