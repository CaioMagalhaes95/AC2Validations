package com.example.visao.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.visao.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNomeLike(String nome);

        @Query("select cc from Curso cc inner join fetch cc.professor c where cc.id = :id")
        Curso findCurso(@Param("id") Long id);
}