package com.example.visao.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.exceptions.RegradeNegocioException;
import com.example.visao.models.Agenda;
import com.example.visao.repositories.AgendaRepository;
import com.example.visao.repositories.CursoRepository;
import com.example.visao.repositories.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService{

    private final AgendaRepository agendaRepository;
    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;
    
    @Override
    @Transactional
    public Agenda salvar(AgendaDTO agendaDTO) {

    Agenda agenda = new Agenda();
    agenda.setId(agendaDTO.getId());
    agenda.setCursoOferecido(agendaDTO.getCursoOferecido());
    agenda.setDataInicio(agendaDTO.getDataInicio());
    agenda.setDataFim(agendaDTO.getDataFim());
    //agenda.setHorarioInicio(agendaDTO.getHorarioInicio());
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
       return agendaRepository.findById(id).map((Agenda a) -> {
        return DadosAgendaDTO.builder()
        .cep(a.getCep())
        .cidade(a.getCidade())
        .cursoOferecido(a.getCursoOferecido())
        .dataFim(a.getDataFim())
        .dataInicio(a.getDataInicio())
        .estado(a.getEstado())
        .horarioFim(a.getHorarioFim())
        .horarioInicio(a.getHorarioInicio())
        .id(a.getId())
        .professor_responsavel(a.getProfessorResponsavel())
        .build();
       }).orElseThrow(() -> new RegradeNegocioException("Agenda não encontrada"));
        
    }

    @Override
    public void remover(Long id) {
        agendaRepository.deleteById(id);
        
    }

    @Override
    public void editar(Long id, AgendaDTO agendaDTO) {
        Agenda agenda = agendaRepository.findById(id)        
        .orElseThrow(() -> new RegradeNegocioException("Agenda não encontrada"));
        agenda.setCep(agendaDTO.getCep());
        agenda.setCidade(agendaDTO.getCidade());
        agenda.setCursoOferecido(agendaDTO.getCursoOferecido());
        agenda.setDataFim(agendaDTO.getDataFim());
        agenda.setDataInicio(agendaDTO.getDataInicio());
        agenda.setEstado(agendaDTO.getEstado());
        agenda.setHorarioFim(agendaDTO.getHorarioFim());
        agenda.setId(agendaDTO.getId());
        agenda.setProfessorResponsavel(agendaDTO.getProfessoResponsavel());
        agendaRepository.save(agenda);

        }
        private AgendaDTO ToDTO(Agenda agenda) {
            return AgendaDTO.builder()
                    .id(agenda.getId())
                    .dataInicio(agenda.getDataInicio())
                    .dataFim(agenda.getDataFim())
                    //.horarioInicio(agenda.getHorarioInicio())
                    .horarioFim(agenda.getHorarioFim())
                    .professoResponsavel(agenda.getProfessorResponsavel())
                    .cidade(agenda.getCidade())
                    .estado(agenda.getEstado())
                    .cep(agenda.getCep())
                    .cursoOferecido(agenda.getCursoOferecido())
                    .build();
        }

    public List<AgendaDTO> agendaPorProfessor(Long id){
        List<Agenda> agendas = agendaRepository.findByProfessor(id);
        return agendas.stream().map(this::ToDTO).collect(Collectors.toList());
         
    }

    }

    
