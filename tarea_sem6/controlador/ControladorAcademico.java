package controlador;

import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Periodo;
import servicio.SistemaAcademico;
import vista.VistaConsola;

public class ControladorAcademico {

    private final VistaConsola vista;
    private final SistemaAcademico sistema;

    public ControladorAcademico(
            VistaConsola vista,
            SistemaAcademico sistema) {

        this.vista = vista;
        this.sistema = sistema;
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            opcion = vista.leerOpcion();

            try {

                switch (opcion) {

                    case 1 ->
                            registrarAlumno();

                    case 2 ->
                            registrarDocente();

                    case 3 ->
                            registrarCurso();

                    case 4 ->
                            registrarPeriodo();

                    case 5 ->
                            matricularAlumno();

                    case 6 ->
                            registrarNota();

                    case 7 ->
                            listarAlumnos();

                    case 8 ->
                            listarDocentes();

                    case 9 ->
                            listarCursos();

                    case 10 ->
                            listarMatriculasPorPeriodo();

                    case 11 ->
                            verHistorialAlumno();

                    case 12 ->
                            verPromedioMatricula();

                    case 0 ->
                            vista.mostrarMensaje(
                                    "Saliendo del sistema..."
                            );

                    default ->
                            vista.mostrarMensaje(
                                    "Opción inválida."
                            );
                }

            } catch (Exception e) {

                vista.mostrarMensaje(
                        "Error: " + e.getMessage()
                );
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {

        vista.mostrarTitulo(
                "SISTEMA ACADÉMICO"
        );

        System.out.println(
                "1.  Registrar alumno"
        );

        System.out.println(
                "2.  Registrar docente"
        );

        System.out.println(
                "3.  Registrar curso"
        );

        System.out.println(
                "4.  Registrar período"
        );

        System.out.println(
                "5.  Matricular alumno"
        );

        System.out.println(
                "6.  Registrar nota"
        );

        System.out.println(
                "7.  Listar alumnos"
        );

        System.out.println(
                "8.  Listar docentes"
        );

        System.out.println(
                "9.  Listar cursos"
        );

        System.out.println(
                "10. Listar matrículas por período"
        );

        System.out.println(
                "11. Ver historial de un alumno"
        );

        System.out.println(
                "12. Ver promedio de una matrícula"
        );

        System.out.println(
                "0.  Salir"
        );
    }

    public void registrarAlumno() {

        Alumno alumno =
                vista.registrarAlumno();

        sistema.registrarAlumno(alumno);

        vista.mostrarMensaje(
                "Alumno registrado correctamente."
        );
    }

    public void registrarDocente() {

        Docente docente =
                vista.registrarDocente();

        sistema.registrarDocente(docente);

        vista.mostrarMensaje(
                "Docente registrado correctamente."
        );
    }

    public void registrarCurso() {

        Curso curso =
                vista.registrarCurso();

        sistema.registrarCurso(curso);

        vista.mostrarMensaje(
                "Curso registrado correctamente."
        );
    }

    public void registrarPeriodo() {

        Periodo periodo =
                vista.registrarPeriodo();

        sistema.registrarPeriodo(periodo);

        vista.mostrarMensaje(
                "Período registrado correctamente."
        );
    }

    public void matricularAlumno() {

        String codigoAlumno =
                vista.pedirCodigoAlumno();

        String codigoCurso =
                vista.pedirCodigoCurso();

        String codigoDocente =
                vista.pedirCodigoDocente();

        String codigoPeriodo =
                vista.pedirCodigoPeriodo();

        sistema.matricularAlumno(
                codigoAlumno,
                codigoCurso,
                codigoDocente,
                codigoPeriodo
        );

        vista.mostrarMensaje(
                "Matrícula registrada correctamente."
        );
    }

    public void registrarNota() {

        int idMatricula =
                vista.pedirIdMatricula();

        double calificacion =
                vista.pedirCalificacion();

        sistema.registrarNota(
                idMatricula,
                calificacion
        );

        vista.mostrarMensaje(
                "Nota registrada correctamente."
        );
    }

    public void listarAlumnos() {

        vista.mostrarAlumnos(
                sistema.listarAlumnos()
        );
    }

    // OPCIÓN 8

    public void listarDocentes() {

        vista.mostrarDocentes(
                sistema.listarDocentes()
        );
    }

    // OPCIÓN 9

    public void listarCursos() {

        vista.mostrarCursos(
                sistema.listarCursos()
        );
    }

    // OPCIÓN 10

    public void listarMatriculasPorPeriodo() {

        String codigoPeriodo =
                vista.pedirCodigoPeriodo();

        vista.mostrarMatriculas(
                sistema.listarMatriculasPorPeriodo(
                        codigoPeriodo
                )
        );
    }

    // OPCIÓN 11

    public void verHistorialAlumno() {

        String codigoAlumno =
                vista.pedirCodigoAlumno();

        vista.mostrarHistorialAlumno(
                sistema.historialAlumno(
                        codigoAlumno
                )
        );
    }

    // OPCIÓN 12

    public void verPromedioMatricula() {

        int idMatricula =
                vista.pedirIdMatricula();

        double promedio =
                sistema.obtenerPromedioMatricula(
                        idMatricula
                );

        vista.mostrarPromedio(promedio);
    }
}