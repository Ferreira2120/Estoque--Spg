package br.com.ferreira.estoqueSpg.repository;

import br.com.ferreira.estoqueSpg.entity.Produto;
import br.com.ferreira.estoqueSpg.enuns.Medida;
import br.com.ferreira.estoqueSpg.enuns.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    List<Produto> findByMedida(Medida medida);

}
