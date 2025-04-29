package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;
import java.time.LocalDate;
import java.time.LocalTime;
import com.cajero.componentes.TecladoNumerico;

public class PantallaRecibo extends JPanel {
    private static final long serialVersionUID = 1L;

    public PantallaRecibo(CajeroSwing cajero) {
        setLayout(null); // Usamos null layout para manejar la posición manualmente
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel title = new JLabel(cajero.esEspanol ? "RECIBO" : "RECEIPT");
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        title.setBounds(140, 20, 200, 30); // Ajustar la posición con setBounds
        add(title);

        // Información del cliente
        JLabel cliente = new JLabel((cajero.esEspanol ? "Cliente: " : "Customer: ") + cajero.cuentaActual.getNombre());
        cliente.setBounds(120, 70, 200, 25);
        add(cliente);

        // Fecha
        JLabel fecha = new JLabel((cajero.esEspanol ? "Fecha: " : "Date: ") + LocalDate.now());
        fecha.setBounds(120, 100, 200, 25);
        add(fecha);

        // Hora
        JLabel hora = new JLabel((cajero.esEspanol ? "Hora: " : "Time: ") + LocalTime.now().withNano(0));
        hora.setBounds(120, 130, 200, 25);
        add(hora);

        // Saldo actual
        JLabel saldo = new JLabel((cajero.esEspanol ? "Saldo actual: $" : "Current balance: $") + String.format("%.2f", cajero.cuentaActual.getSaldo()));
        saldo.setBounds(120, 160, 200, 25);
        add(saldo);

        add(Box.createRigidArea(new Dimension(0, 20)));

        // Botón Imprimir
        JButton imprimir = new JButton(cajero.esEspanol ? "Imprimir" : "Print");
        imprimir.setBounds(140, 200, 120, 30);
        imprimir.addActionListener(e -> {
            cajero.mostrarMensaje(cajero.esEspanol ? "Recibo enviado a la impresora (simulado)." : "Receipt sent to printer (simulated).");
            cajero.mostrarMenuPrincipal();
        });
        add(imprimir);

        // Botón Cancelar
        JButton cancelar = new JButton(cajero.esEspanol ? "Cancelar" : "Cancel");
        cancelar.setBounds(140, 240, 120, 30);
        cancelar.addActionListener(e -> cajero.mostrarMenuPrincipal());
        add(cancelar);
        
        // Teclado numérico si deseas integrarlo con alguna funcionalidad
        TecladoNumerico teclado = new TecladoNumerico(() -> null); // No es necesario un campo de texto en esta pantalla
        teclado.setBounds(90, 280, 220, 200); // Ajusta la posición y el tamaño si es necesario
        add(teclado);
    }
}
