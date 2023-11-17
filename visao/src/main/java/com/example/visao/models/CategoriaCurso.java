package com.example.visao.models;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaCurso {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty(message = "Não pode ser vazio esta porra")
        private String nome;

        @OneToMany(mappedBy = "categoriaCurso")
        private List<Curso> cursos;
        @Override
        public String toString() {
        return "CategoriaCurso [id=" + id + ", nome=" + nome + "]";
        }
}