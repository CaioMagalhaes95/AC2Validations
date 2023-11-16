package com.example.visao.repositories;

import java.time.LocalDate;
import java.util.List;

import com.example.visao.dtos.AgendaDTO;
import com.example.visao.models.Agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    

    // @Query("select c from Professor c inner join fetch c.agenda c where c.id = :id")
    // List<Agenda>f

        List<Agenda> findByProfessor(Long id);
}