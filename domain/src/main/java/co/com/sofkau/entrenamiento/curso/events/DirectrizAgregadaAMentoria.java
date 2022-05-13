package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.values.Directiz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class DirectrizAgregadaAMentoria extends DomainEvent {
    private final MentoriaId mentoriaId;
    private final Directiz directiz;

    public DirectrizAgregadaAMentoria(MentoriaId mentoriaId, Directiz directiz) {
        super("co.com.sofkau.entrenamiento.DirectrizAgregadaAMentoria");
        this.mentoriaId = mentoriaId;
        this.directiz = directiz;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public Directiz getDirectiz() {
        return directiz;
    }
}
