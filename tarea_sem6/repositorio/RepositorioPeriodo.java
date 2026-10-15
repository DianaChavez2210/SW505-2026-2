package repositorio;

import dominio.Periodo;
import java.util.List;

public interface RepositorioPeriodo {
    void guardar(Periodo periodo);

    // Devuelve null cuando el codigo no existe.
    Periodo buscarPorCodigo(String codigo);

    List<Periodo> listar();
}