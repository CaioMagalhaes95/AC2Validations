package com.example.visao.services;

import org.springframework.stereotype.Service;
import com.example.visao.dtos.CategoriaCursoDTO;
import com.example.visao.models.CategoriaCurso;
import com.example.visao.repositories.CategoriaCursoRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CategoriaCursoServiceImpl implements CategoriaCursoService {
    
    private final CategoriaCursoRepository categoriaCursoRepository;
@Override
public CategoriaCurso salvar(CategoriaCursoDTO dto) {
    CategoriaCurso categ = new CategoriaCurso();
    categ.setNome(dto.getNome());
    return categoriaCursoRepository.save(categ);
}
}