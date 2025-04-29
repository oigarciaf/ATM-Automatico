package com.cajero;

import javax.swing.*;
import java.awt.*;
import com.cajero.pantallas.*;

public class CajeroSwing extends JFrame {
	private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    public CuentaBancaria cuentaActual;
    public boolean esEspanol = true;

    public CajeroSwing() {
        setTitle("Cajero Automático");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        mostrarPantallaInicio();
    }

    public void cambiarPantalla(JPanel nuevaPantalla) {
        contentPane.removeAll();
        contentPane.add(nuevaPantalla);
        revalidate();
        repaint();
    }

    public void mostrarPantallaInicio() {
        cambiarPantalla(new PantallaInicio(this));
    }

    public void mostrarPantallaPIN() {
        cambiarPantalla(new PantallaPIN(this));
    }

    public void mostrarSeleccionIdioma() {
        cambiarPantalla(new SeleccionIdioma(this));
    }

    public void mostrarMenuPrincipal() {
        cambiarPantalla(new MenuPrincipal(this));
    }

    public void mostrarPantallaDeposito() {
        cambiarPantalla(new PantallaDeposito(this));
    }

    public void mostrarPantallaRetiro() {
        cambiarPantalla(new PantallaRetiro(this));
    }

    public void mostrarPantallaCambioPIN() {
        cambiarPantalla(new PantallaCambioPIN(this));
    }

    public void mostrarPantallaHistorial() {
        cambiarPantalla(new PantallaHistorial(this));
    }

    public void mostrarPantallaRecibo() {
        cambiarPantalla(new PantallaRecibo(this));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
