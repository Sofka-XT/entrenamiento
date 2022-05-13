package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.values.Fecha;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;
import co.com.sofkau.entrenamiento.curso.values.Nombre;

public class MentoriaCreada extends DomainEvent {
    private final MentoriaId mentoriaId;
    private final Nombre nombre;
    private final Fecha fecha;

    public MentoriaCreada(MentoriaId mentoriaId, Nombre nombre, Fecha fecha) {
        super("co.com.sofkau.entrenamiento.MentoriaCreada");
        this.mentoriaId = mentoriaId;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }
}
