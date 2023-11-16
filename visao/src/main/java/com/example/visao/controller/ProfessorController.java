package com.example.visao.controller;

import java.util.List;

import com.example.visao.dtos.DadosProfessorDTO;
import com.example.visao.dtos.ProfessorDTO;
import com.example.visao.models.Professor;
import com.example.visao.services.ProfessorService;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Professor> salvar(@RequestBody ProfessorDTO professorDTO) {
    Professor professor = professorService.salvar(professorDTO);
    return new ResponseEntity<>(professor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<DadosProfessorDTO> getProfessor() {
    return professorService.obterTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> editar(@PathVariable Long id, @RequestBody ProfessorDTO professorDTO){

        if(professorService.findProfessor(id) == null){
            return ResponseEntity.notFound().build();
        }
        
        Professor professor = professorService.salvar(professorDTO);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(professorService.findProfessor(id) == null){
            return ResponseEntity.notFound().build();
        }
        professorService.remover(id);
        return ResponseEntity.ok().build();
    }
}