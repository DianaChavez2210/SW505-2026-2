package dominio;

import excepciones.ValidacionException;

public record Periodo(
        String codigo,
        String descripcion
        ) {
    
    public Periodo {
        if(codigo == null || codigo.isBlank()) {
            throw new ValidacionException("El codigo del periodo es obligatorio");
        }
        
        if(descripcion == null || descripcion.isBlank()) {
            throw new ValidacionException("La descripcion del periodo es obligatorio");
        }
    }
    
}