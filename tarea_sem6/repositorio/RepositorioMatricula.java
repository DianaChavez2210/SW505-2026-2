package repositorio;

import dominio.Matricula;
import java.util.List;

public interface RepositorioMatricula {
    void guardar(Matricula matricula);

    // Devuelve null cuando el ID no existe.
    Matricula buscarPorId(int idMatricula);

    boolean existe(String codigoAlumno, String codigoCurso, String codigoPeriodo);

    List<Matricula> listar();
    List<Matricula> porPeriodo(String codigoPeriodo);
    List<Matricula> porAlumno(String codigoAlumno);
    List<Matricula> porCurso(String codigoCurso);
}
