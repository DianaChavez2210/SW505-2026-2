package repositorio.impl;

import dominio.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioCurso;

public class RepositorioCursoMemoria implements RepositorioCurso {

    private final List<Curso> cursos = new ArrayList<>();

    @Override
    public void guardar(Curso curso) {
        cursos.add(Objects.requireNonNull(curso));
    }

    @Override
    public Curso buscarPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.codigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> listar() {
        return List.copyOf(cursos);
    }
}