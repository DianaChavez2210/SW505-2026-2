package repositorio.impl;

import dominio.Matricula;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import repositorio.RepositorioMatricula;

public class RepositorioMatriculaMemoria implements RepositorioMatricula {

    private final List<Matricula> matriculas = new ArrayList<>();

    @Override
    public void guardar(Matricula matricula) {
        matriculas.add(Objects.requireNonNull(matricula));
    }

    @Override
    public Matricula buscarPorId(int idMatricula) {
        for (Matricula matricula : matriculas) {
            if (matricula.idMatricula() == idMatricula) {
                return matricula;
            }
        }
        return null;
    }

    @Override
    public boolean existe(
            String codigoAlumno,
            String codigoCurso,
            String codigoPeriodo) {

        for (Matricula matricula : matriculas) {
            if (matricula.codigoAlumno().equals(codigoAlumno)
                    && matricula.codigoCurso().equals(codigoCurso)
                    && matricula.codigoPeriodo().equals(codigoPeriodo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Matricula> listar() {
        return List.copyOf(matriculas);
    }

    @Override
    public List<Matricula> porPeriodo(String codigoPeriodo) {
        return filtrar(m -> m.codigoPeriodo().equals(codigoPeriodo));
    }

    @Override
    public List<Matricula> porAlumno(String codigoAlumno) {
        return filtrar(m -> m.codigoAlumno().equals(codigoAlumno));
    }

    @Override
    public List<Matricula> porCurso(String codigoCurso) {
        return filtrar(m -> m.codigoCurso().equals(codigoCurso));
    }

    private List<Matricula> filtrar(Predicate<Matricula> criterio) {
        List<Matricula> resultado = new ArrayList<>();

        for (Matricula matricula : matriculas) {
            if (criterio.test(matricula)) {
                resultado.add(matricula);
            }
        }

        return List.copyOf(resultado);
    }
}