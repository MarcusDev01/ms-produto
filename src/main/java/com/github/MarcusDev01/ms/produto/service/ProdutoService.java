package com.github.MarcusDev01.ms.produto.service;


import com.github.MarcusDev01.ms.produto.dto.ProdutoDTO;
import com.github.MarcusDev01.ms.produto.entities.Produto;
import com.github.MarcusDev01.ms.produto.exceptions.ResourceNotFoundException;
import com.github.MarcusDev01.ms.produto.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findallProdutos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findProdutoById(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Recurso nao encontrado. ID: " + id)
        );

        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO saveProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        copyDtoProduto(produtoDTO,produto);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    private void copyDtoProduto(ProdutoDTO produtoDTO, Produto produto){
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
    }

    @Transactional
    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO){
        try{
            Produto produto = produtoRepository.getReferenceById(id);
            copyDtoProduto(produtoDTO, produto);
            produto = produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso nao encontrado. ID:" + id);
        }
    }

    @Transactional
    public void deleteProdutoById(Long id){
        if(!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso nao encontrado. ID: " + id);

        }
        produtoRepository.deleteById(id);
    }
}
