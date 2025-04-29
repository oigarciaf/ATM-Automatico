package com.cajero;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String nombre;
    private String numeroCuenta;
    private double saldo;
    private String pin;
    private List<String> historial;

    public CuentaBancaria(String nombre, String numeroCuenta, double saldo, String pin) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
        this.historial = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public boolean autenticar(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public void cambiarPin(String nuevoPin) {
        this.pin = nuevoPin;
        historial.add("Cambio de PIN realizado.");
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        historial.add("Depósito: +" + cantidad);
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            historial.add("Retiro: -" + cantidad);
        } else {
            historial.add("Intento de retiro fallido por fondos insuficientes.");
        }
    }
}