/**
 * Clase de ejemplo que contiene métodos matemáticos básicos.
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Ejem1 {
    
    /**
     * Calcula el factorial de un número entero no negativo.
     * <p>
     * Por ejemplo: el factorial de 5 (5!) es 1 * 2 * 3 * 4 * 5 = 120.
     * </p>
     * 
     * @param n El número entero del cual se quiere calcular el factorial.
     * @return El resultado del factorial como un número entero.
     */
    
    public int factorial(int n){
        int f = 1; 
        for (int i = 1; i <= n; i++){
            f = f * i;
        }
        return f; 
    } 

}
