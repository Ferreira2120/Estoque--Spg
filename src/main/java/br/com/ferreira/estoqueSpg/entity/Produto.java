package br.com.ferreira.estoqueSpg.entity;

import br.com.ferreira.estoqueSpg.enuns.Medida;
import br.com.ferreira.estoqueSpg.enuns.TipoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @Column
    @NotNull(message = "O preço do produto é obrigatório")
    private double preco;

    @Column
    @NotNull(message = "O tipo do produto é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;

    @Column
    @NotNull(message = "A medida do produto é obrigatória")
    @Enumerated(EnumType.STRING)
    private Medida medida;

    @Column
    @NotNull(message = "O código do produto é obrigatório")
    private int codigoProduto;

    @Column
    @NotNull(message = "A quantidade do produto é obrigatória")
    private int quantidade;
}
