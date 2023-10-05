package com.gvendas.gestaovendas.service;

import com.gvendas.gestaovendas.exceptions.DadoNaoEncontradoException;
import com.gvendas.gestaovendas.exceptions.RegraNegocioException;
import com.gvendas.gestaovendas.model.Categoria;
import com.gvendas.gestaovendas.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElseThrow(() -> new DadoNaoEncontradoException("Categoria que representa o id " + idCategoria + " não encontrado."));
    }

    public Categoria save(Categoria categoria) {
        validarCategoriaDuplicada(categoria);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long codigo, Categoria categoria) {
        Categoria categoriaEncontrada = categoriaRepository.findById(codigo).orElseThrow(() -> new DadoNaoEncontradoException("Categoria com o id " + codigo + " não encontrada."));
        validarCategoriaDuplicada(categoria);
        Categoria categoriaSalva = categoriaRepository.save(new Categoria(categoriaEncontrada, categoria));
        return categoriaSalva;
    }

    public void delete(Long codigo) {
        categoriaRepository.deleteById(codigo);
    }

    private void validarCategoriaDuplicada(Categoria categoria) {
        Categoria categoriaEncontrada = categoriaRepository.findByNome(categoria.getNome());
        if (categoriaRepository.findByNome(categoria.getNome()) != null && categoriaEncontrada.getCodigo() != categoria.getCodigo()){
            throw new RegraNegocioException(String.format("A categoria %s já está cadastrada", categoria.getNome().toUpperCase()));
        }
    }

}
