package com.example.estadorealbeta.ui.pagos;

import java.util.Date;

public class Pago {

    private int numeroPago;
    private String fechaPago;
    private double importe;

    public Pago(int numeroPago, String fechaPago, double importe) {
        this.numeroPago = numeroPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
