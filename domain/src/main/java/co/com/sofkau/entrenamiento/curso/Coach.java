package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.entrenamiento.curso.values.CoachId;

public class Coach extends Entity<CoachId> {
    public Coach(CoachId entityId) {
        super(entityId);
    }
}
