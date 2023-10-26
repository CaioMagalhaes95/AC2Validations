package com.example.visao.services;

import java.time.LocalDate;
import java.util.List;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.models.Agenda;

public interface AgendaService {
    Agenda salvar(AgendaDTO agendaDTO);
    DadosAgendaDTO obterAgendaPorId(Long id);
    void remover(Long id);
    void editar(Long id, AgendaDTO agendaDTO);
    List<DadosAgendaDTO> obterTodos();

    Agenda findAgenda(Long id, LocalDate dataInicio);
}
