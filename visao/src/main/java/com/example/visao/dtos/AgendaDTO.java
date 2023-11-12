package com.example.visao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.visao.dtos.DadosAgendaDTO.DadosAgendaDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
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
}
