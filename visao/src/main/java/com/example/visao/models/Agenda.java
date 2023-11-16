package com.example.visao.models;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String cursoOferecido;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private LocalDateTime horarioInicio;

    @Column(nullable = false)
    private LocalDateTime horarioFim;

    @Column(length = 200, nullable = false)
    private String professorResponsavel;

    @Column(length = 200, nullable = false)
    private String cidade;

    @Column(length = 200, nullable = false)
    private String estado;

    @Column(length = 200, nullable = false)
    private String cep;


    @ManyToOne
    @JoinColumn(name = "Curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "Professor_id")
    private Professor professor;

    
    public Professor getProfessor() {
        return professor;
    }


    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCursoOferecido() {
        return cursoOferecido;
    }


    public void setCursoOferecido(String cursoOferecido) {
        this.cursoOferecido = cursoOferecido;
    }


    public LocalDate getDataInicio() {
        return dataInicio;
    }


    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }


    public LocalDate getDataFim() {
        return dataFim;
    }


    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }


    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }


    public void setHorarioInicio(LocalDateTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    


    public LocalDateTime getHorarioFim() {
        return horarioFim;
    }


    public void setHorarioFim(LocalDateTime horarioFim) {
        this.horarioFim = horarioFim;
    }


    public String getProfessorResponsavel() {
        return professorResponsavel;
    }


    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public Curso getCurso() {
        return curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
