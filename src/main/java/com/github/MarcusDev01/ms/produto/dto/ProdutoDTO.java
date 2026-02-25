package com.github.MarcusDev01.ms.produto.dto;

import com.github.MarcusDev01.ms.produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Campo nome é requerido")
    @Size(min = 3, max = 100 , message = "o nome deve ter entre 3 a 100 caracteres")
    private String nome;

    @NotBlank(message = "Campo descricao é requerido")
    @Size(min = 10, message = "a descricao deve ter no mininimo 10 caracteres")
    private String descricao;

    @NotNull(message = "Campo valor é requerido")
    @Positive(message = "o campo valor deve um numero positivo maior que zero")
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
    }
}
