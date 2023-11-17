package com.example.visao.repositories;

import java.util.List;

import com.example.visao.models.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByNomeLike(String nome);

    @Query("select c from Professor c inner join fetch c.agenda where c.id = :id")
    Professor findProfessor(@Param("id") Long id);
}
