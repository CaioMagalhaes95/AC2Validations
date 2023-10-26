package com.example.visao.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    
    private Long id;
    private String nome;
    private Long cpf;
    private Long rg;
    private String endereco;
    private Long celular;

}