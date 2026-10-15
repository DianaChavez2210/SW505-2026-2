package repositorio;

import dominio.Docente;
import java.util.List;

public interface RepositorioDocente {
    void guardar(Docente docente);

    // Devuelve null cuando el codigo no existe.
    Docente buscarPorCodigo(String codigo);

    List<Docente> listar();
}
