package servicio;

import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Matricula;
import dominio.Nota;
import dominio.Periodo;
import excepciones.ValidacionException;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioAlumno;
import repositorio.RepositorioCurso;
import repositorio.RepositorioDocente;
import repositorio.RepositorioMatricula;
import repositorio.RepositorioPeriodo;

public class ServicioMatricula {

    private final RepositorioMatricula matriculas;
    private final RepositorioAlumno alumnos;
    private final RepositorioCurso cursos;
    private final RepositorioDocente docentes;
    private final RepositorioPeriodo periodos;

    public ServicioMatricula(
            RepositorioMatricula matriculas,
            RepositorioAlumno alumnos,
            RepositorioCurso cursos,
            RepositorioDocente docentes,
            RepositorioPeriodo periodos) {

        this.matriculas = Objects.requireNonNull(matriculas);
        this.alumnos = Objects.requireNonNull(alumnos);
        this.cursos = Objects.requireNonNull(cursos);
        this.docentes = Objects.requireNonNull(docentes);
        this.periodos = Objects.requireNonNull(periodos);
    }

    public Matricula matricular(
            String codigoAlumno, String codigoCurso,
            String codigoDocente, String codigoPeriodo) {

        Alumno alumno = alumnos.buscarPorCodigo(codigoAlumno);
        if (alumno == null) {
            throw new ValidacionException("Alumno no encontrado");
        }

        Curso curso = cursos.buscarPorCodigo(codigoCurso);
        if (curso == null) {
            throw new ValidacionException("Curso no encontrado");
        }

        Docente docente = docentes.buscarPorCodigo(codigoDocente);
        if (docente == null) {
            throw new ValidacionException("Docente no encontrado");
        }

        Periodo periodo = periodos.buscarPorCodigo(codigoPeriodo);
        if (periodo == null) {
            throw new ValidacionException("Periodo no encontrado");
        }

        if (matriculas.existe(codigoAlumno, codigoCurso, codigoPeriodo)) {
            throw new ValidacionException(
                    "El alumno " + codigoAlumno + " ya está matriculado en "
                    + codigoCurso + " para el período " + codigoPeriodo);
        }

        Matricula matricula = new Matricula(alumno, periodo, curso, docente);
        matriculas.guardar(matricula);

        return matricula;
    }

    public void registrarNota(int idMatricula, double calificacion) {
        Matricula matricula = buscarMatricula(idMatricula);

        if (!Double.isFinite(calificacion)) {
            throw new ValidacionException(
                    "La calificación debe ser un número finito");
        }

        Nota nota = new Nota(
                matricula.alumno(), matricula.curso(),
                matricula.periodo(), calificacion);

        matricula.agregarNota(nota);
    }

    public List<Matricula> porPeriodo(String codigoPeriodo) {
        return matriculas.porPeriodo(codigoPeriodo);
    }

    public List<Matricula> historialAlumno(String codigoAlumno) {
        return matriculas.porAlumno(codigoAlumno);
    }

    public List<Matricula> historialCurso(String codigoCurso) {
        return matriculas.porCurso(codigoCurso);
    }

    public double obtenerPromedio(int idMatricula) {
        return buscarMatricula(idMatricula).calcularPromedio();
    }

    private Matricula buscarMatricula(int idMatricula) {
        Matricula matricula = matriculas.buscarPorId(idMatricula);

        if (matricula == null) {
            throw new ValidacionException("Matrícula no encontrada");
        }

        return matricula;
    }
}
