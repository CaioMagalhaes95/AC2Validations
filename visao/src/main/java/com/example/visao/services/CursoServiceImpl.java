package com.example.visao.services;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.visao.dtos.CategoriaCursoDTO;
import com.example.visao.dtos.CursoDTO;
import com.example.visao.dtos.DadosCursoDTO;
import com.example.visao.exceptions.RegradeNegocioException;
import com.example.visao.models.CategoriaCurso;
import com.example.visao.models.Curso;
import com.example.visao.repositories.CategoriaCursoRepository;
import com.example.visao.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    @Transactional
    public Curso findCurso(Long id){
        Curso cursos = cursoRepository.findCurso(id);
        
        return cursos;
    }

    @Override
    @Transactional
    public Curso salvar(CursoDTO cursoDTO) {
   
    Curso curso = new Curso();
    curso.setId(cursoDTO.getId());
    curso.setDescricao(cursoDTO.getDescricao());
    curso.setCargaHoraria(cursoDTO.getCargaHoraria());
    curso.setObjetivos(cursoDTO.getObjetivos());
    curso.setEmenta(cursoDTO.getEmenta());

    return cursoRepository.save(curso);
}



    
    @Override
    public List<DadosCursoDTO> obterTodos() {
    return cursoRepository.findAll().stream().map((Curso c) -> {
    return DadosCursoDTO.builder()
        .id(c.getId())
        .descricao(c.getDescricao())
        .cargaHoraria(c.getCargaHoraria())
        .objetivos(c.getObjetivos())
        .ementa(c.getEmenta())
        
        .build();
    }).collect(Collectors.toList());
}





        @Override
        public DadosCursoDTO obterCursoPorId(Long id) {
        return cursoRepository.findById(id).map((Curso c) -> {
        return DadosCursoDTO.builder()
        .id(c.getId())
        .nome(c.getDescricao())
        .cargaHoraria(c.getCargaHoraria())
        .categoria(CategoriaCursoDTO.builder()
        .id(c.getCategoriaCurso().getId())
        .nome(c.getCategoriaCurso().getNome())
        .build())
        .build();
        }).orElseThrow(() -> new RegradeNegocioException("Curso não encontrado."));
        }

            @Override
            @Transactional
            public void remover(Long id) {
            cursoRepository.deleteById(id);
            }

    @Override
    @Transactional
    public void editar(Long id, CursoDTO cursoDto) {
        Curso curso = cursoRepository.findById(id)
        .orElseThrow(() -> new RegradeNegocioException("Curso não encontrado"));
        CategoriaCurso categoria = categoriaCursoRepository.findById(
        cursoDto.getCategoriaCursoId())
        .orElseThrow(() -> new RegradeNegocioException("Categoria não encontrada"));
        curso.setDescricao(cursoDto.getNome());
        curso.setCargaHoraria(cursoDto.getCargaHoraria());
        curso.setCategoriaCurso(categoria);
        cursoRepository.save(curso);
    }

}

