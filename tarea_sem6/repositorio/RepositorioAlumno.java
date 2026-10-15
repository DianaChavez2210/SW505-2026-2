package repositorio;

import dominio.Alumno;
import java.util.List;

public interface RepositorioAlumno {
    void guardar(Alumno alumno);

    // Devuelve null cuando el codigo no existe.
    Alumno buscarPorCodigo(String codigo);

    List<Alumno> listar();
}