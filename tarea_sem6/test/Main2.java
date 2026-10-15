package test;

import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Matricula;
import dominio.Periodo;
import servicio.SistemaAcademico;

public class Main2 {

    public static void main(String[] args) {

        SistemaAcademico sistema = new SistemaAcademico();

        // =========================
        // 1. REGISTRAR ALUMNOS
        // =========================
        Alumno alumno1 = new Alumno(
                "A001",
                "Carlos",
                "Pérez",
                20,
                "Ingeniería de Software"
        );

        Alumno alumno2 = new Alumno(
                "A002",
                "Ana",
                "Torres",
                19,
                "Ingeniería Industrial"
        );

        sistema.registrarAlumno(alumno1);
        sistema.registrarAlumno(alumno2);

        // =========================
        // 2. REGISTRAR DOCENTES
        // =========================
        Docente docente1 = new Docente(
                "D001",
                "Luis",
                "Guevara",
                "Construcción de Software"
        );

        Docente docente2 = new Docente(
                "D002",
                "María",
                "López",
                "Base de Datos"
        );

        sistema.registrarDocente(docente1);
        sistema.registrarDocente(docente2);

        // =========================
        // 3. REGISTRAR CURSOS
        // =========================
        Curso curso1 = new Curso(
                "C001",
                "Construcción de Software",
                4,
                true
        );

        Curso curso2 = new Curso(
                "C002",
                "Base de Datos",
                4,
                true
        );

        sistema.registrarCurso(curso1);
        sistema.registrarCurso(curso2);

        // =========================
        // 4. REGISTRAR PERIODOS
        // =========================
        Periodo periodo1 = new Periodo(
                "2026-1",
                "Primer semestre 2026"
        );

        Periodo periodo2 = new Periodo(
                "2026-2",
                "Segundo semestre 2026"
        );

        sistema.registrarPeriodo(periodo1);
        sistema.registrarPeriodo(periodo2);

        // =========================
        // 5. MATRICULAR ALUMNOS
        // =========================
        Matricula matricula1 = sistema.matricularAlumno(
                "A001",
                "C001",
                "D001",
                "2026-2"
        );

        Matricula matricula2 = sistema.matricularAlumno(
                "A001",
                "C002",
                "D002",
                "2026-2"
        );

        Matricula matricula3 = sistema.matricularAlumno(
                "A002",
                "C001",
                "D001",
                "2026-1"
        );

        // =========================
        // 6. REGISTRAR NOTAS
        // =========================
        sistema.registrarNota(
                matricula1.idMatricula(),
                18
        );

        sistema.registrarNota(
                matricula1.idMatricula(),
                16
        );

        sistema.registrarNota(
                matricula1.idMatricula(),
                14
        );

        sistema.registrarNota(
                matricula2.idMatricula(),
                12
        );

        sistema.registrarNota(
                matricula2.idMatricula(),
                15
        );

        // =========================
        // 7. LISTAR ALUMNOS
        // =========================
        System.out.println("\n===== ALUMNOS =====");

        sistema.listarAlumnos().forEach(alumno ->
                System.out.println(
                        alumno.codigo() + " - " +
                        alumno.nombreCompleto()
                )
        );

        // =========================
        // 8. LISTAR DOCENTES
        // =========================
        System.out.println("\n===== DOCENTES =====");

        sistema.listarDocentes().forEach(docente ->
                System.out.println(
                        docente.codigo() + " - " +
                        docente.nombreCompleto() + " - " +
                        docente.especialidad()
                )
        );

        // =========================
        // 9. LISTAR CURSOS
        // =========================
        System.out.println("\n===== CURSOS =====");

        sistema.listarCursos().forEach(curso ->
                System.out.println(
                        curso.codigo() + " - " +
                        curso.nombre() + " - " +
                        curso.creditos() + " créditos"
                )
        );

        // =========================
        // 10. MATRÍCULAS POR PERIODO
        // =========================
        System.out.println(
                "\n===== MATRÍCULAS 2026-2 ====="
        );

        sistema.listarMatriculasPorPeriodo(
                "2026-2"
        ).forEach(matricula ->
                System.out.println(
                        "ID: " +
                        matricula.idMatricula() +
                        " - Alumno: " +
                        matricula.nombreCompletoAlumno() +
                        " - Curso: " +
                        matricula.codigoCurso()
                )
        );

        // =========================
        // 11. HISTORIAL DEL ALUMNO
        // =========================
        System.out.println(
                "\n===== HISTORIAL A001 ====="
        );

        sistema.historialAlumno(
                "A001"
        ).forEach(matricula ->
                System.out.println(
                        "ID: " +
                        matricula.idMatricula() +
                        " - Periodo: " +
                        matricula.codigoPeriodo() +
                        " - Curso: " +
                        matricula.codigoCurso()
                )
        );

        // =========================
        // 12. PROMEDIO
        // =========================
        System.out.println(
                "\n===== PROMEDIO MATRÍCULA ====="
        );

        double promedio =
                sistema.obtenerPromedioMatricula(
                        matricula1.idMatricula()
                );

        System.out.println(
                "Promedio matrícula " +
                matricula1.idMatricula() +
                ": " +
                promedio
        );
    }
}
