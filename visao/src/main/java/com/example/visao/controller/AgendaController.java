package com.example.visao.controller;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.models.Agenda;
import com.example.visao.services.AgendaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
    this.agendaService = agendaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda salvar(@RequestBody AgendaDTO agendaDTO) {
    Agenda a = agendaService.salvar(agendaDTO);
    return a;
    }

    @GetMapping
    public List<DadosAgendaDTO> getAgenda() {
    return agendaService.obterTodos();
    }

    
    @GetMapping("{id}/{data}")
    public List<AgendaDTO> getAgendaData(
        @PathVariable Long id, @PathVariable LocalDate data
        ){
        return agendaService.findAgenda(id, data);
    }

    @GetMapping("{id}")
    public List<AgendaDTO> getAgendaId(@PathVariable Long id){
        return agendaService.findAgendaProfessor(id);
    }
}