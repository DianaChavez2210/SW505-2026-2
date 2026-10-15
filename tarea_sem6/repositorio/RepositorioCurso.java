package repositorio;

import dominio.Curso;
import java.util.List;

public interface RepositorioCurso {
    void guardar(Curso curso);

    // Devuelve null cuando el codigo no existe.
    Curso buscarPorCodigo(String codigo);

    List<Curso> listar();
}