package servicio;

import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Matricula;
import dominio.Periodo;
import java.util.List;
import repositorio.RepositorioAlumno;
import repositorio.RepositorioCurso;
import repositorio.RepositorioDocente;
import repositorio.RepositorioMatricula;
import repositorio.RepositorioPeriodo;
import repositorio.impl.RepositorioAlumnoMemoria;
import repositorio.impl.RepositorioCursoMemoria;
import repositorio.impl.RepositorioDocenteMemoria;
import repositorio.impl.RepositorioMatriculaMemoria;
import repositorio.impl.RepositorioPeriodoMemoria;

public class SistemaAcademico {

    private final ServicioAlumno alumnos;
    private final ServicioDocente docentes;
    private final ServicioCurso cursos;
    private final ServicioPeriodo periodos;
    private final ServicioMatricula matriculas;

    public SistemaAcademico() {
        RepositorioAlumno repoAlumnos = new RepositorioAlumnoMemoria();
        RepositorioDocente repoDocentes = new RepositorioDocenteMemoria();
        RepositorioCurso repoCursos = new RepositorioCursoMemoria();
        RepositorioPeriodo repoPeriodos = new RepositorioPeriodoMemoria();
        RepositorioMatricula repoMatriculas = new RepositorioMatriculaMemoria();

        alumnos = new ServicioAlumno(repoAlumnos);
        docentes = new ServicioDocente(repoDocentes);
        cursos = new ServicioCurso(repoCursos);
        periodos = new ServicioPeriodo(repoPeriodos);

        matriculas = new ServicioMatricula(
                repoMatriculas, repoAlumnos, repoCursos, repoDocentes, repoPeriodos);
    }

    public void registrarAlumno(Alumno alumno) {
        alumnos.registrar(alumno);
    }

    public void registrarDocente(Docente docente) {
        docentes.registrar(docente);
    }

    public void registrarCurso(Curso curso) {
        cursos.registrar(curso);
    }

    public void registrarPeriodo(Periodo periodo) {
        periodos.registrar(periodo);
    }

    public Matricula matricularAlumno(
            String codigoAlumno, String codigoCurso,
            String codigoDocente, String codigoPeriodo) {

        return matriculas.matricular(
                codigoAlumno, codigoCurso, codigoDocente, codigoPeriodo);
    }

    public void registrarNota(int idMatricula, double calificacion) {
        matriculas.registrarNota(idMatricula, calificacion);
    }

    public List<Alumno> listarAlumnos() {
        return alumnos.listar();
    }

    public List<Docente> listarDocentes() {
        return docentes.listar();
    }

    public List<Curso> listarCursos() {
        return cursos.listar();
    }

    public List<Periodo> listarPeriodos() {
        return periodos.listar();
    }

    public List<Matricula> listarMatriculasPorPeriodo(String codigoPeriodo) {
        return matriculas.porPeriodo(codigoPeriodo);
    }

    public List<Matricula> historialAlumno(String codigoAlumno) {
        return matriculas.historialAlumno(codigoAlumno);
    }

    public List<Matricula> historialCurso(String codigoCurso) {
        return matriculas.historialCurso(codigoCurso);
    }

    public double obtenerPromedioMatricula(int idMatricula) {
        return matriculas.obtenerPromedio(idMatricula);
    }
}