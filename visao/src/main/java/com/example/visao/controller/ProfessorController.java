package com.example.visao.controller;

import java.util.List;

import com.example.visao.dtos.DadosProfessorDTO;
import com.example.visao.dtos.ProfessorDTO;
import com.example.visao.models.Professor;
import com.example.visao.services.ProfessorService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    private ProfessorService professorService;
    public ProfessorController(ProfessorService professorService) {
    this.professorService = professorService;
    }

    @GetMapping
    public Professor findProfessor(@RequestParam Long id){
        return professorService.findProfessor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor salvar(@RequestBody ProfessorDTO professorDTO) {
    Professor p = professorService.salvar(professorDTO);
    return p;
    }

    @GetMapping
    public List<DadosProfessorDTO> getProfessor() {
    return professorService.obterTodos();
    }
}