package br.com.ferreira.estoqueSpg.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoProduto {
    ALIMENTO,
    BEBIDA,
    HIGIENE,
    LIMPEZA,
    ELETRONICO,
    ROUPA,
    CALCADO,
    ACESSORIO;

    @JsonCreator
    public static TipoProduto fromString(String tipo){
        try{
            return TipoProduto.valueOf(tipo.trim().toUpperCase());
        }catch (RuntimeException e){
            throw new IllegalArgumentException("Valor de medida inválido: " + tipo);
        }
    }

}
