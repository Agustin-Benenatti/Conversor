package com.ab.conversor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private Conversor conversor;
    private MutableLiveData<Double> resultado = new MutableLiveData<>();
    private MutableLiveData<Double> tipoCambio = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainActivityViewModel(){
        conversor = new Conversor(0.92); //tipo de cambio por defecto
        tipoCambio.setValue(conversor.getTipoCambio());
    }

    public LiveData<Double> getResultado(){
        return resultado;
    }

    public LiveData<Double> getTipoCambio(){
        return tipoCambio;
    }

    public LiveData<String> getError(){
        return error;
    }

    //Convertir a euros
    public void convertirAEuros(String e){
        if(e.isEmpty()){
            error.setValue("Ingrese el valor en dólares");
            return;
        }

        try {
            double dolares = Double.parseDouble(e);
            resultado.setValue(conversor.convertirAEuros(dolares));
        } catch (Exception c){
            error.setValue("Número inválido");
        }
    }

    //Convertir a dólares
    public void convertirADolares(String d){
        if(d.isEmpty()){
            error.setValue("Ingrese el valor en euros");
            return;
        }

        try{
            double euros = Double.parseDouble(d);
            resultado.setValue(conversor.convertirADolares(euros));
        } catch (Exception e){
            error.setValue("Número inválido");
        }
    }

    // Cambiar tipo de cambio
    public void setTipoCambio(String valor){
        if(valor.isEmpty()){
            error.setValue("Ingrese valor de cambio");
            return;
        }

        try{
            double cambio = Double.parseDouble(valor);

            if(cambio <= 0){
                error.setValue("Valor inválido");
                return;
            }

            conversor.setTipoCambio(cambio);
            tipoCambio.setValue(conversor.getTipoCambio());

        } catch (Exception e){
            error.setValue("Número inválido");
        }
    }
}


