package br.com.ferreira.estoqueSpg.dto;

import br.com.ferreira.estoqueSpg.enuns.Medida;
import br.com.ferreira.estoqueSpg.enuns.TipoProduto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDto {
    private Long id;
    private String nome;
    private double preco;
    private TipoProduto tipoProduto;
    private Medida medida;
    private int codigoProduto;
    private int quantidade;
}
