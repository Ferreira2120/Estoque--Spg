package br.com.ferreira.estoqueSpg.service;

import br.com.ferreira.estoqueSpg.dto.ProdutoDto;
import br.com.ferreira.estoqueSpg.entity.Produto;
import br.com.ferreira.estoqueSpg.enuns.Medida;
import br.com.ferreira.estoqueSpg.enuns.TipoProduto;
import br.com.ferreira.estoqueSpg.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    public final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id){
        try{
            return produtoRepository.getById(id);
        }catch (RuntimeException e){
            throw new RuntimeException("Produto não encontrado!");
        }
    }


    public Produto atualizar(Produto produto){

        Produto produto1 = buscarPorId(produto.getId());

        Produto produtoAtualizado = Produto.builder()
                                            .id(produto.getId())
                                            .nome(produto.getNome())
                                            .preco(produto.getPreco())
                                            .tipoProduto(produto.getTipoProduto())
                                            .medida(produto.getMedida())
                                            .codigoProduto(produto.getCodigoProduto())
                                            .quantidade(produto.getQuantidade())
                                            .build();

        return produtoRepository.save(produtoAtualizado);
    }

    public void deletar(Long id){
            Produto produto = buscarPorId(id);
            produtoRepository.delete(produto);
    }


    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public List<Produto> buscarPorNome(String nome){
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> buscarPorTipoProduto(String tipoProduto){
        List<Produto> produto = produtoRepository.findByTipoProduto(TipoProduto.valueOf(tipoProduto.toUpperCase()));
        if (produto.isEmpty()){
            throw new RuntimeException("Produto não encontrado!");
        }
        return produto;
    }

    public List<Produto> buscarPorMedida(Medida medida){
        return produtoRepository.findByMedida(medida);
    }


    public static Produto converterDtoParaProduto(ProdutoDto produtoDto){

        Produto produto = Produto.builder()
                .id(produtoDto.getId())
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .tipoProduto(produtoDto.getTipoProduto())
                .medida(produtoDto.getMedida())
                .codigoProduto(produtoDto.getCodigoProduto())
                .quantidade(produtoDto.getQuantidade())
                .build();

        return produto;
    }

    public static ProdutoDto converterProdutoParaDto(Produto produto){

        String tipoProduto = produto.getTipoProduto().name().toUpperCase();


        ProdutoDto produtoDto = ProdutoDto.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .tipoProduto(produto.getTipoProduto())
                .medida(produto.getMedida())
                .codigoProduto(produto.getCodigoProduto())
                .quantidade(produto.getQuantidade())
                .build();

        return produtoDto;
    }

}
