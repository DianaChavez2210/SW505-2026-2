´public class Alumno { 
    private int cod_alumno; 
    private string nom_alumno;
    private int ciclo_realtivo;
    private estado;   
}

public class Curso {
    private int codigo; 
    private string nombre;        
}


class Profesor{
    private int cod_profesor; 
    private string nom_profesor; 
}
//clase intermedia
class Horario{ 
    Profesor profesor; 
    Curso curso[];
    public string hora_clase;

    public static void vincular(Profesor profesor, Curso curso, string hora_clase){
        System.out.println("Horario")
        System.out.println(profesor)
        System.out.println(curso)
        System.out.println(hora_clase)    
    }
}

public class Matricula { 
    private int cod_matricula; 
    Alumno alumno; 
    Horario horario[];
    public int creditos_permitidos;     

    public static void matricular(Alumno alumno, Horario horario, int creditos_permitidos){
        int creditos_matriculados = 0;
        for (i=0; i <= creditos_permitidos;i++){
        
            System.out.println("Matriculo en " + horario)  
        }
          
    }

}



