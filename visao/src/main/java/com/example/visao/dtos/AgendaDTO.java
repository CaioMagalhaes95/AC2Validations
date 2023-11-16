package com.example.visao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendaDTO {

    private Long id;
    private String cursoOferecido;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDatetime horarioInicio;
    private LocalDateTime horarioFim;
    private String professoResponsavel;
    private String cidade;
    private String estado;
    private String cep;
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
    public LocalDatetime getHorarioInicio() {
        return horarioInicio;
    }
    public void setHorarioInicio(LocalDatetime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    public LocalDateTime getHorarioFim() {
        return horarioFim;
    }
    public void setHorarioFim(LocalDateTime horarioFim) {
        this.horarioFim = horarioFim;
    }
    public String getProfessoResponsavel() {
        return professoResponsavel;
    }
    public void setProfessoResponsavel(String professoResponsavel) {
        this.professoResponsavel = professoResponsavel;
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
    
}
