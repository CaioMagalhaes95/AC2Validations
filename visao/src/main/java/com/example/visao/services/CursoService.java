package com.example.visao.services;

import java.util.*;
import com.example.visao.dtos.CursoDTO;
import com.example.visao.dtos.DadosCursoDTO;
import com.example.visao.models.Curso;
public interface CursoService {
    
    Curso salvar(CursoDTO cursoDTO);
    DadosCursoDTO obterCursoPorId(Long id);
    void remover(Long id);
    void editar(Long id, CursoDTO cursoDto);
    List<DadosCursoDTO> obterTodos();
    Curso findCurso(Long id);
}
