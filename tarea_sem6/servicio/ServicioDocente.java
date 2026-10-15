package servicio;

import dominio.Docente;
import excepciones.ValidacionException;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioDocente;

public class ServicioDocente {

    private final RepositorioDocente repositorio;

    public ServicioDocente(RepositorioDocente repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio);
    }

    public void registrar(Docente docente) {
        if (docente == null) {
            throw new ValidacionException("El docente es obligatorio");
        }

        repositorio.guardar(docente);
    }

    public List<Docente> listar() {
        return repositorio.listar();
    }
}