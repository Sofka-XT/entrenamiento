package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.entrenamiento.curso.events.*;
import co.com.sofkau.entrenamiento.curso.values.EstadoDeCurso;
import co.com.sofkau.generic.values.Promedio;

import java.util.HashMap;
import java.util.HashSet;

public class CursoEventChange extends EventChange {
    public CursoEventChange(Curso curso) {
        apply((CursoCreado event) ->{
            curso.nombre = event.getNombre();
            curso.descripcion = event.getDescripcion();
            curso.contenidos = new HashSet<>();
            curso.mentorias = new HashMap<>();
            curso.estadoDeCurso = new EstadoDeCurso(EstadoDeCurso.Estados.POR_INICIAR);
            curso.promedio = new Promedio(0D);
            curso.programaId = event.getProgramaId();

        });

        apply((MentoriaCreada event) -> {
            var mentoriaId = event.getMentoriaId();
            var mentoria = new Mentoria(mentoriaId, event.getNombre(), event.getFecha());
            curso.mentorias.put(mentoriaId, mentoria);
        });

        apply((DirectriceAgregadaAMentoria event) -> {
            curso.mentorias.get(event.getMentoriaId()).agregarDirectriz(event.getDirectiz());
        });

        apply((DirectrizAgregadasAMentoria event) -> {
            curso.mentorias.get(event.getMentoriaId()).agregarDirectrices(event.getDirectricesFactory());
        });

        apply((CursoFinalizado event) -> {
            curso.promedio = event.getPromedio();
            curso.estadoDeCurso = new EstadoDeCurso(EstadoDeCurso.Estados.FINALIZADO);
        });
    }
}
