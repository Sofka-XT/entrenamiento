package co.com.sofkau.entrenamento.curso.services;

import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.generic.values.Promedio;

public interface ConsultarPromedioDeCurso {
    Promedio consultarPorCursoId(CursoId cursoId);
}
