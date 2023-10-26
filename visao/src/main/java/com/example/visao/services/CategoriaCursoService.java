package com.example.visao.services;
import com.example.visao.dtos.CategoriaCursoDTO;
import com.example.visao.models.CategoriaCurso;

public interface CategoriaCursoService {
    CategoriaCurso salvar(CategoriaCursoDTO dto);
}