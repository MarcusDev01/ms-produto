package com.github.MarcusDev01.ms.produto.repositories;

import com.github.MarcusDev01.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {


}
