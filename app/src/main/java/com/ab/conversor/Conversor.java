package com.ab.conversor;

public class Conversor {
    private Double TipoCambio;

    public Conversor(Double tipoCambio) {
        this.TipoCambio = tipoCambio;
    }

    public Conversor() {
    }

    public Double getTipoCambio() {
        return TipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        TipoCambio = tipoCambio;
    }

    //metodo para hacer la conversion a euros
    public Double convertirAEuros(double dolares){
        return dolares * getTipoCambio();
    }
    //metodo para hacer la conversion a dolares
    public Double convertirADolares(double euros){
        return euros / getTipoCambio();
    }
}
