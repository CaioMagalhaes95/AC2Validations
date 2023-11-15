package com.example.visao.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.exceptions.RegradeNegocioException;
import com.example.visao.models.Agenda;
import com.example.visao.models.Curso;
import com.example.visao.models.Professor;
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
    AgendaRepository agendaRepository;

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CursoRepository cursoRepository;

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

    agenda.setProfessorNome(agendaDTO.getProfessorNome());

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
                .professor(a.getProfessorNome())
                .cidade(a.getCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .build();
            }).collect(Collectors.toList());
       
    }

    @Override
    public DadosAgendaDTO obterAgendaPorId(Long id) {
        return agendaRepository.findById(id).map((Agenda a) -> {
            return AgendaDTO.builder()
            .cep(a.getCep())
            .cidade(a.getCidade())
            .cursoOferecido(a.getCursoOferecido())
            .dataFim(a.getDataFim())
            .dataInicio(a.getDataInicio())
            .estado(a.getEstado())
            .horarioFim(a.getHorarioFim())
            .horarioInicio(a.getHorarioInicio())
            .id(a.getId())
            .build();
        });
        return null;
    }

    @Override
    public void remover(Long id) {
        agendaRepository.deleteById(id);
        
    }

   private void editar(AgendaDTO dto) {        
        Professor professor = professorRepository.findById(dto.getProfessorId())
                                 .orElseThrow(() -> new RegradeNegocioException("Professor não encontrado!"));
        Curso curso = cursoRepository.findById(dto.getCursoId())
                          .orElseThrow(() -> new RegradeNegocioException("Curso não encontrado!"));
        
        Agenda agenda = new Agenda();
        agenda.setDataInicio(dto.getDataInicio());
        agenda.setDataFim(dto.getDataFim());
        agenda.setHorarioInicio(dto.getHorarioInicio());
        agenda.setHorarioFim(dto.getHorarioFim());
        agenda.setProfessorNome(dto.getProfessorNome());
        agenda.setCidade(dto.getCidade());
        agenda.setEstado(dto.getEstado());
        agenda.setCep(dto.getCep());
        agenda.setCurso(curso);
    
        
    }


    private AgendaDTO toAgenda(Agenda agenda) {
        
        
        AgendaDTO agendaDTO;
        return   agendaDTO.builder()
                .id(agenda.getId())
                .dataInicio(agenda.getDataInicio())
                .dataFim(agenda.getDataFim())
                .horarioInicio(agenda.getHorarioInicio())
                .horarioFim(agenda.getHorarioFim())
                .professor(agenda.getProfessorNome())
                .cidade(agenda.getCidade())
                .estado(agenda.getEstado())
                .cep(agenda.getCep())
                .nomeCurso(agenda.getCurso().getNome())
                .cursoId(agenda.getCurso().getId())
                .Professor_id(agenda.getProfessorNome())
                .build();
    }

    @Override
    public List<AgendaDTO> findAgendaProfessor(Long id) {
        List<Agenda> agendas = agendaRepository.findAgendaProfessor(id);
        return agendas.stream().map(this::toAgenda).collect(Collectors.toList());
        
    }

    @Override
    public List<AgendaDTO> findAgenda(Long id, LocalDate dataInicio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAgenda'");
    }

   

    
}