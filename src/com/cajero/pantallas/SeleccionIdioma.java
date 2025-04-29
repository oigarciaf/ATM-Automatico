package com.cajero.pantallas;

import javax.swing.*;
import java.awt.*;
import com.cajero.*;

public class SeleccionIdioma extends JPanel {
    private static final long serialVersionUID = 1L;

    public SeleccionIdioma(CajeroSwing cajero) {
        setLayout(null); // Usamos layout null para un control completo sobre la posición de los componentes
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Título
        JLabel title = new JLabel("Seleccione idioma / Select language");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(60, 30, 300, 30); // Ajustamos la posición y tamaño
        add(title);

        // Botones de idioma
        JButton esp = new JButton("Español");
        JButton eng = new JButton("English");

        esp.setBounds(120, 120, 150, 30); // Ajustamos la posición y tamaño
        eng.setBounds(120, 160, 150, 30); // Ajustamos la posición y tamaño

        // Acción para Español
        esp.addActionListener(e -> {
            cajero.esEspanol = true;
            cajero.mostrarMenuPrincipal();
        });

        // Acción para Inglés
        eng.addActionListener(e -> {
            cajero.esEspanol = false;
            cajero.mostrarMenuPrincipal();
        });

        // Añadir botones a la interfaz
        add(esp);
        add(eng);
    }
}
