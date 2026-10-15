package repositorio.impl;

import dominio.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioAlumno;

public class RepositorioAlumnoMemoria implements RepositorioAlumno {

    private final List<Alumno> alumnos = new ArrayList<>();

    @Override
    public void guardar(Alumno alumno) {
        alumnos.add(Objects.requireNonNull(alumno));
    }

    @Override
    public Alumno buscarPorCodigo(String codigo) {
        for (Alumno alumno : alumnos) {
            if (alumno.codigo().equals(codigo)) {
                return alumno;
            }
        }
        return null;
    }

    @Override
    public List<Alumno> listar() {
        return List.copyOf(alumnos);
    }
}