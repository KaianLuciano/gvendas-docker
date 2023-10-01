package com.gvendas.gestaovendas.repository;

import com.gvendas.gestaovendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
