package br.com.ferreira.estoqueSpg.service;

import br.com.ferreira.estoqueSpg.entity.Produto;
import br.com.ferreira.estoqueSpg.enuns.Medida;

import java.util.List;

public interface ProdutoService {
    Produto salvar(Produto produto);
    Produto buscarPorId(Long id);
    Produto atualizar(Produto produto);
    void deletar(Long id);
    List<Produto> buscarTodos();
    List<Produto> buscarPorNome(String nome);
    List<Produto> buscarPorTipoProduto(String tipoProduto);
    List<Produto> buscarPorMedida(Medida medida);
}
