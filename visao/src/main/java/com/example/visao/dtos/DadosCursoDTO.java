package com.example.visao.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosCursoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String ementa;
    private String objetivos;
    private Integer cargaHoraria;
    private CategoriaCursoDTO categoria;
}