package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadaAMentoria;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;

import java.util.HashMap;
import java.util.HashSet;

public class CursoEventChange extends EventChange {
    public CursoEventChange(Curso curso) {
        apply((CursoCreado event) ->{
            curso.nombre = event.getNombre();
            curso.descripcion = event.getDescripcion();
            curso.contenidos = new HashSet<>();
            curso.mentorias = new HashMap<>();
        });

        apply((MentoriaCreada event) -> {
            var mentoriaId = event.getMentoriaId();
            var mentoria = new Mentoria(mentoriaId, event.getNombre(), event.getFecha());
            //TODO: validar que no pueda tener mas de 10 mentorias por curso
            curso.mentorias.put(mentoriaId, mentoria);
        });

        apply((DirectrizAgregadaAMentoria event) -> {
            curso.mentorias.get(event.getMentoriaId()).agregarDirectiz(event.getDirectiz());
        });
    }
}
