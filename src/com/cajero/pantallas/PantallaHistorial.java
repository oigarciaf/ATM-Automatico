package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;

public class PantallaHistorial extends JPanel {
	private static final long serialVersionUID = 1L;

    public PantallaHistorial(CajeroSwing cajero) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel(cajero.esEspanol ? "Historial de Transacciones" : "Transaction History");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String registro : cajero.cuentaActual.getHistorial()) {
            listModel.addElement(registro);
        }
        JList<String> lista = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane, BorderLayout.CENTER);

        JButton volver = new JButton(cajero.esEspanol ? "Volver" : "Back");
        volver.addActionListener(e -> cajero.mostrarMenuPrincipal());
        JPanel panelBoton = new JPanel();
        panelBoton.add(volver);
        add(panelBoton, BorderLayout.SOUTH);
    }
}
