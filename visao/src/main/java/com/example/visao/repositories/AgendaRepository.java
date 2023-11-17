package com.example.visao.repositories;

import java.time.LocalDate;
import java.util.List;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.models.Agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    

    @Query("select a from Agenda a  where a.professor.id = :id")
    List<Agenda> findByProfessor(Long id);

}