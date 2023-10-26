package com.example.visao.services;

import java.util.List;

import com.example.visao.dtos.DadosProfessorDTO;
import com.example.visao.dtos.ProfessorDTO;
import com.example.visao.models.Professor;

public interface ProfessorService {
    
    Professor salvar(ProfessorDTO professorDTO);
    DadosProfessorDTO obterCursoPorId(Long id);
    void remover(Long id);
    void editar(Long id, ProfessorDTO cursoDto);
    List<DadosProfessorDTO> obterTodos();
    Professor findProfessor(Long id);
    
}
