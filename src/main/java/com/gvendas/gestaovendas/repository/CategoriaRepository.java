package com.gvendas.gestaovendas.repository;

import com.gvendas.gestaovendas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
}
