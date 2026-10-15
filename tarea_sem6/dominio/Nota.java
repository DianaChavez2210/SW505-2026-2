package dominio;

import excepciones.ValidacionException;

public record Nota(
        Alumno alumno, 
        Curso curso, 
        Periodo periodo, 
        double calificacion) {
    public Nota {
        //Validaciones
        if (alumno == null) {
            throw new ValidacionException("El alumno es obligatorio");
        }
        if (curso == null) {
            throw new ValidacionException("El curso es obligatorio");
        }
        if (periodo == null) {
            throw new ValidacionException("El periodo es obligatorio");
        }
        if(calificacion < 0 || calificacion > 20) {
            throw new ValidacionException("La calificacion debe estar entre cero y veinte");
        }
    }
    
    public boolean esAprobatoria() {
        return calificacion >= 10;
    }
    
}