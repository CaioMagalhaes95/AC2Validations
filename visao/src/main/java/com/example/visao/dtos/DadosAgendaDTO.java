package com.example.visao.dtos;

import java.sql.Date;
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
public class DadosAgendaDTO {

    private Long id;
    private String cursoOferecido;
    private LocalDate dataInicio;
    private LocalDate dataFim;
   // private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private String professor;
    private String cidade;
    private String estado;
    private String cep;
    
}