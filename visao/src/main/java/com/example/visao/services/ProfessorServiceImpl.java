package com.example.visao.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.visao.dtos.DadosProfessorDTO;
import com.example.visao.dtos.ProfessorDTO;
import com.example.visao.exceptions.RegradeNegocioException;
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
    public DadosProfessorDTO obterProfessorPorId(Long id) {
        return professorRepository.findById(id).map((Professor p) -> {
            return DadosProfessorDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .celular(p.getCelular())
            .cpf(p.getCpf())
            .endereco(p.getEndereco())
            .rg(p.getRg())
            .build();
        }).orElseThrow(() -> new RegradeNegocioException("Professor não encontrado"));
        
    }

    @Override
    public void remover(Long id) {
        professorRepository.deleteById(id);
        
    }

    @Override
    public void editar(Long id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RegradeNegocioException("Professor não encontrado"));
            professor.setId(professorDTO.getId());
            professor.setNome(professorDTO.getNome());
            professor.setCelular(professorDTO.getCelular());
            professor.setEndereco(professorDTO.getEndereco());
            professor.setRg(professorDTO.getRg());
            professor.setCpf(professorDTO.getCpf());
            professorRepository.save(professor);
       
        
    }


}
