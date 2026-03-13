package com.github.MarcusDev01.ms.produto.repositories;

import com.github.MarcusDev01.ms.produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
