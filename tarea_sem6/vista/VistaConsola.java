package vista;

import dominio.Alumno;
import dominio.Curso;
import dominio.Docente;
import dominio.Matricula;
import dominio.Periodo;

import java.util.List;
import java.util.Scanner;

public class VistaConsola {

    private final Scanner scanner = new Scanner(System.in);

    // REGISTROS

    public Alumno registrarAlumno() {

        System.out.println(
                "\n--- REGISTRAR ALUMNO ---"
        );

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        return new Alumno(
                codigo,
                nombres,
                apellidos,
                edad,
                carrera
        );
    }

    public Docente registrarDocente() {

        System.out.println(
                "\n--- REGISTRAR DOCENTE ---"
        );

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        return new Docente(
                codigo,
                nombres,
                apellidos,
                especialidad
        );
    }

    public Curso registrarCurso() {

        System.out.println(
                "\n--- REGISTRAR CURSO ---"
        );

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Créditos: ");
        int creditos = Integer.parseInt(
                scanner.nextLine()
        );

        System.out.print(
                "¿Curso activo? (true/false): "
        );

        boolean estado = Boolean.parseBoolean(
                scanner.nextLine()
        );

        return new Curso(
                codigo,
                nombre,
                creditos,
                estado
        );
    }

    public Periodo registrarPeriodo() {

        System.out.println(
                "\n--- REGISTRAR PERÍODO ---"
        );

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        return new Periodo(
                codigo,
                descripcion
        );
    }

    // ENTRADAS

    public String pedirCodigoAlumno() {
        System.out.print("Código del alumno: ");
        return scanner.nextLine();
    }

    public String pedirCodigoCurso() {
        System.out.print("Código del curso: ");
        return scanner.nextLine();
    }

    public String pedirCodigoDocente() {
        System.out.print("Código del docente: ");
        return scanner.nextLine();
    }

    public String pedirCodigoPeriodo() {
        System.out.print("Código del período: ");
        return scanner.nextLine();
    }

    public int pedirIdMatricula() {
        System.out.print("ID de matrícula: ");

        return Integer.parseInt(
                scanner.nextLine()
        );
    }

    public double pedirCalificacion() {
        System.out.print("Calificación: ");

        return Double.parseDouble(
                scanner.nextLine()
        );
    }

    public int leerOpcion() {
        System.out.print(
                "\nSeleccione una opción: "
        );

        return Integer.parseInt(
                scanner.nextLine()
        );
    }

    // SALIDAS

    public void mostrarTitulo(String titulo) {

        System.out.println(
                "\n=============================="
        );

        System.out.println(titulo);

        System.out.println(
                "=============================="
        );
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarAlumnos(
            List<Alumno> alumnos) {

        System.out.println(
                "\n--- LISTA DE ALUMNOS ---"
        );

        if (alumnos.isEmpty()) {
            System.out.println(
                    "No hay alumnos registrados."
            );
            return;
        }

        for (Alumno alumno : alumnos) {

            System.out.println(
                    alumno.codigo() + " - " +
                    alumno.nombreCompleto() + " - " +
                    alumno.carrera()
            );
        }
    }

    // OPCIÓN 8

    public void mostrarDocentes(
            List<Docente> docentes) {

        System.out.println(
                "\n--- LISTA DE DOCENTES ---"
        );

        if (docentes.isEmpty()) {
            System.out.println(
                    "No hay docentes registrados."
            );
            return;
        }

        for (Docente docente : docentes) {

            System.out.println(
                    docente.codigo() + " - " +
                    docente.nombreCompleto() + " - " +
                    docente.especialidad()
            );
        }
    }

    // OPCIÓN 9

    public void mostrarCursos(
            List<Curso> cursos) {

        System.out.println(
                "\n--- LISTA DE CURSOS ---"
        );

        if (cursos.isEmpty()) {
            System.out.println(
                    "No hay cursos registrados."
            );
            return;
        }

        for (Curso curso : cursos) {

            System.out.println(
                    curso.codigo() + " - " +
                    curso.nombre() + " - " +
                    curso.creditos() +
                    " créditos"
            );
        }
    }

    // OPCIÓN 10

    public void mostrarMatriculas(
            List<Matricula> matriculas) {

        System.out.println(
                "\n--- MATRÍCULAS DEL PERÍODO ---"
        );

        if (matriculas.isEmpty()) {

            System.out.println(
                    "No hay matrículas registradas " +
                    "para ese período."
            );

            return;
        }

        for (Matricula matricula : matriculas) {

            System.out.println(
                    "ID: " +
                    matricula.idMatricula() +

                    " - Alumno: " +
                    matricula.nombreCompletoAlumno() +

                    " - Curso: " +
                    matricula.codigoCurso() +

                    " - Estado: " +
                    matricula.estadoMatricula()
            );
        }
    }

    // OPCIÓN 11

    public void mostrarHistorialAlumno(
            List<Matricula> matriculas) {

        System.out.println(
                "\n--- HISTORIAL DEL ALUMNO ---"
        );

        if (matriculas.isEmpty()) {

            System.out.println(
                    "El alumno no tiene " +
                    "matrículas registradas."
            );

            return;
        }

        for (Matricula matricula : matriculas) {

            System.out.println(
                    "ID: " +
                    matricula.idMatricula() +

                    " - Período: " +
                    matricula.codigoPeriodo() +

                    " - Curso: " +
                    matricula.codigoCurso() +

                    " - Estado: " +
                    matricula.estadoMatricula()
            );
        }
    }

    // OPCIÓN 12

    public void mostrarPromedio(
            double promedio) {

        System.out.println(
                "Promedio de la matrícula: " +
                promedio
        );
    }
}