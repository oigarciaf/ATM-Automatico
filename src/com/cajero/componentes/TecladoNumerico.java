package com.cajero.componentes;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

public class TecladoNumerico extends JPanel {
    private static final long serialVersionUID = 1L;

    public TecladoNumerico(Supplier<JTextField> campoActualSupplier) {
        setLayout(new GridLayout(4, 3, 5, 5));
        Dimension buttonSize = new Dimension(60, 40);

        for (int i = 1; i <= 9; i++) {
            final int digit = i;
            JButton button = new JButton(String.valueOf(i));
            button.setPreferredSize(buttonSize);
            button.addActionListener(e -> {
                JTextField campo = campoActualSupplier.get();
                if (campo != null) {
                    campo.setText(campo.getText() + digit);
                }
            });
            add(button);
        }

        JButton clearButton = new JButton("C");
        clearButton.setPreferredSize(buttonSize);
        clearButton.addActionListener(e -> {
            JTextField campo = campoActualSupplier.get();
            if (campo != null) {
                campo.setText("");
            }
        });
        add(clearButton);

        JButton zeroButton = new JButton("0");
        zeroButton.setPreferredSize(buttonSize);
        zeroButton.addActionListener(e -> {
            JTextField campo = campoActualSupplier.get();
            if (campo != null) {
                campo.setText(campo.getText() + "0");
            }
        });
        add(zeroButton);

        JButton backButton = new JButton("←");
        backButton.setPreferredSize(buttonSize);
        backButton.addActionListener(e -> {
            JTextField campo = campoActualSupplier.get();
            if (campo != null) {
                String text = campo.getText();
                if (!text.isEmpty()) {
                    campo.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        add(backButton);
    }
}
