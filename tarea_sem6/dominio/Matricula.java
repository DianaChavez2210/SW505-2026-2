package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import excepciones.ValidacionException;

public class Matricula {
    private int id_matricula;
    private static int contador_matricula = 0; // variable contador de matricula
                                               // Esto es para tener el ultimo valor del autocorrelativo 
    private Alumno alumno;
    private Periodo periodo;
    private Curso curso;
    private Docente docente;
    private LocalDate fecha;
    private EstadoMatricula estado;
    private List<Nota> notas = new ArrayList<>();

    public Matricula(Alumno alumno, Periodo periodo, Curso curso, Docente docente) {
            if (alumno == null) {
                throw new ValidacionException("El alumno es obligatorio");
            }

            if (periodo == null) {
                throw new ValidacionException("El periodo es obligatorio");
            }

            if (curso == null) {
                throw new ValidacionException("El curso es obligatorio");
            }

            if (docente == null) {
                throw new ValidacionException("El docente es obligatorio");
            }
        // Entra en bruto los valores ya validados
        contador_matricula++; // Nueva matricula, => aumentar el contador
        this.id_matricula = contador_matricula; // asignar el valor del contador
        this.alumno = alumno;
        this.periodo = periodo;
        this.curso = curso;
        this.docente = docente;
        this.fecha = LocalDate.now();
        this.estado = EstadoMatricula.ACTIVA;
    }
    
    // Consultas (Query)

    public Alumno alumno() {
        return alumno;
    }

    public Curso curso() {
        return curso;
    }

    public Periodo periodo() {
        return periodo;
    }

    public int idMatricula() {
        return id_matricula;
    }
    
    public String codigoAlumno() {
        return alumno.codigo();
    }
        
    public String nombreCompletoAlumno() {
        return alumno.nombreCompleto();
    }
    
    public String codigoCurso() {
        return curso.codigo();
    }
    
    public String codigoDocente() {
        return docente.codigo();
    }
    
    public String codigoPeriodo() {
        return periodo.codigo();
    }
    
    public String descripcionPeriodo() {
        return periodo.descripcion();
    }
    
    public String estadoMatricula() {
        switch(estado) {
            case EstadoMatricula.ACTIVA: return "ACTIVA";
            case EstadoMatricula.CANCELADA: return "CANCELADA";
            case EstadoMatricula.ANULADA: return "ANULADA";
            case EstadoMatricula.NO_MATRICULADO: return "NO MATRICULADO";
            case EstadoMatricula.RETIRADA: return "RETIRADO";   
        }
        return "";  // Aquí nunca se debería llegar
    }

    public double calcularPromedio() {
        if(notas.isEmpty()) {
            throw new ValidacionException("No hay notas registradas para calcular el promedio");
        }
        double suma = 0;
        for(Nota nota : notas) {
            suma += nota.calificacion();
        }
        return suma / notas.size();
    }
    
    // Commands
    public void retirarMatricula() {
        if(estado != EstadoMatricula.ACTIVA) {
            throw new ValidacionException("Solo se puede retirar una matrícula activa");
        }
        this.estado = EstadoMatricula.RETIRADA;
    }
    
    public void agregarNota(Nota nota) {
        // deja pasar solo si la matricula esta activa
        if(!estado.permiteCalificaciones()) { // Si no permite calificaciones, salir de la función con una llamada de error
            throw new ValidacionException("No se puede agregar notas a una matricula con estado " + estado);
        }
        
        notas.add(nota); // agregar la nota
    }
    
    public void anularMatricula() {
        if(estado != EstadoMatricula.ACTIVA) {
            throw new ValidacionException("Solo se puede anular una matrícula activa");
        }
        this.estado = EstadoMatricula.ANULADA;
    }
    
}
