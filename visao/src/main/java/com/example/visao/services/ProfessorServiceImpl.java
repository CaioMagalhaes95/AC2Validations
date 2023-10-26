package com.example.visao.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.visao.dtos.DadosProfessorDTO;
import com.example.visao.dtos.ProfessorDTO;
import com.example.visao.models.Professor;
import com.example.visao.repositories.ProfessorRepository;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public Professor salvar(ProfessorDTO professorDTO) {

    Professor professor = new Professor();
    professor.setId(professorDTO.getId());
    professor.setNome(professorDTO.getNome());
    professor.setCelular(professorDTO.getCelular());
    professor.setCpf(professorDTO.getCpf());
    professor.setRg(professorDTO.getRg());
    professor.setEndereco(professorDTO.getEndereco());

    return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public Professor findProfessor(Long id){
        Professor professor = professorRepository.findProfessor(id);
        return professor;
    }

    
    @Override
    public List<DadosProfessorDTO> obterTodos() {
        return professorRepository.findAll().stream().map((Professor p) -> {
            return DadosProfessorDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .cpf(p.getCpf())
                .rg(p.getRg())
                .endereco(p.getEndereco())
                .celular(p.getCelular())
                .build();
            }).collect(Collectors.toList());
    }

    @Override
    public DadosProfessorDTO obterCursoPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remover(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void editar(Long id, ProfessorDTO cursoDto) {
        // TODO Auto-generated method stub
        
    }


}
