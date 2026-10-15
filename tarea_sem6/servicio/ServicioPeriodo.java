package servicio;

import dominio.Periodo;
import excepciones.ValidacionException;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioPeriodo;

public class ServicioPeriodo {

    private final RepositorioPeriodo repositorio;

    public ServicioPeriodo(RepositorioPeriodo repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio);
    }

    public void registrar(Periodo periodo) {
        if (periodo == null) {
            throw new ValidacionException("El periodo es obligatorio");
        }

        repositorio.guardar(periodo);
    }

    public List<Periodo> listar() {
        return repositorio.listar();
    }
}