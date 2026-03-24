package br.com.ferreira.estoqueSpg.controller;

import br.com.ferreira.estoqueSpg.dto.ProdutoDto;
import br.com.ferreira.estoqueSpg.entity.Produto;
import br.com.ferreira.estoqueSpg.enuns.Medida;
import br.com.ferreira.estoqueSpg.service.ProdutoService;
import br.com.ferreira.estoqueSpg.service.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/buscar-id/{id}")
    public ProdutoDto buscarPòrId(@PathVariable("id") Long id){
        try{
            Produto produto = produtoService.buscarPorId(id);
            return ProdutoServiceImpl.converterProdutoParaDto(produto);
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
        }
    }

    @GetMapping
    public List<ProdutoDto> buscarTodos(){
        try{
            List<Produto> produtos = produtoService.buscarTodos();
            return produtos.stream()
                    .map(ProdutoServiceImpl::converterProdutoParaDto)
                    .toList();
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    @GetMapping("/medida/{medida}")
    public List<ProdutoDto> buscarPorMedida(@PathVariable("medida") String medida){
        try{
            List<Produto> produtos = produtoService.buscarPorMedida(Medida.valueOf(medida.toUpperCase()));
            return produtos.stream()
                    .map(ProdutoServiceImpl::converterProdutoParaDto)
                    .toList();
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar produtos por medida: " + e.getMessage());
        }
    }

    @GetMapping("/tipo/{tipoProduto}")
    public List<ProdutoDto> buscarPorTipoProduto(@PathVariable("tipoProduto") String tipoProduto){
        try{
            List<Produto> produtos = produtoService.buscarPorTipoProduto(tipoProduto.toUpperCase());
            return produtos.stream()
                    .map(ProdutoServiceImpl::converterProdutoParaDto)
                    .toList();
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar produtos por tipo: " + e.getMessage());
        }
    }

    @GetMapping("/buscar-nome/{nome}")
    public ProdutoDto buscarPorNome(@PathVariable("nome") String nome){
        try{
            List<Produto> produtos = produtoService.buscarPorNome(nome);
            if(produtos.isEmpty()){
                throw new RuntimeException("Produto não encontrado!");
            }
            return ProdutoServiceImpl.converterProdutoParaDto(produtos.get(0));
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar produto por nome: " + e.getMessage());
        }
    }

    @PostMapping("/novo")
    public ProdutoDto criarProduto(@RequestBody @Valid ProdutoDto produto){
        try{
            Produto produto1 = ProdutoServiceImpl.converterDtoParaProduto(produto);
            Produto produtoSalvo = produtoService.salvar(produto1);
            return ProdutoServiceImpl.converterProdutoParaDto(produtoSalvo);
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao criar produto: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ProdutoDto atualizarProduto(@RequestBody @Valid ProdutoDto produto){
        try{
            Produto produto1 = ProdutoServiceImpl.converterDtoParaProduto(produto);
            Produto produtoAtualizado = produtoService.atualizar(produto1);
            return ProdutoServiceImpl.converterProdutoParaDto(produtoAtualizado);
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") Long id) {
        try {
            produtoService.deletar(id);
            return "Produto deletado com sucesso!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        }
    }
}
