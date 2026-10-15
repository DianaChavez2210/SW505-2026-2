package servicio;

import dominio.Curso;
import excepciones.ValidacionException;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioCurso;

public class ServicioCurso {

    private final RepositorioCurso repositorio;

    public ServicioCurso(RepositorioCurso repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio);
    }

    public void registrar(Curso curso) {
        if (curso == null) {
            throw new ValidacionException("El curso es obligatorio");
        }

        repositorio.guardar(curso);
    }

    public List<Curso> listar() {
        return repositorio.listar();
    }
}