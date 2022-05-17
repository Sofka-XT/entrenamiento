package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Promedio;


public class CursoFinalizado extends DomainEvent {
    private final Promedio promedio;
    private final ProgramaId programaId;

    public CursoFinalizado(Promedio promedio, ProgramaId programaId) {
        super("co.com.sofkau.entrenamiento.CursoFinalizado");
        this.promedio = promedio;
        this.programaId = programaId;
    }

    public Promedio getPromedio() {
        return promedio;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
