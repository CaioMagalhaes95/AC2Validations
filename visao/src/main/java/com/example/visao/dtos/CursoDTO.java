package com.example.visao.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    
    private Long id;
    private String nome;
    private String descricao;
    private String objetivos;
    private String ementa;
    private Integer cargaHoraria;

}
