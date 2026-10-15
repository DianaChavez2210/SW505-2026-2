package repositorio.impl;

import dominio.Periodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import repositorio.RepositorioPeriodo;

public class RepositorioPeriodoMemoria implements RepositorioPeriodo {

    private final List<Periodo> periodos = new ArrayList<>();

    @Override
    public void guardar(Periodo periodo) {
        periodos.add(Objects.requireNonNull(periodo));
    }

    @Override
    public Periodo buscarPorCodigo(String codigo) {
        for (Periodo periodo : periodos) {
            if (periodo.codigo().equals(codigo)) {
                return periodo;
            }
        }
        return null;
    }

    @Override
    public List<Periodo> listar() {
        return List.copyOf(periodos);
    }
}