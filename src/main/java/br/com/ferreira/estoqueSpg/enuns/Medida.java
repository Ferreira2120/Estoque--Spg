package br.com.ferreira.estoqueSpg.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Medida {
    KL,
    GM,
    L,
    ML;

    @JsonCreator
    public static Medida fromString(String medida){
        try{
            return Medida.valueOf(medida.trim().toUpperCase());
        }catch (RuntimeException e){
            throw new IllegalArgumentException("Valor de medida inválido: " + medida);
        }
    }
}
