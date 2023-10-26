package com.example.visao.models;
import java.util.List;

import com.example.visao.validations.NomeCursoValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    @NomeCursoValidation(message = "Nome do curso fora do padrão")
    private String nome;

    @Column(length = 200, nullable = false)
    @NotEmpty(message = "Descricao Obrigatoria")
    private String descricao;

    // @Size(min = 0, max = 4000)
    @Min(value = 0, message = "Valor minimo é 0")
    @Max(value = 4000, message = "Valor maximo é 4000" )
    @Column(nullable = false)
    private int cargaHoraria;

    @Column(length = 200, nullable = false)
    @NotEmpty(message = "Objetivos obrigatórios")
    private String objetivos;

    @Column(length = 200, nullable = false)
    private String ementa;

    @ManyToMany
    private List<Professor> professor;

    @OneToMany(mappedBy = "curso")
    List<Agenda> agenda;
    
}
