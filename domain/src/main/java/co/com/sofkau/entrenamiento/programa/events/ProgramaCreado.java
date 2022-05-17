package co.com.sofkau.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;

public class ProgramaCreado extends DomainEvent {
    private final Nombre nombre;
    private final Fecha fecha;

    public ProgramaCreado(Nombre nombre, Fecha fecha) {
        super("co.com.sofkau.entrenamiento.ProgramaCreado");
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
