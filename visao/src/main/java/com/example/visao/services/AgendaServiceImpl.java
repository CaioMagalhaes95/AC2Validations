package com.example.visao.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.models.Agenda;
import com.example.visao.repositories.AgendaRepository;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService{
    private final AgendaRepository agendaRepository;

    @Override
    @Transactional
    public Agenda salvar(AgendaDTO agendaDTO) {

    Agenda agenda = new Agenda();
    agenda.setId(agendaDTO.getId());
    agenda.setCursoOferecido(agendaDTO.getCursoOferecido());
    agenda.setDataInicio(agendaDTO.getDataInicio());
    agenda.setDataFim(agendaDTO.getDataFim());
    //agenda.setHorarioIni(agendaDTO.getHorarioInicio());
    agenda.setHorarioFim(agendaDTO.getHorarioFim());

    agenda.setProfessorResponsavel(agendaDTO.getProfessoResponsavel());

    return agendaRepository.save(agenda);
    }

    @Override
    public List<DadosAgendaDTO> obterTodos() {
        return agendaRepository.findAll().stream().map((Agenda a) -> {
            return DadosAgendaDTO.builder()
                .id(a.getId())
                .cursoOferecido(a.getCursoOferecido())
                .dataInicio(a.getDataInicio())
                .dataFim(a.getDataFim())
                .horarioInicio(a.getHorarioInicio())
                .horarioFim(a.getHorarioFim())
                .professor_responsavel(a.getProfessorResponsavel())
                .cidade(a.getCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .build();
            }).collect(Collectors.toList());
       
    }

    @Override
    public DadosAgendaDTO obterAgendaPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remover(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void editar(Long id, AgendaDTO agendaDTO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Agenda findAgenda(Long id, LocalDate dataInicio) {
        if(dataInicio != null){
            
        }
        return null;
    }

    
}