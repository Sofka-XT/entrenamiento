package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Nombre;

public class CursoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final ProgramaId programaId;

    public CursoCreado(Nombre nombre, Descripcion descripcion, ProgramaId programaId) {
        super("co.com.sofkau.entrenamiento.CursoCreado");
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.programaId = programaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
