package com.example.visao.repositories;

import java.time.LocalDate;
import java.util.List;

import com.example.visao.dtos.DadosAgendaDTO;
import com.example.visao.models.Agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByNomeLike(String nome);

    @Query("select c from Professor c inner join fetch c.agenda c where c.id = :id")
    List<Agenda> findAgenda(@Param("id") Long id, @Param("data") LocalDate DataInicio);

    @Query("select c from Agenda c where c.professor.id = :id")
    List<Agenda> findAgendaProfessor(@Param("id")Long id);
}