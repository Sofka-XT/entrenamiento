package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.DirectricesFactory;
import co.com.sofkau.entrenamiento.curso.values.Directriz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class DirectrizAgregadasAMentoria extends DomainEvent {
    private final MentoriaId mentoriaId;
    private final DirectricesFactory factory;

    public DirectrizAgregadasAMentoria(MentoriaId mentoriaId, DirectricesFactory factory) {
        super("co.com.sofkau.entrenamiento.DirectrizAgregadaAMentoria");
        this.mentoriaId = mentoriaId;
        this.factory = factory;
    }


    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public DirectricesFactory getDirectricesFactory() {
        return factory;
    }
}
