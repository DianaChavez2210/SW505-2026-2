package servicio;

import dominio.Alumno;
import excepciones.ValidacionException;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioAlumno;

public class ServicioAlumno {

    private final RepositorioAlumno repositorio;

    public ServicioAlumno(RepositorioAlumno repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio);
    }

    public void registrar(Alumno alumno) {
        if (alumno == null) {
            throw new ValidacionException("El alumno es obligatorio");
        }

        repositorio.guardar(alumno);
    }

    public List<Alumno> listar() {
        return repositorio.listar();
    }
}
