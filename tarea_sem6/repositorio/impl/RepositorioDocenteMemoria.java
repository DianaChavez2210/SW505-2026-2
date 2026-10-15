package repositorio.impl;

import dominio.Docente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioDocente;

public class RepositorioDocenteMemoria implements RepositorioDocente {

    private final List<Docente> docentes = new ArrayList<>();

    @Override
    public void guardar(Docente docente) {
        docentes.add(Objects.requireNonNull(docente));
    }

    @Override
    public Docente buscarPorCodigo(String codigo) {
        for (Docente docente : docentes) {
            if (docente.codigo().equals(codigo)) {
                return docente;
            }
        }
        return null;
    }

    @Override
    public List<Docente> listar() {
        return List.copyOf(docentes);
    }
}