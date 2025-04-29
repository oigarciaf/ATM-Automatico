package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;

public class SeleccionIdioma extends JPanel {
	private static final long serialVersionUID = 1L;
    public SeleccionIdioma(CajeroSwing cajero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("Seleccione idioma / Select language");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createRigidArea(new Dimension(0, 50)));

        JButton esp = new JButton("Español");
        JButton eng = new JButton("English");

        esp.setAlignmentX(Component.CENTER_ALIGNMENT);
        eng.setAlignmentX(Component.CENTER_ALIGNMENT);

        esp.addActionListener(e -> {
            cajero.esEspanol = true;
            cajero.mostrarMenuPrincipal();
        });

        eng.addActionListener(e -> {
            cajero.esEspanol = false;
            cajero.mostrarMenuPrincipal();
        });

        add(esp);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(eng);
    }
}
