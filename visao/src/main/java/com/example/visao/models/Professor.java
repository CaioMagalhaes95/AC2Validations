package com.example.visao.models;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(nullable = false)
    @CPF(message = "Informe um CPF valido")
    private Long cpf;

    @Column(nullable = false)
    private Long rg;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Long celular;

    @ManyToMany(mappedBy = "professor")
    private List<Curso> Curso;

    @OneToMany(mappedBy = "professor")
    List<Agenda> agenda;
}
