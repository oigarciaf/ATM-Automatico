package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class PantallaRecibo extends JPanel {
	private static final long serialVersionUID = 1L;

    public PantallaRecibo(CajeroSwing cajero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel(cajero.esEspanol ? "RECIBO" : "RECEIPT");
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel cliente = new JLabel((cajero.esEspanol ? "Cliente: " : "Customer: ") + cajero.cuentaActual.getNombre());
        cliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(cliente);

        JLabel fecha = new JLabel((cajero.esEspanol ? "Fecha: " : "Date: ") + LocalDate.now());
        fecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(fecha);

        JLabel hora = new JLabel((cajero.esEspanol ? "Hora: " : "Time: ") + LocalTime.now().withNano(0));
        hora.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(hora);

        JLabel saldo = new JLabel((cajero.esEspanol ? "Saldo actual: $" : "Current balance: $") + String.format("%.2f", cajero.cuentaActual.getSaldo()));
        saldo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(saldo);

        add(Box.createRigidArea(new Dimension(0, 20)));

        JButton imprimir = new JButton(cajero.esEspanol ? "Imprimir" : "Print");
        imprimir.setAlignmentX(Component.CENTER_ALIGNMENT);
        imprimir.addActionListener(e -> {
            cajero.mostrarMensaje(cajero.esEspanol ? "Recibo enviado a la impresora (simulado)." : "Receipt sent to printer (simulated).");
            cajero.mostrarMenuPrincipal();
        });

        JButton cancelar = new JButton(cajero.esEspanol ? "Cancelar" : "Cancel");
        cancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelar.addActionListener(e -> cajero.mostrarMenuPrincipal());

        add(imprimir);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(cancelar);
    }
}
