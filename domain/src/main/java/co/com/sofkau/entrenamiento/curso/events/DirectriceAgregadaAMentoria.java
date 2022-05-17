package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.values.Directriz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class DirectriceAgregadaAMentoria extends DomainEvent {
    private final MentoriaId mentoriaId;
    private final Directriz directiz;

    public DirectriceAgregadaAMentoria(MentoriaId mentoriaId, Directriz directiz) {
        super("co.com.sofkau.entrenamiento.DirectrizAgregadaAMentoria");
        this.mentoriaId = mentoriaId;
        this.directiz = directiz;
    }


    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public Directriz getDirectiz() {
        return directiz;
    }
}
